package com.transport;
import tools.OutFile;
import weather.WeatherTower;

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
                OutFile.writeToFile("JetPlane#" + this.name + "(" + this.id + "): " + "Wow! I caught a rainbow. ");
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
                break;
            case "FOG":
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
                OutFile.writeToFile("JetPlane#" + this.name + "(" + this.id + "): " + "Fog is the worst weather for flying!");
                break;
            case "SUN":
                if (coordinates.getHeight() <= 98)
                    this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                else
                    this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), 100);
                OutFile.writeToFile("JetPlane#" + this.name + "(" + this.id + "): " + "How's for a little sun on the beach?");
                break;
            case "SNOW":
                OutFile.writeToFile("JetPlane#" + this.name + "(" + this.id + "): " + "I'll build a snowman!!!.");
                if (coordinates.getHeight() > 7)
                    this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight() - 7);
                else {
                    OutFile.writeToFile("JetPlane#" + this.name + "(" + this.id + ") landing.");
                    this.weatherTower.unregister(this);
                    OutFile.writeToFile("Tower says: " + this.name + "(" + this.id + ") unregistered from weather tower");
                }
                break;
            default:
                System.out.println("Unknown condition!");
        }
    }

    public void registerTower(WeatherTower weatherTower) throws IOException {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        OutFile.writeToFile("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
    }

}