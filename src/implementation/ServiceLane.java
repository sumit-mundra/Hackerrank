package implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/service-lane/problem
 */
public class ServiceLane {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nt = sc.nextLine().split(" ");

        int n = Integer.parseInt(nt[0]);

        int t = Integer.parseInt(nt[1]);

        int[] width = new int[n];

        String[] widthItems = sc.nextLine().split(" ");
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int widthItem = Integer.parseInt(widthItems[i]);
            width[i] = widthItem;
        }
        int[][] cases = new int[t][2];

        for (int i = 0; i < t; i++) {
            String[] casesRowItems = sc.nextLine().split(" ");
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int casesItem = Integer.parseInt(casesRowItems[j]);
                cases[i][j] = casesItem;
            }
        }

        int[] result = serviceLane(cases, width);

        for (int i = 0; i < result.length; i++) {
            System.out.printf(String.valueOf(result[i]));
            if (i != result.length - 1) {
                System.out.println();
            }
        }
    }

    static int[] serviceLane(int[][] cases, int[] width) {
        int[] result = new int[cases.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = minOfArray(cases[i][0], cases[i][1], width);
        }
        return result;
    }

    private static int minOfArray(int entry, int exit, int[] width) {
        int min = -1;
        for (int i = entry; i <= exit; i++) {
            if (min == -1) {
                min = width[i];
            } else {
                min = min > width[i] ? width[i] : min;
            }
        }
        return min;
    }

}
