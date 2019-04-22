package euler;

import java.util.Scanner;

public class ProjectEuler006 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            System.out.println(getDifferenceOfSum(n));
        }
    }

    private static long getDifferenceOfSum(long n) {
        long squareOfSum = (n * n * (n + 1) * (n + 1)) / 4;
        long sumOfSquares = (n * (n + 1) * (2 * n + 1)) / 6;
        long result = squareOfSum - sumOfSquares;
        return result;
    }
}
