package com.transport;

import java.util.ArrayList;

public class WeatherTower extends Tower{

    public ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {

    }
    public void unregister(Flyable flyable) {

    }

    protected void ConditionsChanged(){

    }

}
