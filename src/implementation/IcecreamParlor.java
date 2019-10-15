package implementation;

/**
 * https://www.hackerrank.com/challenges/icecream-parlor/problem
 */

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class IcecreamParlor {

    private static final Scanner scanner = new Scanner(System.in);

    static int[] icecreamParlor(int m, int[] arr) {
        int[] result = new int[2];
        Data[] flavors = new Data[arr.length];
        for (int i = 0; i < arr.length; i++) {
            flavors[i] = new Data(arr[i], i + 1);
        }
        Arrays.sort(flavors, Comparator.comparingInt(d -> d.x));
        int start = 0;
        int end = flavors.length - 1;
        while (start < end) {
            int sum = flavors[start].x + flavors[end].x;
            if (sum == m) {
                result[0] = flavors[start].position;
                result[1] = flavors[end].position;
                break;
            }
            if (sum < m) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = icecreamParlor(m, arr);

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

    // Complete the icecreamParlor function below.
    static class Data {
        int x;
        int position;

        Data(int x, int position) {
            this.position = position;
            this.x = x;
        }
    }
}
