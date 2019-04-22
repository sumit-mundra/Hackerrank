package strings;

/**
 * Could not solve in 10 min
 * https://www.hackerrank.com/challenges/two-characters/problem
 */

import java.io.*;
import java.util.Arrays;

public class TwoCharacters {

    // Complete the alternate function below.
    static int alternate(String s) {
        int[] freq = new int[26];
        boolean[] duplicates = new boolean[26];
        int i = 0;
        while (i < s.length()) {
            if (i != s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                s = s.replace(String.valueOf(s.charAt(i)), "");
                i = 0;
                continue;
            }
            i++;
        }

        for (int j = 0; j < s.length(); j++) {
            freq[s.charAt(j) - 'a']++;
        }

        for (int j = 0; j < freq.length; j++) {
            System.out.println(j + " :: " + freq[j]);
        }
        System.out.println("s = " + s);
        Arrays.sort(freq);
        int result = 0;
        for (int j = freq.length - 1; j > 0; j--) {
            System.out.println(j + " :: " + freq[j]);
            if (Math.abs(freq[j] - freq[j - 1]) == 1) {
                {
                    int sum = freq[j] + freq[j - 1];
                    result = result < sum ? sum : result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

