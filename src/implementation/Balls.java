package implementation;

import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem?h_r=profile
 */
public class Balls {
    private static final Scanner scanner = new Scanner(System.in);

    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {
        int n = container.length;
        boolean[][] possible = new boolean[n][n];
        for(int i = 0; i< n; i++){
            for (int j = 0; j < n; j++) {
                long jBallsInNonIContainer = getSumOfJInNonJContainer(container, j) - container[i][j];
                long nonJBallsInContainerI = getSumOfNonJBalls(container[i], j);
                if (jBallsInNonIContainer == nonJBallsInContainerI) {
                    possible[i][j] = true;
                }else{
                    possible[i][j] = false;
                }
            }
        }
        boolean result = true;
        for (int i = 0; i < n; i++) {
            boolean indexResult = false;
            for (int j = 0; j < n; j++) {
                indexResult = indexResult || possible[j][i];
            }
            result = result && indexResult;
            if(!result){
                break;
            }
        }
        return result ? "Possible" : "Impossible";
    }

    static long getSumOfNonJBalls(int[] balls, int j) {
        long result = 0L;
        for (int i = 0; i < balls.length; i++) {
            result += balls[i];
        }
        return result - balls[j];
    }

    static long getSumOfJInNonJContainer(int[][] containers, int j) {
        long result = 0L;
        for (int i = 0; i < containers.length; i++) {
            result += containers[i][j];
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] result = new String[q];
        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            result[qItr] = organizingContainers(container);
//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
        }
        for (String r : result) {
            System.out.println(r);
        }


//        bufferedWriter.close();

        scanner.close();
    }
}


