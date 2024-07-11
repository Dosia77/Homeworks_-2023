package methods;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Streams {

    public static void backuper() throws IOException {

        Files.createDirectory(Path.of("./backup"));

        DirectoryStream<Path> dir = Files.newDirectoryStream(Path.of("."));
        for (Path file : dir) {
            if (Files.isDirectory(file)) continue;
            Files.copy(file, Path.of("./backup/" + file.toString()));
        }
    }

   public static void writeFile(int [] array) throws IOException {
       FileOutputStream fos = new FileOutputStream("save1.out");
        for (int b = 0; b < 3; b++) { // write to 3 bytes
            byte wr = 0;
            for (int v = 0; v < 3; v++) { // write by 3 values in each
                wr += (byte) (array[3 * b + v] << (v * 2));
            }
            fos.write(wr);
        }
        fos.flush();
        fos.close();
   }

   public static void readFile(String filePath, int[] array) throws IOException {
       FileInputStream fis = new FileInputStream("save1.out");
        int b;
        int i = 0;
        while ((b = fis.read()) != -1) {
            for (int v = 0; v < 3; ++v) { // 3 values of four possible
                array[i++] = b >> (v * 2) & 0x3;
            }
        }
        fis.close();

        System.out.println(Arrays.toString(array));

   }

}
