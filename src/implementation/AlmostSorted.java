package implementation;


import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/almost-sorted/problem
 */
public class AlmostSorted {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the almostSorted function below.
    static void almostSorted(int[] a) {
        int n = a.length;
        if (isSorted(a, n)) {
            System.out.println("yes");
            return;
        }
        if (isReverseSorted(a, n)) {
            System.out.println("yes");
            if (n == 2) {
                System.out.println("swap 1 2");
                return;
            }
            System.out.println("reverse 1 " + n);
            return;
        }

        int upPeakCount = 0;
        int downPeakCount = 0;
        int upPeak = -1;
        int downPeak = -1;


        for (int i = 0; i <= n - 1; i++) {
            if (i == 0) {
                if (a[i] > a[i + 1]) {
                    upPeak = i;
                    upPeakCount++;
                }
            } else if (i == n - 1) {
                if (a[i] < a[i - 1]) {
                    downPeak = i;
                    downPeakCount++;
                }
            } else {
                if (a[i] < a[i - 1] && a[i] < a[i + 1]) {
                    downPeakCount++;
                    downPeak = i;
                }

                if (a[i] > a[i - 1] && a[i] > a[i + 1]) {
                    upPeakCount++;
                    if (upPeak == -1)
                        upPeak = i;
                }
            }
        }

        if (upPeakCount > 2 || downPeakCount > 2) {
            // only choice is swap if rest of the array is sorted.
            System.out.println("no");
            return;
        }

        if (upPeakCount == 2 || downPeakCount == 2) {
            // only choice is swap if rest of the array is sorted.
            int temp = a[upPeak];
            a[upPeak] = a[downPeak];
            a[downPeak] = temp;
            if (isSorted(a, n)) {
                System.out.println("yes");
                System.out.println("swap " + (upPeak + 1) + " " + (downPeak + 1));
            } else {
                System.out.println("no");
            }
            return;
        }


        if (upPeakCount == 1 && downPeakCount == 0) {
            System.out.println("no");
            return;
        }

        if (downPeakCount == 1 && upPeakCount == 0) {
            System.out.println("no");
            return;
        }

        if (upPeakCount == 1 && downPeakCount == 1) {
            if (upPeak > downPeak) {
                System.out.println("no");
                return;
            }

            if (upPeak == 0 && a[downPeak + 1] > a[upPeak]
                    || (downPeak == n - 1 && a[downPeak] > a[upPeak - 1])
                    || ((upPeak != 0 && downPeak != n - 1) && a[downPeak + 1] > a[upPeak] && a[downPeak] > a[upPeak - 1])) {
                System.out.println("yes");
                if (downPeak - upPeak == 1) {
                    System.out.println("swap " + (upPeak + 1) + " " + (downPeak + 1));
                } else {
                    System.out.println("reverse " + (upPeak + 1) + " " + (downPeak + 1));
                }
                return;
            }
        }
        System.out.println("no");
    }

    private static boolean isReverseSorted(int[] a, int n) {
        boolean reverseSorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] < a[i + 1]) {
                reverseSorted = false;
                break;
            }
        }
        return reverseSorted;
    }

    private static boolean isSorted(int[] a, int n) {
        boolean sorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                sorted = false;
                break;
            }
        }
        return sorted;
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

