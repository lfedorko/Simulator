package weather;

import com.transport.Coordinates;
import weather.Tower;
import weather.WeatherProvider;

import java.io.IOException;

public class WeatherTower extends Tower {


    public String getWeather(Coordinates coordinates) {
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
    }

    private void changeWeather() throws IOException {
        this.conditionsChanged();
    }
}
