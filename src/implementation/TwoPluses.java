package implementation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * https://www.hackerrank.com/challenges/two-pluses/problem
 */
public class TwoPluses {
    private static final Scanner scanner = new Scanner(System.in);
    private static final char CHAR_G = 'G';

    // Complete the twoPluses function below.
    static int twoPluses(String[] grid) {
        //TWO LARGEST VALID PLUSES
        boolean noPlus = true;
        boolean gPresent = false;
        List<Plus> list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            int j = 0;
            while (j < grid[0].length()) {
                if (grid[i].charAt(j) == CHAR_G) {
                    gPresent = true;
                    int span = getMaxPlusSpan(grid, i, j);
                    if (span > 0) {
                        noPlus = false;
                        for (int k = 1; k <= span; k++) {
                            list.add(new Plus(i, j, k));
                        }
                    }
                }
                j++;
            }
        }

        if (noPlus) {
            return gPresent ? 1 : 0;
        }
        int max = 1;
        for (int i = 0; i < list.size(); i++) {
            Plus p1 = list.get(i);
            int area1 = 4 * p1.span + 1;
            if (max < area1) {
                max = area1;
            }
            for (int j = i + 1; j < list.size(); j++) {
                String[] copy = grid.clone();
                fillPlus(copy, p1);
                Plus p2 = list.get(j);
                if (isPlusValid(copy, p2)) {
                    fillPlus(copy, p2);
                    int area2 = 4 * p2.span + 1;
                    int product = area1 * area2;
                    if (max < product) {
                        max = product;
                        print(copy);
                        System.out.println("area1 = " + area1);
                        System.out.println("area2 = " + area2);
                    }

                }
            }
        }
        return max;
    }

    private static boolean isPlusValid(String[] grid, Plus plus) {
        int i = plus.row;
        int j = plus.col;
        int span = plus.span;
        boolean result = grid[i].charAt(j) == CHAR_G;
        for (int k = 0; k <= span; k++) {
            result = result &&
                    grid[i + k].charAt(j) == CHAR_G &&
                    grid[i - k].charAt(j) == CHAR_G &&
                    grid[i].charAt(j + k) == CHAR_G &&
                    grid[i].charAt(j - k) == CHAR_G;
        }
        return result;
    }

    private static int getMaxPlusSpan(String[] grid, int i, int j) {
        int span = 1;
        int rows = grid.length;
        int cols = grid[0].length();
        while (i + span < rows && j + span < cols && i - span >= 0 && j - span >= 0) {
            if (grid[i].charAt(j) == CHAR_G &&
                    grid[i + span].charAt(j) == CHAR_G &&
                    grid[i - span].charAt(j) == CHAR_G &&
                    grid[i].charAt(j + span) == CHAR_G &&
                    grid[i].charAt(j - span) == CHAR_G) {
                span++;
            } else {
                break;
            }
        }
        return span - 1;
    }

    private static void fillPlus(String[] grid, Plus plus) {
        int i = plus.row;
        int j = plus.col;

        for (int span = 1; span <= plus.span; span++) {
            replace(i - span, j, grid);
            replace(i + span, j, grid);
            replace(i, j - span, grid);
            replace(i, j + span, grid);
        }
        replace(i, j, grid);
    }

    private static void replace(int i, int j, String[] grid) {
        String row = grid[i];
        row = row.substring(0, j) + "X" + row.substring(j + 1);
        grid[i] = row;
    }

    private static void print(String[] grid) {
        for (int i = 0; i < grid.length; i++) {
            System.out.println(grid[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        int result = twoPluses(grid);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

    static class Plus {
        int row;
        int col;
        int span;

        Plus(int row, int col, int span) {
            this.row = row;
            this.col = col;
            this.span = span;
        }
    }

}
