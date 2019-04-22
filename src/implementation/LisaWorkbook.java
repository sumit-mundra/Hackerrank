package implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/lisa-workbook/problem
 */
public class LisaWorkbook {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = workbook(n, k, arr);
        System.out.println(result);

        scanner.close();
    }

    private static int workbook(int n, int k, int[] arr) {
        int count = 0;
        int currPage = 1;
        for (int i = 0; i < arr.length; i++) {
            int problemsLeft = arr[i];
            int startNumber = 1;
            int endNumber = -1;
            while (endNumber != arr[i]) {
                if (k <= problemsLeft) {
                    problemsLeft -= k;
                    endNumber = startNumber + k - 1;
                } else {
                    endNumber = startNumber + problemsLeft - 1;
                    problemsLeft = 0;
                }
                if (currPage >= startNumber && currPage <= endNumber) {
                    count++;
                }
                startNumber = endNumber + 1;
                currPage++;
            }
        }
        return count;
    }
}
