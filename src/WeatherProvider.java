import com.transport.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = null;
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider(){}

    public WeatherProvider getProvider(){

    }
    public String getCurrentWeather(Coordinates coordinates) {
        return "SUN";
    }


}
