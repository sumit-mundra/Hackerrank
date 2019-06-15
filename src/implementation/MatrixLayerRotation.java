package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * https://www.hackerrank.com/challenges/matrix-rotation-algo/problem
 */
public class MatrixLayerRotation {
    static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        // rotation is ineffective for number of element in loop times ie. rotation must be done loopwise
        int min = Math.min(m, n);
        int maxLoop = min / 2;
        for (int loopIndex = 0; loopIndex < maxLoop; loopIndex++) {
            int rotation = r % (2 * (m - 2 * loopIndex + n - 2 * loopIndex - 2));
            rotate(matrix, loopIndex, rotation);
        }
        print(matrix);
    }

    private static void print(List<List<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(0).size(); j++) {
                System.out.printf(matrix.get(i).get(j).toString() + " ");
            }
            System.out.println();
        }
    }

    private static void rotate(List<List<Integer>> matrix, int loopIndex, int rotation) {
        int iteration = 0;
        while (iteration++ < rotation) {
            int m = matrix.size();
            int n = matrix.get(0).size();
            // left shift
            int top = loopIndex;
            int colI = loopIndex;
            Integer temp = matrix.get(top).get(loopIndex);
            while (colI < n - loopIndex - 1) {
                matrix.get(top).add(colI, matrix.get(top).get(colI + 1));
                matrix.get(top).remove(colI + 1);
                colI++;
            }

            // upward
            int right = n - loopIndex - 1;
            int rowI = loopIndex;
            while (rowI < m - loopIndex - 1) {
                matrix.get(rowI).add(right, matrix.get(rowI + 1).get(right));
                matrix.get(rowI).remove(right + 1);
                rowI++;
            }

            // right shift
            int bottom = m - loopIndex - 1;
            colI = n - loopIndex - 1;
            while (colI > loopIndex) {
                matrix.get(bottom).add(colI, matrix.get(bottom).get(colI - 1));
                matrix.get(bottom).remove(colI + 1);
                colI--;
            }

            //down shift
            int left = loopIndex;
            rowI = m - loopIndex - 1;
            while (rowI > loopIndex + 1) {
                matrix.get(rowI).add(left, matrix.get(rowI - 1).get(left));
                matrix.get(rowI).remove(left + 1);
                rowI--;
            }

            //firstPlace
            matrix.get(loopIndex + 1).add(left, temp);
            matrix.get(loopIndex + 1).remove(left + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
