package src.simulator;

import src.logger.Logger;
import java.io.IOException;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    protected Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions() throws IOException {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch(weather) {
            case "RAIN":
                Logger.writeToFile("Helicopter#"+ this.name + "(" + this.id + "):" + " It's a rainy day... ");
                this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
                break;
            case "FOG":
                Logger.writeToFile("Helicopter#"+ this.name + "(" + this.id + "):" + "It is dangerous to fly in this heavy fog." );
                this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
                break;
            case "SUN":
                Logger.writeToFile("Helicopter#"+ this.name + "(" + this.id + "):"+ " Where are my sunglasses?" );
                if (coordinates.getHeight() <= 98)
                    this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(),this.coordinates.getHeight() + 2);
                else
                    this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(),100);
                break;
            case "SNOW":
                Logger.writeToFile("Helicopter#"+ this.name + "(" + this.id + "):" + " Let it snow, let it snow, let it snow!" );
                if (coordinates.getHeight() > 12)
                    this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
                else
                {
                    Logger.writeToFile("Helicopter#" + this.name + "(" + this.id + ") landing.");
                    this.weatherTower.unregister(this);
                    Logger.writeToFile("Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower.");
                }
                break;
            default:
	            System.out.println("Unknown condition!");
        }
	 }

    public void registerTower(WeatherTower weatherTower) throws IOException {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        Logger.writeToFile("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}