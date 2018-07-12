package com.transport;

import com.transport.*;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        switch (type) {
            case "JetPlane":
                return new JetPlane(type, new Coordinates(longitude,latitude,height));
            case "Baloon":
                return new Baloon(type, new Coordinates(longitude,latitude,height));
            case "Helicopter":
                return new Helicopter(type, new Coordinates(longitude,latitude,height));
        }
        return null;
    }
}
