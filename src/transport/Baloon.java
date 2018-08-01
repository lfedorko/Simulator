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
                OutFile.writeToFile("Baloon#" + this.name + "(" + this.id + "):" + "Rainy days should be spent at home with a cup of tea, not on ballon");
                if (coordinates.getHeight() > 5)
                    this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight() - 5);
                else {
                    OutFile.writeToFile("Baloon#" + this.name + "(" + this.id + ") landing.");
                    this.weatherTower.unregister(this);
                    OutFile.writeToFile("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower");
                }
                break;
            case "FOG":
                OutFile.writeToFile("Baloon#" + this.name + "(" + this.id + "):" + "Fog? Shut up and tell us where we're going.");
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                break;
            case "SUN":
                if (coordinates.getHeight() <= 96)
                    this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                else
                    this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), 100);
                OutFile.writeToFile("Baloon#" + this.name + "(" + this.id + "):" + "Perfect weather!");
                break;
            case "SNOW":
                OutFile.writeToFile("Baloon#" + this.name + "(" + this.id + "):" + "Snow and baloon? We all die.");
                if (coordinates.getHeight() > 15)
                    this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight() - 15);
                else {
                    OutFile.writeToFile("Baloon#" + this.name + "(" + this.id + ") landing.");
                    this.weatherTower.unregister(this);
                    OutFile.writeToFile("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower");
                }
                break;
            default:
                System.out.println("Unknown condition!");
        }
    }

    public void registerTower(WeatherTower weatherTower) throws IOException {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        OutFile.writeToFile("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}


//        Tower says: JetPlane#J1(2) registered to weather towower says: Baloon#B1(1) registered to weather tower.
