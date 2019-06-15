package strings;


import java.io.*;
import java.util.stream.IntStream;

public class PalindromeIndex {

    // Complete the palindromeIndex function below.

    static int palindromeIndex(String s) {
        int i = 0;
        int j = s.length() - 1;
        if (j == i + 1) {
            return s.charAt(j) == s.charAt(i) ? -1 : 0;
        }
        while (j - i >= 1) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                boolean skipJ = s.charAt(i) == s.charAt(j - 1);
                boolean skipI = s.charAt(i + 1) == s.charAt(j);
                if (skipJ && !skipI) {
                    if (checkPalindrome(s.substring(i, j))) {
                        return j;
                    } else {
                        return -1;
                    }
                } else {
                    if (skipI && !skipJ) {
                        if (checkPalindrome(s.substring(i + 1, j + 1))) {
                            return i;
                        } else {
                            return -1;
                        }
                    } else if (skipJ && skipI) {
                        System.out.println(s.substring(i, j));
                        if (checkPalindrome(s.substring(i, j))) {
                            return j;
                        } else if (checkPalindrome(s.substring(i + 1, j + 1))) {
                            return i;
                        } else {
                            return -1;
                        }
                    } else {
                        return -1;
                    }
                }
            }
        }
        return -1;
    }

    private static boolean checkPalindrome(String input) {
        boolean result = true;
        int i = 0;
        int j = input.length() - 1;
        while (j > i) {
            if (input.charAt(i) == input.charAt(j)) {
                i++;
                j--;
            } else {
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(bufferedReader.readLine());
        String[] data = new String[q];
        IntStream.range(0, q).forEach(i -> {
            try {
                data[i] = bufferedReader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        for (int qItr = 0; qItr < data.length; qItr++) {
            int result = palindromeIndex(data[qItr]);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        bufferedReader.close();

    }
}

