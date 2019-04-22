package implementation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CavityMap {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {
        int n = grid.length;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                String row = grid[i];
                String row_minus = grid[i - 1];
                String row_plus = grid[i + 1];
                String self = Character.toString(row.charAt(j));
                if (self.equals('X')) {
                    continue;
                }
                int x = Integer.parseInt(self);
                List<Integer> neighbours = new ArrayList<>();
                if (checkNeighbour(row_minus, j, neighbours)) continue;
                if (checkNeighbour(row, j - 1, neighbours)) continue;
                if (checkNeighbour(row, j + 1, neighbours)) continue;
                if (checkNeighbour(row_plus, j, neighbours)) continue;
                boolean cavity = true;
                for (Integer neighbour : neighbours) {
                    if (x <= neighbour) {
                        cavity = false;
                        break;
                    }
                }
                if (cavity) {
                    grid[i] = row.substring(0, j) + "X" + row.substring(j + 1);
                }
            }
        }
        return grid;
    }

    private static boolean checkNeighbour(String row, int j, List<Integer> neighbours) {
        String depth = Character.toString(row.charAt(j));
        if (depth.equals("X")) {
            return true;
        } else {
            neighbours.add(Integer.parseInt(depth));
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

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
