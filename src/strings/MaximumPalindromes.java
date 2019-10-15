package strings;


import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

class Result {

    private static final int N = 1000000007;
    private static Map<Integer, Integer> modFactorials = new HashMap<>();
    private static Map<Integer, Integer> modFactorialsInverse = new HashMap<>();
    private static int[][] count;

    public static void initialize(String s) {
        count = new int[s.length()][26];
        for (int i = 0; i < 26; i++) {
            count[0][i] = 0;
        }
        count[0][s.charAt(0) - 'a']++;
        for (int i = 1; i < s.length(); i++) {
            count[i] = Arrays.copyOf(count[i - 1], 26);
            count[i][s.charAt(i) - 'a']++;
        }

        modFactorials.put(1, 1);
        int res = 1;
        for (int i = 2; i <= N; i++) {
            res = multiplyModN(res, modFactorials.get(i - 1));
            modFactorials.put(i, res);
        }

//        modFactorialsInverse.put(1, getFactorialInverseModN(1));
//        for (int i = 2; i <= N; i++) {
//            res = multiplyModN(getFactorialInverseModN(i), modFactorialsInverse.get(i - 1));
//            modFactorialsInverse.put(i,res);
//        }

    }

    public static int answerQuery(int l, int r) {
        l = l - 1;
        r = r - 1;

        int[] delta = new int[26];
        for (int i = 0; i < 26; i++) {
            if (l == 0) {
                delta[i] = count[r][i];
            } else {
                delta[i] = count[r][i] - count[l - 1][i];
            }
        }
        int unique = 0;
        List<Integer> factorialElem = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (delta[i] == 0) {
                continue;
            }
            if (delta[i] == 1) {
                unique++;
            } else {
                int value = 0;
                if (delta[i] % 2 == 0) {
                    value = delta[i] / 2;
                } else {
                    value = (delta[i] - 1) / 2;
                    unique++;
                }
                factorialElem.add(value);
            }
        }
        if (unique != 0) {
            return multiplyModN(unique, getPermuteCountModN(factorialElem));
        } else
            return getPermuteCountModN(factorialElem);
    }

    private static int getPermuteCountModN(List<Integer> factorialElem) {
        int sum = 0;
        for (Integer c : factorialElem) {
            sum += c;
        }
        int term1 = getFactorialModN(sum);
        int term2 = 1;

        for (Integer value : factorialElem) {
            term2 = multiplyModN(term2, getFactorialInverseModN(value));
        }
        return multiplyModN(term1, term2);
    }

    static int getFactorialModN(int a) {
        if (a <= 1) {
            return 1;
        }

        if (modFactorials.get(a) != null) {
            return modFactorials.get(a);
        } else {
            int x = getFactorialModN(a - 1);
            modFactorials.put(a - 1, x);
            return multiplyModN(a, x);
        }
    }


    static int getFactorialInverseModN(int a) {
        if (modFactorialsInverse.get(a) != null) {
            return modFactorialsInverse.get(a);
        } else {
            int res = getPowModN(getFactorialModN(a), N - 2);
            modFactorialsInverse.put(a, res);
            return res;
        }
    }

    static int multiplyModN(int a, int b) {
        a = a % N;
        b = b % N;
        if (b < 1000) {
            long sum = 0;
            for (int i = 0; i < b; i++) {
                sum = (sum + a) % N;
            }
            return (int) sum;
        }
        if (b % 2 == 0) {
            return (2 * multiplyModN(a, b / 2)) % N;
        } else {
            return (a + (2 * multiplyModN(a, (b - 1) / 2)) % N) % N;
        }
    }

    static int getPowModN(int a, int p) {
        a = a % N;
        if (p == 0) {
            return 1;
        }
        if (p == 1) {
            return a % N;
        }
        if (p % 2 == 0) {
            int a1 = getPowModN(a, p / 2);
            return multiplyModN(a1, a1);

        } else {
            int a1 = getPowModN(a, (p - 1) / 2);
            return multiplyModN(a, multiplyModN(a1, a1));
        }
    }

}

/**
 * https://www.hackerrank.com/challenges/maximum-palindromes/problem
 */
public class MaximumPalindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = bufferedReader.readLine();

        Result.initialize(s);

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int l = Integer.parseInt(firstMultipleInput[0]);

                int r = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.answerQuery(l, r);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
