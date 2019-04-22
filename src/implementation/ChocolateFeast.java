package implementation;

import java.util.Scanner;

public class ChocolateFeast {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int c = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(chocolateFeast(n, c, m));
        }
    }

    // Complete the chocolateFeast function below.
    static int chocolateFeast(int n, int c, int m) {
        int result = 0;
        int chocoCount = n / c;
        int wrapperCount = n / c;
        result += chocoCount;
        while (wrapperCount >= m) {
            chocoCount = wrapperCount / m;
            wrapperCount = chocoCount + wrapperCount % m;
            result += chocoCount;
        }
        return result;
    }

}
