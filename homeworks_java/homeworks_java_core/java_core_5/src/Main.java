
import java.io.IOException;
import methods.Streams;

public class Main {
    public static void main(String[] args) throws IOException {


        Streams.backuper();
        int[] ar2 = {0,1,2,3,0,1,2,3,0};
        Streams.writeFile(ar2);
        String filePath = "save1.out";
        int[] ar20 = new int[9];
        Streams.readFile(filePath, ar20);


    }

}