package implementation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class HappyLadybugs {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
        if (b.length() == 1) {
            return b.equals("_") ? "YES" : "NO";
        }
        int[] freq = new int[31];
        for (int i = 0; i < b.length(); i++) {
            freq[b.charAt(i) - 'A']++;
        }
        for (int j = 0; j < 26; j++) {
            if (freq[j] == 1) {
                return "NO";
            }
        }
        boolean alreadyHappy = true;
        for (int i = 0; i < b.length(); i++) {
            if (i == 0) {
                alreadyHappy = b.charAt(i) == b.charAt(i + 1);
            } else if (i == b.length() - 1) {
                alreadyHappy = b.charAt(i) == b.charAt(i - 1);
            } else {
                alreadyHappy = b.charAt(i) == b.charAt(i + 1) || b.charAt(i) == b.charAt(i - 1);
            }
            if (!alreadyHappy) {
                break;
            }
        }
        if (!alreadyHappy && freq[30] == 0) {
            return "NO";
        } else {
            return "YES";
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
