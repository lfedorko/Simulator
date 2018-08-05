package vehicles;

import tools.OutFile;

import java.io.IOException;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions() throws IOException {

        String weather = this.weatherTower.getWeather(this.coordinates);

        switch(weather) {
            case "RAIN":
                OutFile.writeToFile("Helicopter#"+ this.name + "(" + this.id + "):"+ " It's a rainy day... ");
                this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(),coordinates.getHeight());
                break;
            case "FOG":
                OutFile.writeToFile("Helicopter#"+ this.name + "(" + this.id + "):"+ "It is dangerous to fly in this heavy fog." );
                this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(),coordinates.getHeight());
                break;
            case "SUN":
                OutFile.writeToFile("Helicopter#"+ this.name + "(" + this.id + "):"+ " Where are my sunglasses?" );
                if (coordinates.getHeight() <= 98)
                    this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(),coordinates.getHeight() + 2);
                else
                    this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(),100);
                break;
            case "SNOW":
                OutFile.writeToFile("Helicopter#"+ this.name + "(" + this.id + "):"+ " Let it snow, let it snow, let it snow!" );
                if (coordinates.getHeight() > 12)
                    this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(),coordinates.getHeight() - 12);
                else
                {
                    OutFile.writeToFile("Helicopter#" + this.name + "(" + this.id + ") landing.");
                    this.weatherTower.unregister(this);
                    OutFile.writeToFile("Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower");
                }
                break;
            default:
	            System.out.println("Unknown condition!");
        }
	 }

    public void registerTower(WeatherTower weatherTower) throws IOException {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        OutFile.writeToFile("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}