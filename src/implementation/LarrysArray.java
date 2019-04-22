package implementation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/larrys-array/problem?isFullScreen=true
 */
public class LarrysArray {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the larrysArray function below.
    static String larrysArray(int[] A) {
        int n = A.length;
        int[] location = new int[n];
        for (int i = 0; i < n; i++) {
            // making A zero based to allow easy understanding between A[i] and index
            A[i]--;
            location[A[i]] = i;
        }
        for (int i = 0; i < n-2; i++) {
            if (location[i] != i) {
                int current = location[i];
                while (current != i) {
                    if (current - i >= 2) {
                        rotate(A, location, current - 2);
                        current = location[i];
                    } else {
                        rotate(A, location, current - 1);
                        rotate(A, location, current - 1);
                        current = location[i];
                    }
                }
            }
        }
        if(location[n-1] == n-1 && location[n-2]==n-2){
            return "YES";
        }
        return "NO";
    }

    static void rotate(int[] A, int[] location, int start) {
        int first = A[start];
        int second = A[start + 1];
        int third = A[start + 2];

        A[start] = third;
        A[start + 1] = first;
        A[start + 2] = second;

        location[third] = start;
        location[first] = start + 1;
        location[second] = start + 2;
    }


    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] A = new int[n];

            String[] AItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int AItem = Integer.parseInt(AItems[i]);
                A[i] = AItem;
            }

            String result = larrysArray(A);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
