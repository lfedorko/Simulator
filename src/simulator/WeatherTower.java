package src.simulator;

import java.io.IOException;


public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    protected void changeWeather() throws IOException {
        this.conditionsChanged();
    }
}
