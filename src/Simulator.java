import com.transport.AircraftFactory;
import com.transport.Flyable;
import tools.ValidException;
import tools.Validator;
import weather.WeatherTower;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.System.exit;

public class Simulator {

    private static WeatherTower wt = new WeatherTower();

    public static void main(String[] args) throws IOException {
        if (args.length > 1)
            System.out.println("Invalid number of arguments!");
        else {
            CreateTransport(args[0]);
        }
    }

    public static void CreateTransport(String NameOfFile) {
        String line = null;
        int num = 0;
        Validator v = new Validator();
        String[] result;

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(NameOfFile));
            line = br.readLine();
        } catch (FileNotFoundException e) {
            System.out.println("Can't open file.");
            exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            num = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number of times the simulation is run.");
            exit(0);
        }
        if (num < 1) {
            System.out.println("Invalid number of times the simulation is run.");
            exit(0);
        }
        try {

            while ((line = br.readLine()) != null) {
                result = v.parseString(line);
                Flyable flyable = AircraftFactory.newAircraft(result[0], result[1], Integer.parseInt(result[2]), Integer.parseInt(result[3]), Integer.parseInt(result[4]));
                flyable.registerTower(wt);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ValidException e) {
            e.printStackTrace();
        }
    }

}

