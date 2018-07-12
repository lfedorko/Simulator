package com.transport;

public class Aircraft{

    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private long idCounter = 0;

    Aircraft(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    private long nextId(){
        return this.id++;

    }
}