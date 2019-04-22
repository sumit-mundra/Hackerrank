package implementation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://www.hackerrank.com/challenges/manasa-and-stones/problem
 */
public class ManasaStones {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the stones function below.
    static int[] stones(int n, int a, int b) {
        Set<Integer> result = new TreeSet<>();
        for (int x = 0; x <= n - 1; x++) {
            result.add(0 + x * a + (n - x - 1) * b);
        }
        int[] res = new int[result.size()];
        int i = 0;
        for (Integer value : result) {
            res[i++] = value;
        }
        return res;
    }


    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int a = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int b = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = stones(n, a, b);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

}
