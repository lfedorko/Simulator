package tools;


import java.io.*;

import static java.lang.System.exit;

public class CoordFile {

    private String NameOfFile = null;

    public CoordFile(String file) {
        this.NameOfFile = file;
    }


    public void CreateTransport() {
        String line = null;
        int num = 0;
        Validator v = new Validator();

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
            while ((line = br.readLine()) != null)
                v.parseString(line);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ValidException e) {
            e.printStackTrace();
        }
    }

    public void ReturnSimulationFile() throws IOException {



        File f = new File("simulation.txt");
        f.mkdirs();
        f.createNewFile();
        //BufferedWriter writer = new BufferedWriter( new FileWriter(f));
        //writer.write(data);
        // writer.close();
    }

}
