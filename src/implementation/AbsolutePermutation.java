package implementation;

import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/absolute-permutation/problem
 */
public class AbsolutePermutation {


    private static final Scanner scanner = new Scanner(System.in);

    // Complete the absolutePermutation function below.
    static int[] absolutePermutation(int n, int k) {
        if (Double.valueOf(n / 2f).compareTo(Double.valueOf(k)) < 0) {
            return null;
        }
        boolean noSolution = false;
        int[] result = new int[n];
        for (int i = 1; i <= k; i++) {
            if (i + k <= n) {
                result[i + k - 1] = i;
            }
        }
        for (int i = n - k + 1; i <= n; i++) {
            if (i - k >= 1) {
                result[i - k - 1] = i;
            }
        }

        for (int i = k + 1; i <= n - k; i++) {
            if ((i - k >= 1) && result[i - k - 1] == 0) {
                result[i - k - 1] = i;
            } else if ((i + k <= n) && result[i + k - 1] == 0) {
                result[i + k - 1] = i;
            } else {
                noSolution = true;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (result[i] == 0) {
                noSolution = true;
                break;
            }
        }
        if (noSolution) {
            return null;
        } else {
            return result;
        }
    }

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[][] input = new String[t][2];
        for (int tItr = 0; tItr < t; tItr++) {
            input[tItr] = scanner.nextLine().split(" ");
        }

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = input[tItr];
            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);
            int[] result = absolutePermutation(n, k);
            if (result == null) {
                System.out.print(-1);
            } else {
                for (int i = 0; i < result.length; i++) {
                    System.out.print(result[i]);

                    if (i != result.length - 1) {
                        System.out.printf(" ");
                    }
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}
