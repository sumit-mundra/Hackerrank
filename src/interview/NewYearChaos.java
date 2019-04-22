package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/new-year-chaos/problem
 */
public class NewYearChaos {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

        int expectedFirst = 1;
        int expectedSecond = 2;
        int expectedThird = 3;
        int totalBribes = 0;
        for (int i = 0; i < q.length; i++) {
            if (q[i] == expectedFirst) {
                expectedFirst = expectedSecond;
                expectedSecond = expectedThird;
                expectedThird++;
            } else if (q[i] == expectedSecond) {
                totalBribes++;
                expectedSecond = expectedThird;
                expectedThird++;
            } else if (q[i] == expectedThird) {
                totalBribes += 2;
                expectedThird++;
            } else {
                System.out.println("Too chaotic");
                return;
            }
        }
        System.out.println(totalBribes);
    }

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        List<int[]> list = new ArrayList<>();

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");


            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[] q = new int[n];
            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }
            list.add(q);
        }

        for (int tItr = 0; tItr < t; tItr++) {
            minimumBribes(list.get(tItr));
        }


        scanner.close();
    }
}
