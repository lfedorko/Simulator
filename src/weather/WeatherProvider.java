package weather;

import com.transport.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider(){}

    public WeatherProvider getProvider(){
        return this.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return weather[(coordinates.getHeight() * coordinates.getLatitude() % 4 )];
    }


}
