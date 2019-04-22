package euler;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProjectEuler003 {


    private static Set<Long> primes = new HashSet<>();

    public static void main(String[] args) {
        initPrimes();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long n = in.nextLong();
            System.out.println(getLargestPrimeFactor(n));
        }
    }

    private static void initPrimes() {
        primes.add(2L);
        primes.add(3L);
        primes.add(5L);
        for (long i = 1; i <= 1000000; i++) {
            isPrime(i);
        }
    }

    private static long getLargestPrimeFactor(long n) {
        long quotient = n;
        for (long prime : primes) {
            while (quotient % prime == 0) {
                quotient /= prime;
            }
            if (quotient == 1) {
                return prime;
            }
        }
        return quotient;
    }

    static boolean isPrime(long number) {
        if (primes.contains(number)) {
            return true;
        }
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
        primes.add(number);
        return true;
    }
}