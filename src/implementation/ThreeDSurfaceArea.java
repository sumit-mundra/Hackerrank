package implementation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class ThreeDSurfaceArea {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the surfaceArea function below.
    static int surfaceArea(int[][] A) {
        int cols = A[0].length;
        int rows = A.length;
        int area = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                area += getArea(A, i, j);
            }
        }
        return area;
    }

    private static int getArea(int[][] A, int i, int j) {
        int rows = A.length;
        int cols = A[0].length;
        int iPlusOne = A[i][j];
        int iMinusOne = A[i][j];
        int jPlusOne = A[i][j];
        int jMinusOne = A[i][j];
        if (i + 1 < rows) {
            iPlusOne = A[i + 1][j] - A[i][j];
            if (iPlusOne < 0) {
                iPlusOne = 0;
            }
        }

        if (i - 1 >= 0) {
            iMinusOne = A[i - 1][j] - A[i][j];
            if (iMinusOne < 0) {
                iMinusOne = 0;
            }
        }

        if (j + 1 < cols) {
            jPlusOne = A[i][j + 1] - A[i][j];
            if (jPlusOne < 0) {
                jPlusOne = 0;
            }
        }
        if (j - 1 >= 0) {
            jMinusOne = A[i][j - 1] - A[i][j];
            if (jMinusOne < 0) {
                jMinusOne = 0;
            }
        }
        return iPlusOne + iMinusOne + jPlusOne + jMinusOne + 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] HW = scanner.nextLine().split(" ");

        int H = Integer.parseInt(HW[0]);

        int W = Integer.parseInt(HW[1]);

        int[][] A = new int[H][W];

        for (int i = 0; i < H; i++) {
            String[] ARowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < W; j++) {
                int AItem = Integer.parseInt(ARowItems[j]);
                A[i][j] = AItem;
            }
        }

        int result = surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
