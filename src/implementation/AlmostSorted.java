package implementation;


import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/almost-sorted/problem
 */
public class AlmostSorted {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the almostSorted function below.
    static void almostSorted(int[] arr) {
        int[] sortedAr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedAr);
        boolean[] diff = new boolean[arr.length];
        int diffCount = 0;
        int change = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != sortedAr[i]) {
                diff[i] = true;
                diffCount++;
                if (i != 0 && ((diff[i] && !diff[i - 1]) || (!diff[i] && diff[i - 1]))) {
                    change++;
                }
            } else {
                diff[i] = false;
            }
        }

        if (diffCount == 0) {
            System.out.println("yes");
            return;
        }

    }


    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        almostSorted(arr);

        scanner.close();
    }
}

