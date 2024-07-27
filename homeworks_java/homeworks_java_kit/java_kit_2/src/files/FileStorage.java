package files;

import server.ServerController;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileStorage implements FileInterface{

    private final String LOG_PATH = "/home/anna/IdeaProjects/java_kit_2/src/files/history.txt";

    @Override
   public String fileReader() {

        StringBuilder textFile = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH)) {
            int c;
            while ((c = reader.read()) != -1) {
                textFile.append(String.valueOf((char) c));
            }
                textFile.delete(textFile.length()-1, textFile.length());
           return textFile.toString();

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
            return null;
        }

    }

    @Override
    public void fileWriter(String message) {

        try (FileWriter writer = new FileWriter(LOG_PATH, true)) {
            writer.write(message);
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
