package strings;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * 7:47 min
 * https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem
 */
public class HackerRankInAString {

    private static final Scanner scanner = new Scanner(System.in);

    public static String hackerrank = "hackerrank";

    // Complete the hackerrankInString function below.
    static String hackerrankInString(String s) {
        int refPoint = 0;
        boolean noMatch = false;
        int matchIndex = -1;

        while (refPoint < hackerrank.length()) {
            char toMatch = hackerrank.charAt(refPoint);
            matchIndex = s.indexOf(toMatch, matchIndex + 1);
            if (matchIndex == -1) {
                noMatch = true;
                break;
            }
            refPoint++;
        }
        return noMatch ? "NO" : "YES";
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = hackerrankInString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

