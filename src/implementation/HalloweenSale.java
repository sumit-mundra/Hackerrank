package implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/halloween-sale/problem
 */
public class HalloweenSale {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int d = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        System.out.println(howManyGames(p, d, m, s));
    }

    static int howManyGames(int p, int d, int m, int s) {
        // Return the number of games you can buy
        if (s < p) {
            return 0;
        }

        int k = (p - m) / d + 1;
        int apSum = k * (2 * p - (k - 1) * d) / 2;
        int l = (s - apSum) / m;
        return k + l;
    }

}
