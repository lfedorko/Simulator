package src.simulator;

import src.logger.Logger;
import java.io.IOException;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    protected Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() throws IOException {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "RAIN":
                Logger.writeToFile("Baloon#" + this.name + "(" + this.id + "): " + "Rainy days should be spent at home with a cup of tea, not on ballon");
                if (coordinates.getHeight() > 5)
                    this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
                else {
                    Logger.writeToFile("Baloon#" + this.name + "(" + this.id + ") landing.");
                    this.weatherTower.unregister(this);
                    Logger.writeToFile("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower.");
                }
                break;
            case "FOG":
                Logger.writeToFile("Baloon#" + this.name + "(" + this.id + "): " + "Fog? Shut up and tell us where we're going.");
                if (coordinates.getHeight() > 3)
                    this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
                else {
                    Logger.writeToFile("Baloon#" + this.name + "(" + this.id + ") landing.");
                    this.weatherTower.unregister(this);
                    Logger.writeToFile("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower.");
                }
                break;
            case "SUN":
                if (coordinates.getHeight() <= 96)
                    this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
                else
                    this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2, this.coordinates.getLatitude(), 100);
                Logger.writeToFile("Baloon#" + this.name + "(" + this.id + "): " + "Perfect weather!");
                break;
            case "SNOW":
                Logger.writeToFile("Baloon#" + this.name + "(" + this.id + "): " + "Snow and baloon? We all die.");
                if (coordinates.getHeight() > 15)
                    this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
                else {
                    Logger.writeToFile("Baloon#" + this.name + "(" + this.id + ") landing.");
                    this.weatherTower.unregister(this);
                    Logger.writeToFile("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower.");
                }
                break;
            default:
                System.out.println("I do not have such condition!");
        }
    }

    public void registerTower(WeatherTower weatherTower) throws IOException {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Logger.writeToFile("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}
