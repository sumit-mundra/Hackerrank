package implementation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class TheGridSearch {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String YES = "YES";
    private static final String NO = "NO";

    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) {
        boolean match = false;
        for (int j = 0; j <= G.length - P.length; j++) {
            if (isMatch(G, P, j)) {
                match = true;
                break;
            }
        }
        return match ? YES : NO;
    }

    private static boolean isMatch(String[] G, String[] P, int i) {
        String firstRowPattern = P[0];
        String row = G[i];
        int occurrence = row.indexOf(firstRowPattern);
        if (occurrence == -1) {
            return false;
        } else {
            boolean match = false;
            while (occurrence != -1) {
                match = checkThisOccurrence(G, P, i, occurrence);
                if (match) {
                    break;
                }
                occurrence = row.indexOf(firstRowPattern, occurrence + 1);
            }
            return match;
        }
    }

    private static boolean checkThisOccurrence(String[] G, String[] P, int i,
                                               int occurrenceStart) {
        boolean match = true;
        int j = 0;
        int width = P[0].length();
        while (j < P.length) {
            String substring = G[i].substring(occurrenceStart, occurrenceStart + width);
            String pattern = P[j];
            if (!substring.equals(pattern)) {
                match = false;
                break;
            }
            i++;
            j++;
        }
        return match;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = gridSearch(G, P);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
