package strings;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/weighted-uniform-string/problem
 */
public class WeightedUniformString {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {
        Set<Integer> universeWeight = new HashSet<>();
        int i = 0;
        while (i < s.length()) {
            int weight = s.charAt(i) - 'a' + 1;
            int count = 1;
            universeWeight.add(count * weight);
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                universeWeight.add(count * weight);
                i++;
            }
            i++;
        }
        String[] result = new String[queries.length];
        int k = 0;
        for (int query : queries) {
            result[k++] = universeWeight.contains(query) ? "Yes" : "No";
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

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

