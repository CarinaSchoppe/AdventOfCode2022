import java.io.BufferedReader;
import java.io.IOException;

public class Challenge4 {

    public static void main(String[] args) throws IOException {

        //read in the file "challenge4.txt" from the resources folder
        var file = Challenge4.class.getResourceAsStream("challenge4.txt");
        var reader = new BufferedReader(new java.io.InputStreamReader(file));
        while (reader.ready()) {
            var jobPair = reader.readLine().split(",");
            var elf1 = new int[]{Integer.parseInt(jobPair[0].split("-")[0]), Integer.parseInt(jobPair[0].split("-")[1])};
            var elf2 = new int[]{Integer.parseInt(jobPair[1].split("-")[0]), Integer.parseInt(jobPair[1].split("-")[1])};


        }

    }
}
