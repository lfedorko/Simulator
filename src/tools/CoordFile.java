package tools;
import java.io.*;

public class CoordFile {

    private String NameOfFile = null;

    public CoordFile(String file) {
        this.NameOfFile = file;
    }

    public void ReturnSimulationFile() throws IOException {



        File f = new File("simulation.txt");
        f.mkdirs();
        f.createNewFile();
        BufferedWriter writer = new BufferedWriter( new FileWriter(f));
        writer.write(data);
        writer.close();
    }

}
