package com.transport;


public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
     //   Writer.writeIntoAFile("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
    }

}