package strings;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 *
 * 6:50 min
 * https://www.hackerrank.com/challenges/pangrams/problem
 */
public class Pangrams {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the pangrams function below.
    static String pangrams(String s) {
        s = s.toLowerCase();
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if ( index >=0 && index < 26){
                freq[s.charAt(i) - 'a']++;
            }
        }
        boolean pangram = true;
        for (int value : freq) {
            if (value == 0) {
                pangram = false;
                break;
            }
        }
        return pangram ? "pangram" : "not pangram";

    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

