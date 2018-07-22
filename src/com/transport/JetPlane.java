package com.transport;
import tools.OutFile;
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
                OutFile.writeToFile("JetPlane#" + this.name + "(" + this.id + "):" + " It's a rainy day... ");
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
                break;
            case "FOG":
                OutFile.writeToFile("JetPlane#" + this.name + "(" + this.id + "):" + "Ooops! Foggy day. Inside the fogs, see attentively! \n");
                this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
                break;
            case "SUN":
                if (coordinates.getHeight() <= 98)
                    this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                else
                    this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), 100);
                break;
            case "SNOW":
                OutFile.writeToFile("JetPlane#" + this.name + "(" + this.id + "):" + " Let it snow, let it snow, let it snow!");
                if (coordinates.getHeight() > 7)
                    this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight() - 7);
                else {
                    OutFile.writeToFile("JetPlane#" + this.name + "(" + this.id + ") landing.");
                    this.weatherTower.unregister(this);
                    OutFile.writeToFile("weather.Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower");
                }
                break;
            default:
                System.out.println("Unknown condition!");
        }
    }

    public void registerTower(WeatherTower weatherTower) throws IOException {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        OutFile.writeToFile("weather.Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
    }

}