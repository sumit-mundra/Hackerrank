package euler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler014
 */
public class ProjectEuler014 {

    static Map<Integer, Integer> lookup = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        int[] numbers = new int[testCases];
        int maxInput = 0;
        for (int i = 0; i < testCases; i++) {
            numbers[i] = sc.nextInt();
            maxInput = numbers[i] > maxInput ? numbers[i] : maxInput;
        }
        init(maxInput);
        for (int i = 0; i < testCases; i++) {
            System.out.println(getMaxNumberForMaxChainSize(numbers[i]));
        }
    }

    private static void init(int maxInput) {
        lookup.put(1, 1);
        for (int i = 0; i < maxInput; i++) {
            getChainSize(i + 1);
        }
    }

    private static int getMaxNumberForMaxChainSize(int number) {
        int max = 0;
        int result = 0;
        for (int i = 1; i <= number; i++) {
            int chainSize = getChainSize(i);
            if (chainSize >= max) {
                max = chainSize;
                if (i >= result)
                    result = i;
            }
        }
        return result;
    }

    static int getChainSize(int number) {
        int in = number;
        int count = 1;
        while (in != 1) {
            if (in % 2 == 0) {
                in /= 2;
            } else {
                in = 3 * in + 1;
            }
            count++;
        }
        if (lookup.get(in) == null) {
            if (in % 2 == 0) {
                in /= 2;
            } else {
                in = 3 * in + 1;
            }
            int chainSize = getChainSize(in) + 1;
            lookup.put(number, chainSize);
            return chainSize;
        } else {
            return lookup.get(number);
        }
    }
}
