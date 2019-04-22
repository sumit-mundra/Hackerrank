package strings;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CaesarCipher1 {

    private static final Scanner scanner = new Scanner(System.in);

    static String lowerCase = "abcdefghijklmnopqrstuvwxyz";
    static String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // Complete the caesarCipher function below.
    static String caesarCipher(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int pos = 0;
            boolean alpha = false;
            boolean upper = false;
            if (lowerCase.contains(String.valueOf(s.charAt(i)))) {
                pos = s.charAt(i) - 'a';
                alpha = true;
            } else if (upperCase.contains(String.valueOf(s.charAt(i)))) {
                pos = s.charAt(i) - 'A';
                upper = true;
                alpha = true;
            }
            char encoded = s.charAt(i);
            if (alpha) {
                pos = (pos + k) % 26;
                if (upper) {
                    encoded = (char) (pos + 'A');
                } else {
                    encoded = (char) (pos + 'a');
                }
            }
            sb.append(encoded);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
