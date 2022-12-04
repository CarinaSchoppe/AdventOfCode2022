import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Challenge4 {

    public static void main(String[] args) {
        var reader = new BufferedReader(new InputStreamReader(Challenge4.class.getResourceAsStream("challenge4.txt")));
        var lines = reader.lines().toList();
        System.out.println(lines);
    }
}
