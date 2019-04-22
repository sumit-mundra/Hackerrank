package implementation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/bomber-man/problem
 */
public class Bomberman {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the bomberMan function below.
    static String[] bomberMan(int n, String[] grid) {
        if (n == 1) {
            return grid;
        } else if (n % 2 == 0) {
            evenTimeLapse(grid);
        } else if ((n + 1) % 4 == 0) {
            evenTimeLapse(grid);
            oddTimeLapse(grid);
        } else if ((n - 1) % 4 == 0) {
            evenTimeLapse(grid);
            oddTimeLapse(grid);
            evenTimeLapse(grid);
            oddTimeLapse(grid);
        }
        removeX(grid);
        return grid;
    }

    private static void removeX(String[] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                if (grid[i].charAt(j) == 'X') {
                    grid[i] = replaceX(grid[i], j, 'O');
                }
            }
        }
    }

    private static void oddTimeLapse(String[] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                if (grid[i].charAt(j) == 'X') {
                    if (i - 1 >= 0) {
                        grid[i - 1] = replaceChar(grid[i - 1], j, '.');
                    }
                    if (i + 1 < grid.length) {
                        grid[i + 1] = replaceChar(grid[i + 1], j, '.');
                    }
                    if (j - 1 >= 0) {
                        grid[i] = replaceChar(grid[i], j - 1, '.');
                    }
                    if (j + 1 < grid[0].length()) {
                        grid[i] = replaceChar(grid[i], j + 1, '.');
                    }
                    grid[i] = replaceX(grid[i], j, '.');
                }
            }
        }
    }

    private static void evenTimeLapse(String[] grid) {
        for (int i = 0; i < grid.length; i++) {
            grid[i] = grid[i].replace('O', 'X');
            grid[i] = grid[i].replace('.', 'O');
        }
    }

    private static String replaceChar(String str, int j, char c) {
        if (str.charAt(j) != 'X') {
            StringBuilder sb = new StringBuilder(str.substring(0, j));
            sb.append(c);
            if (j + 1 < str.length()) {
                sb.append(str.substring(j + 1));
            }
            return sb.toString();
        }
        return str;
    }

    private static String replaceX(String str, int j, char c) {
        StringBuilder sb = new StringBuilder(str.substring(0, j));
        sb.append(c);
        if (j + 1 < str.length()) {
            sb.append(str.substring(j + 1));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] rcn = scanner.nextLine().split(" ");

        int r = Integer.parseInt(rcn[0]);

        int c = Integer.parseInt(rcn[1]);

        int n = Integer.parseInt(rcn[2]);

        String[] grid = new String[r];

        for (int i = 0; i < r; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = bomberMan(n, grid);
        bufferedWriter.newLine();

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
