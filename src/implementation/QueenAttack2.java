package implementation;

import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/queens-attack-2/problem
 */
public class QueenAttack2 {
    private static final Scanner scanner = new Scanner(System.in);

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        // 0 : +0
        // 1 : +45
        // 2 : +90
        // 3 : 135
        // 4 : 180
        // 5 : 235
        // 6 : 270
        // 7 : 315
        int[] length = new int[8];
        initialiseLength(length, c_q, r_q, n);
        for (int i = 0; i < obstacles.length; i++) {
            int ri = obstacles[i][0];
            int ci = obstacles[i][1];
            updateLength(length, ri, ci, r_q, c_q, n);
        }
        return sum(length);
    }

    private static int sum(int[] length) {
        int result = 0;
        for (int i : length) {
            result += i;
        }
        return result;
    }

    private static void initialiseLength(int[] length, int c_q, int r_q, int n) {
        length[0] = n - c_q;
        length[4] = c_q - 1;
        length[2] = n - r_q;
        length[6] = r_q - 1;
        length[1] = n - c_q >= n - r_q ? n - r_q : n - c_q;
        length[5] = c_q >= r_q ? r_q - 1 : c_q - 1;
        length[3] = n - r_q >= c_q - 1 ? c_q - 1 : n - r_q;
        length[7] = n - c_q >= r_q - 1 ? r_q - 1 : n - c_q;
    }

    private static void updateLength(int[] length, int ri, int ci, int rq, int cq, int n) {
        if (ri == rq && ci != cq) {
            // 0 and 4
            if (ci > cq) {
                updateLength(length, ci - cq - 1, 0);
            } else {
                updateLength(length, cq - ci - 1, 4);
            }
        } else if (ci == cq && ri != rq) {
            // 2 and 6
            if (ri > rq) {
                updateLength(length, ri - rq - 1, 2);
            } else {
                updateLength(length, rq - ri - 1, 6);
            }
        } else if (ri - rq == ci - cq) {
            // 1 and 5
            if (ri > rq) {
                updateLength(length, ri - rq - 1, 1);
            } else {
                updateLength(length, rq - ri - 1, 5);
            }
        } else if (ri - rq == cq - ci) {
            // 3 and 7
            if (ri < rq) {
                updateLength(length, rq - ri - 1, 7);
            } else {
                updateLength(length, ri - rq - 1, 3);
            }
        }
    }

    private static void updateLength(int[] length, int newLength, int index) {
        if (length[index] > newLength) {
            length[index] = newLength;
        }
    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
