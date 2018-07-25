package com.transport;
import tools.OutFile;
import weather.WeatherTower;

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
                OutFile.writeToFile("Baloon#" + this.name + "(" + this.id + "):" + " It's a rainy day... ");
                if (coordinates.getHeight() > 5)
                    this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight() - 5);
                else {
                    OutFile.writeToFile("Baloon#" + this.name + "(" + this.id + ") landing.");
                    this.weatherTower.unregister(this);
                    OutFile.writeToFile("weather.Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower");
                }
                break;
            case "FOG":
                OutFile.writeToFile("Baloon#" + this.name + "(" + this.id + "):" + "Ooops! Foggy day. Inside the fogs, see attentively! \n");
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                break;
            case "SUN":
                if (coordinates.getHeight() <= 96)
                    this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                else
                    this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), 100);
                break;
            case "SNOW":
                OutFile.writeToFile("Baloon#" + this.name + "(" + this.id + "):" + " Let it snow, let it snow, let it snow!");
                if (coordinates.getHeight() > 15)
                    this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight() - 15);
                else {
                    OutFile.writeToFile("Baloon#" + this.name + "(" + this.id + ") landing.");
                    this.weatherTower.unregister(this);
                    OutFile.writeToFile("weather.Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower");
                }
                break;
            default:
                System.out.println("Unknown condition!");
        }
    }

    public void registerTower(WeatherTower weatherTower) throws IOException {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        OutFile.writeToFile("weather.Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}
