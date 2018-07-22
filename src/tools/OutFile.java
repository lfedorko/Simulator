package tools;
import java.io.*;

public class OutFile {

    private static FileWriter fw = null;

    public static void writeToFile(String msg) throws IOException{
        if(fw == null)
            fw = new FileWriter("simulation.txt");
        else
            fw.write(msg);
    }

    public static void closeWriter() throws IOException {
        fw.close();
    }
}
