package com.transport;
import com.transport.

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    protected Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
    }

    public void registerTower(WeatherTower weatherTower){
    }
}