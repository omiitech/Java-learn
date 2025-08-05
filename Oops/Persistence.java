import java.io.FileWriter;
import java.io.IOException;

public class Persistence {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("output.txt");
            writer.write("This is persistent data.");
            writer.close();
            System.out.println("Data written to file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}