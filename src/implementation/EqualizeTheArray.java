package implementation;

import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/equality-in-a-array/problem
 */
public class EqualizeTheArray {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the nonDivisibleSubset function below.
    static int nonDivisibleSubset(int k, int[] S) {
        if (k == 1) {
            return 1;
        }
        int[] frequency = new int[k];
        for (int i = 0; i < k; i++) {
            frequency[i] = 0;
        }
        int i = 0;
        for (int elem : S) {
            int remainder = elem % k;
            frequency[remainder]++;
        }
        int result = 0;
        if (frequency[0] > 0) {
            result += 1;
        }
        for (int j = 1; j <= k / 2; j++) {
            if (j == k / 2 && k % 2 == 0 && frequency[j] > 0) {
                result += 1;
                continue;
            }
            result += ((frequency[j] >= frequency[k - j]) ? frequency[j] : frequency[k - j]);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] S = new int[n];

        String[] SItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int SItem = Integer.parseInt(SItems[i]);
            S[i] = SItem;
        }

        int result = nonDivisibleSubset(k, S);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
