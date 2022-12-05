import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Challenge5 {

    public static void main(String[] args) throws IOException {
        //read in the file
        var reader = new BufferedReader(new InputStreamReader(Challenge5.class.getResourceAsStream("challenge5.txt")));
        String pile1 = "";
        var length = 0;

        String lines = "";
        String line;
        while (!Objects.equals(line = reader.readLine(), "")) {
            lines += line + "\n";
            pile1 += line.substring(0, 3);
            if (length < line.length()) {
                length = line.length();
            }
        }

        var amount = (length + 1) / 4;

        var pileArray = new String[amount];


        for (int i = 0; i < amount; i++) {
            pileArray[i] = "";
        }

        reader = new BufferedReader(new InputStreamReader(Challenge5.class.getResourceAsStream("challenge5.txt")));

        while (!Objects.equals(line = reader.readLine(), "")) {
            for (var i = 0; i < line.toCharArray().length; i += 4) {
                var character = line.toCharArray()[i + 1];
                if (character != ' ') {
                    pileArray[i / 4] += character;

                }
            }


        }

        for (var i = 0; i < pileArray.length; i++) {
            pileArray[i] = pileArray[i].substring(0, pileArray[i].length() - 1);
        }
        System.out.println(pileArray[3]);
    }
}
