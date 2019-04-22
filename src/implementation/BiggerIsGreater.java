package implementation;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/bigger-is-greater/problem?isFullScreen=true
 */
public class BiggerIsGreater {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        int length = w.length();
        boolean isMatch = false;
        int pos = 0;
        int swapPos = 0;
        for(int k = length - 2; k>=0; k--){
            for (int i = length-1; i >= k; i--) {
                for (int j = i - 1; j >= k; j--) {
                    isMatch = w.charAt(j) < w.charAt(i);
                    if (isMatch) {
                        pos = j;
                        swapPos = i;
                        break;
                    }
                }
                if (isMatch) {
                    break;
                }
            }
            if (isMatch) {
                break;
            }
        }

        if (isMatch) {
            StringBuilder sb = new StringBuilder();
            sb.append(w, 0, pos);
            sb.append(w.charAt(swapPos));
            StringBuilder rest = new StringBuilder();
            rest.append(w.charAt(pos)).append(w, pos + 1, swapPos).append(w, swapPos + 1, w.length());
            char[] second = rest.toString().toCharArray();
            Arrays.sort(second);
            sb.append(second);
            return sb.toString();
        } else return "no answer";
    }


    public static void main(String[] args) throws IOException {

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();
            System.out.println(biggerIsGreater(w));
        }


        scanner.close();
    }
}
