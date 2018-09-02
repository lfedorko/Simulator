package src.logger;
import java.io.*;

public class Logger {

    private static FileWriter fw = null;

    // pattern 
    // singleton
    // one writer 
    public static void getFileWriter() throws IOException {
        if (fw == null)
            fw = new FileWriter("simulation.txt");
    }

    public static void writeToFile(String msg) throws IOException{
            fw.write(msg +'\n');
    }

    public static void closeFileWriter() throws IOException {
        fw.close();
    }
}
