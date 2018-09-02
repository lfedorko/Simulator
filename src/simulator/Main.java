package src.simulator;

import src.ValidException;
import src.logger.Logger;
import src.validator.ParseObjects;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    private static WeatherTower wt = new WeatherTower();

    public static void main(String[] args) throws IOException, ValidException {
        if (args.length != 1)
        {
            System.out.println("Wrong number of args!");
            System.exit(1);
        }
        else
            RunSimulator(args[0]);
    }

    public static void RunSimulator(String NameOfFile) throws IOException, ValidException {
        String line = null;
        int num = 0;
        ParseObjects p = new ParseObjects();
        String[] result;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(NameOfFile));
            line = br.readLine();
            num = Integer.parseInt(line);
             if (num <= 0) 
            {
                System.out.println("Number of simulations is negative.");
                System.exit(1);
            }
            Logger.getFileWriter();
            while ((line = br.readLine()) != null) {
                result = p.parseString(line);
                Flyable flyable = AircraftFactory.newAircraft(result[0], result[1], Integer.parseInt(result[2]), Integer.parseInt(result[3]), Integer.parseInt(result[4]));
                flyable.registerTower(wt);
            }
            br.close();
            if (num <= 0) 
            {
                System.out.println("Number of simulations is negative.");
                System.exit(1);
            }
            for (int i = 0; i < num && wt.getObserversSize() != 0; i++)
                wt.changeWeather();
            Logger.closeFileWriter();
  
        } catch (FileNotFoundException e) {
            System.out.println("Can't open file.");
        } catch (IOException e) {
            System.out.println("Error while reading file.");
        } catch (NumberFormatException e) {
            System.out.println("Wrong numbers format!");
        }
        catch (ValidException e) {
           System.out.println(e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Wrong file.");
        }
        catch (Throwable e)
        {
            System.out.println("Throwable exception.");   
        }
    }
}

