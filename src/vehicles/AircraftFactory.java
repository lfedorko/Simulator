package vehicles;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        switch (type) {
            case "JetPlane":
                return new JetPlane(name, new Coordinates(longitude,latitude,height));
            case "Baloon":
                return new Baloon(name, new Coordinates(longitude,latitude,height));
            case "Helicopter":
                return new Helicopter(name, new Coordinates(longitude,latitude,height));
            default:
                System.out.println("Invalid aircraft type: " + type);
                return null;
        }
    }
}