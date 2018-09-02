package src.simulator;

import java.io.IOException;

public interface Flyable{
	public void updateConditions() throws IOException;
	public void registerTower(WeatherTower weatherTower) throws IOException;
}
