import java.io.BufferedReader;
import java.io.IOException;

public class Challenge4 {

    public static void main(String[] args) throws IOException {

        //read in the file "challenge4.txt" from the resources folder
        var file = Challenge4.class.getResourceAsStream("challenge4.txt");
        var reader = new BufferedReader(new java.io.InputStreamReader(file));
        System.out.println(reader.readLine());


    }
}
