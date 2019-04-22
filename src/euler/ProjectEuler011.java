package euler;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler011
 */
public class ProjectEuler011 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] grid = new int[20][20];
        for (int grid_i = 0; grid_i < 20; grid_i++) {
            for (int grid_j = 0; grid_j < 20; grid_j++) {
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        // horizontal
        int maxH = getMaxProductHorizontal(grid);
        // vertical
        int maxV = getMaxProductVertical(grid);
        // d1
        int maxD1 = getMaxProductD1(grid);
        // d2
        int maxD2 = getMaxProductD2(grid);
        System.out.println(Math.max(Math.max(Math.max(maxD1, maxD2), maxV), maxH));
    }

    private static int getMaxProductHorizontal(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            for (int j = 0; j < row.length - 3; j++) {
                int product = row[j] * row[j + 1] * row[j + 2] * row[j + 3];
                result = product > result ? product : result;
            }
        }
        return result;
    }

    private static int getMaxProductVertical(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length - 3; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int product = grid[i][j] * grid[i + 1][j] * grid[i + 2][j] * grid[i + 3][j];
                result = product > result ? product : result;
            }
        }
        return result;
    }

    private static int getMaxProductD1(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length - 3; i++) {
            for (int j = 0; j < grid[i].length - 3; j++) {
                int product = grid[i][j] * grid[i + 1][j + 1] * grid[i + 2][j + 2] * grid[i + 3][j + 3];
                result = product > result ? product : result;
            }
        }
        return result;
    }

    private static int getMaxProductD2(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length - 3; i++) {
            for (int j = 3; j < grid[i].length; j++) {
                int product = grid[i][j] * grid[i + 1][j - 1] * grid[i + 2][j - 2] * grid[i + 3][j - 3];
                result = product > result ? product : result;
            }
        }
        return result;
    }
}