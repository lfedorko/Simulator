package tools;


import java.io.*;

import static java.lang.System.exit;

public class CoordFile {

    private String NameOfFile = null;

    public CoordFile(String file) {
        this.NameOfFile = file;
    }


    public String RecordScenario() {
        String line = null;
        int num = 0;

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


//        while ((sCurrentLine = br.readLine()) != null)
//        {
//            contentBuilder.append(sCurrentLine).append("\n");
//        }
        return(null);
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
