package implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/beautiful-triplets/problem
 */
public class BeautifulTriplets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }
        long time = System.currentTimeMillis();
        System.out.println(beautifulTripletsCount(ar, d));
        System.out.println(System.currentTimeMillis() - time);
    }

    private static long beautifulTripletsCount(int[] a, int d) {
        long result = 0;
        int length = a.length;
        int i = 0;
        while (i < length) {
            long count = 0;
            long dupFactor1 = 1;
            long dupFactor2 = 1;
            int j = i + 1;
            while (j < length) {
                if (a[j] == a[i]) {
                    dupFactor1++;
                    i++;
                    j++;
                    continue;
                }
                if (a[j] > a[i] + d) {
                    break;
                }
                if (a[j] - a[i] == d) {
                    int k = j + 1;
                    while (k < length) {
                        if (a[k] == a[j]) {
                            dupFactor2++;
                            j++;
                            k++;
                            continue;
                        }
                        if (a[k] > a[j] + d) {
                            break;
                        }
                        if (a[k] == a[j] + d) {
                            count++;
                        }
                        k++;
                    }
                }
                j++;
            }
            if (count > 0) {
                System.out.println("count::" + count + " " + "dupFactor1::" + dupFactor1 + " " + "dupFactor2::" + dupFactor2);
                result += count * dupFactor1 * dupFactor2;
            }
            i++;
        }
        return result;
    }
}
