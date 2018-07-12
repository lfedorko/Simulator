import tools.CoordFile;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length > 1)
            System.out.println("Invalid number of arguments!");
        else {
            CoordFile f = new CoordFile(args[0]);
            f.RecordScenario();
            System.out.println("Pamagite");
        }
    }
}
