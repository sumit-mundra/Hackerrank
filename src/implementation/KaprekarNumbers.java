package implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/kaprekar-numbers/problem
 */
public class KaprekarNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        printKaprekar(p, q);
    }

    private static void printKaprekar(int p, int q) {
        StringBuilder sb = new StringBuilder();
        boolean notFound = true;
        for (int i = p; i <= q; i++) {
            if (isKaprekar(i)) {
                notFound = false;
                sb.append(i);
                sb.append(" ");
            }
        }
        if (notFound) {
            System.out.println("INVALID RANGE");
        } else
            System.out.println(sb.toString().trim());
    }

    private static boolean isKaprekar(int input) {
        if (input == 1) {
            return true;
        }
        long squared = input * ((long) input);
        String sq = Long.toString(squared);
        int d = sq.length() / 2;
        if (d < 1) {
            return false;
        }
        int l = Integer.parseInt(sq.substring(0, d));
        int r = Integer.parseInt(sq.substring(d));
        if (r == 0) {
            return false;
        }
        return input == l + r;
    }
}
