package strings;
/**
 * https://www.hackerrank.com/challenges/camelcase/problem
 */

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * https://www.hackerrank.com/challenges/camelcase/problem Eight minutes
 */
public class CamelCase {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the camelcase function below.
    static int camelcase(String s) {
        Pattern p = Pattern.compile("[A-Z]*");
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            Matcher matcher = p.matcher(String.valueOf(s.charAt(i)));
            if (matcher.matches()) {
                count++;
            }
        }
        return count+1;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        int result = camelcase(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
