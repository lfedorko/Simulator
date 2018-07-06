package com.transport;
import ;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    protected JetPlane(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
    }

    public void registerTower(WeatherTower weatherTower){
    }

}