package sorting;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class FraudulentActivityNotifications {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        int result = 0;
        int n = expenditure.length;
        if (d == n) {
            return 0;
        }
        int[] count = new int[201];
        for (int i = 0; i < n; i++) {
            if (i < d) {
                count[expenditure[i]]++;
            } else {
                int m = getDoubleMedian(count, d);
                printLast(expenditure, i, d);
                System.out.println("m = " + m + "::expenditure = " + expenditure[i] + ":: " + (expenditure[i] >= m));
                if (expenditure[i] >= m) {
                    result++;
                }
                count[expenditure[i]]++;
                count[expenditure[i - d]]--;
            }
        }
        return result;
    }

    private static void printLast(int[] expenditure, int i, int d) {
        StringBuilder sb = new StringBuilder();
        for (int j = i - d; j < i; j++) {
            sb.append(expenditure[j]);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    private static int getDoubleMedian(int[] count, int size) {
        int sum = 0;
        int old = 0;
        boolean even = size % 2 == 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                if (sum == size / 2) {
                    return even ? i + old : i * 2;
                } else if (sum < size / 2) {
                    sum += count[i];
                    if (sum > size / 2) {
                        return 2 * i;
                    }
                }
                old = i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}