package euler;

import java.util.HashMap;
import java.util.Scanner;

public class ProjectEuler001 {

    static HashMap<Integer, Long> store = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        long result;
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            if (store.containsKey(n)) {
                result = store.get(n);
            } else {
                result = getSum(n);
                store.put(n, result);
            }
            System.out.println(result);
        }
    }

    static long getSum(int n) {
        long sumOf3 = sumOfAp(3, (n - 1) / 3, 3);
        long sumOf5 = sumOfAp(5, (n - 1) / 5, 5);
        long sumOf15 = sumOfAp(15, (n - 1) / 15, 15);
        long result = 0;
        if (n >= 3) {
            result += sumOf3;
        }
        if (n >= 5) {
            result += sumOf5;
        }
        if (n >= 15) {
            result -= sumOf15;
        }
        return result;
    }

    static int getLastMultipleLessThanN(int factor, int n) {
        return (n / factor) * factor;
    }

    static long sumOfAp(int first, int numberOfTerms, int delta) {
        long result = numberOfTerms * (2L * first + (numberOfTerms - 1) * delta) / 2;
        return result;

    }
}