package com.transport;

/**
 * Created by lizavieta on 06.07.2018.
 */
public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    protected Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
   //     Writer.writeIntoAFile("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}
