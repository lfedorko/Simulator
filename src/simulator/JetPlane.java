package src.simulator;

import src.logger.Logger;
import java.io.IOException;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions() throws IOException {

        String weather = this.weatherTower.getWeather(this.coordinates);

        switch (weather) {
            case "RAIN":
                Logger.writeToFile("JetPlane#" + this.name + "(" + this.id + "): " + "Wow! I caught a rainbow. ");
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
                break;
            case "FOG":
                this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 1, this.coordinates.getHeight());
                Logger.writeToFile("JetPlane#" + this.name + "(" + this.id + "): " + "Fog is the worst weather for flying!");
                break;
            case "SUN":
                if (coordinates.getHeight() <= 98)
                    this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
                else
                    this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), 100);
                Logger.writeToFile("JetPlane#" + this.name + "(" + this.id + "): " + "How's for a little sun on the beach?");
                break;
            case "SNOW":
                Logger.writeToFile("JetPlane#" + this.name + "(" + this.id + "): " + "I'll build a snowman!!!");
                if (coordinates.getHeight() > 7)
                    this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
                else {
                    Logger.writeToFile("JetPlane#" + this.name + "(" + this.id + ") landing.");
                    this.weatherTower.unregister(this);
                    Logger.writeToFile("Tower says: " + this.name + "(" + this.id + ") unregistered from weather tower.");
                }
                break;
            default:
                System.out.println("I do not have such condition!");
        }
    }

    public void registerTower(WeatherTower weatherTower) throws IOException {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Logger.writeToFile("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
    }

}