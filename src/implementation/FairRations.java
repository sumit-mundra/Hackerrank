package implementation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/fair-rations/problem
 */
public class FairRations {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] B = new int[N];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = fairRations(B);
        if (result == -1) {
            bufferedWriter.write("NO");
        } else {
            bufferedWriter.write(String.valueOf(result));
        }
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    // Complete the fairRations function below.
    static int fairRations(int[] B) {
        int loafCount = 0;
        int n = B.length;
        int oddCount = 0;
        for (int i = 0; i < n; i++) {
            oddCount = B[i] % 2 == 0 ? oddCount : oddCount + 1;
        }
        if (oddCount % 2 == 0) {
            for (int i = 0; i < n / 2; i++) {
                if (B[i] % 2 == 0) {
                } else {
                    B[i]++;
                    B[i + 1]++;
                    loafCount += 2;
                }

                if (B[n - i - 1] % 2 == 0) {
                } else {
                    B[n - i - 1]++;
                    B[n - i - 2]++;
                    loafCount += 2;
                }
            }
            return loafCount;
        } else {
            return -1;
        }
    }

}
