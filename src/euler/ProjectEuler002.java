package euler;

import java.util.Scanner;

public class ProjectEuler002 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int a0 = 0; a0 < t; a0++) {
            long n = in.nextLong();
            System.out.println(getEvenSum(n));
        }
    }

    static long getEvenSum(long max) {
        long cursor = 1;
        long prevCursor = 1;
        long sum = 0;
        while (cursor <= max) {
            if (cursor == 1) {
                long temp = cursor;
                cursor = cursor + prevCursor;
                prevCursor = temp;
            }
            else if (cursor >= 2) {
                long temp = cursor;
                cursor = cursor + prevCursor;
                prevCursor = temp;
            }
            if (prevCursor % 2 == 0) {
                sum += prevCursor;
            }
        }
        return sum;
    }

}