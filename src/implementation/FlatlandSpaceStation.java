package implementation;

import java.util.Arrays;
import java.util.Scanner;

public class FlatlandSpaceStation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(flatlandSpaceStations(n, a));

    }

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
        if (n == c.length) {
            return 0;
        }
        Arrays.sort(c);
        int res = 0;
        for (int i = 0; i <= c.length; i++) {
            if (i == 0) {
                if (c[i] > res) {
                    res = c[i];
                }
            } else if (i == c.length) {
                if (n - 1 - c[i - 1] > res) {
                    res = n - 1 - c[i - 1];
                }
            } else {
                if (c[i] - c[i - 1] > 1 && res < (c[i] - c[i - 1]) / 2)
                    res = (c[i] - c[i - 1]) / 2;
            }
        }
        return res;
    }
}
