package strings;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/richie-rich/problem
 */
public class HighestValuePalindrome {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the highestValuePalindrome function below.
    static String highestValuePalindrome(String s, int n, int k) {
        return hvp(s, k, 0, n - 1);
    }

    static String hvp(String s, int k, int start, int end) {
        StringBuilder sb = new StringBuilder();
        int change = 0;
        Set<Integer> changeSet = new HashSet<>();
        int size = s.length();
        while (start < end) {
            char leftChar = s.charAt(start);
            char rightChar = s.charAt(end);
            if (leftChar == rightChar) {
                sb.append(leftChar);
            } else {
                if (leftChar > rightChar) {
                    changeSet.add(start);
                    sb.append(leftChar);
                } else {
                    changeSet.add(end);
                    sb.append(rightChar);
                }
                change++;
            }
            start++;
            end--;
        }

        String palindrome;
        if (size % 2 == 0) {
            palindrome = sb.toString() + reverse(sb.toString());
        } else {
            palindrome = sb.toString() + s.charAt(size / 2) + reverse(sb.toString());
        }
        String output;
        if (change > k) {
            return "-1";
        }
        k = k - change;
        int i = 0;
        int n = palindrome.length();
        StringBuilder lb = new StringBuilder();
        StringBuilder rb = new StringBuilder();
        while (i <= (n - 1) / 2) {
            int delta = 0;
            boolean alteration = false;
            if (i == n / 2 && n % 2 != 0) {
                if (palindrome.charAt(i) != '9') {
                    if (!changeSet.contains(i)) {
                        delta++;
                    }
                    if (k >= delta) {
                        lb.append('9');
                        k = k - delta;
                    } else {
                        lb.append(palindrome.charAt(i));
                    }
                } else {
                    lb.append('9');
                }
            } else {
                if (palindrome.charAt(i) != '9') {
                    if (!changeSet.contains(i)) {
                        delta++;
                    }
                    if (!changeSet.contains(n - 1 - i)) {
                        delta++;
                    }
                    if (k >= delta) {
                        alteration = true;
                        k = k - delta;
                        lb.append('9');
                        rb.append('9');
                    }
                }
                if (!alteration) {
                    lb.append(palindrome.charAt(i));
                    rb.append(palindrome.charAt(n - 1 - i));
                }
            }
            i++;
        }
        output = lb.toString() + reverse(rb.toString());
        return output;
    }

    static String reverse(String input) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int n = input.length();
        while (i < n) {
            sb.append(input.charAt(n - i - 1));
            i++;
        }
        return sb.toString();
    }


    public static void main(String[] args) throws IOException {

//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = bufferedReader.readLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String s = bufferedReader.readLine();

        String result = highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
