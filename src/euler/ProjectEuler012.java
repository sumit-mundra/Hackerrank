package euler;

import java.util.*;

/**
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler012
 */
public class ProjectEuler012 {
    static final int PRIME_MAX_COUNT = 1000000;
    static Map<Long, Integer> countDivisor = new HashMap<>();
    static long[] primes = new long[PRIME_MAX_COUNT];

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int maxN = 0;
        int[] queries = new int[t];
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            if (n > maxN) {
                maxN = n;
            }
            queries[i] = n;
        }
        initPrimes();
        initTN(maxN + 1);
        for (int query : queries) {
            System.out.println(divisibleTriangularNumber(query));
        }
    }

    private static void initTN(int maxNumber) throws Exception {
        int i = 1;
        int divisorCount;
        do {
            long number = (i * (i + 1)) / 2;
            divisorCount = getDivisorCount(number);
            countDivisor.put(number, divisorCount);
            i++;
        } while (divisorCount <= maxNumber);
    }

    private static int getDivisorCount(long number) throws Exception {
        int divisorCount = 1;
        for (Long prime : primes) {
            int count = 0;
            while (number % prime == 0) {
                number = number / prime;
                count++;
            }
            divisorCount *= (count + 1);
            if (number == 1) {
                break;
            }
        }
        if (number != 1) {
            throw new Exception("Need more primes");
        }
        return divisorCount;
    }


    private static long divisibleTriangularNumber(int n) {
        // get first triangular number over n divisors
        ArrayList<Long> list = new ArrayList<>(countDivisor.keySet());
        Collections.sort(list);
        for (Long number : list) {
            if (countDivisor.get(number) > n) {
                return number;
            }
        }
        return 0;
    }

    private static void initPrimes() {
        primes[0] = 2;
        primes[1] = 3;
        primes[2] = 5;
        long i = 6;
        int j = 3;
        while (i < PRIME_MAX_COUNT) {
            if (isPrime(i)) {
                primes[j++] = i;
            }
            i++;
        }
    }

    static boolean isPrime(long number) {
        if (number == 1) {
            return false;
        }
        for (long l = 2; l <= Math.sqrt(number); l++) {
            if (l > 5 && l % 5 == 0) {
                continue;
            }
            if (l > 3 && l % 3 == 0) {
                continue;
            }
            if (l > 2 && l % 2 == 0) {
                continue;
            }
            if (number % l == 0) {
                return false;
            }
        }
        return true;
    }
}
