package strings;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 4 min
 * https://www.hackerrank.com/challenges/mars-exploration/problem
 */
public class MarsExploration {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the marsExploration function below.
    static int marsExploration(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i+1) % 3 == 1 && s.charAt(i) != 'S') {
                count++;
            }
            if ((i+1) % 3 == 2 && s.charAt(i) != 'O') {
                count++;
            }
            if ((i+1) % 3 == 0 && s.charAt(i) != 'S') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
