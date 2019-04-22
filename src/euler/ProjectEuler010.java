package euler;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProjectEuler010 {

    private static Set<Integer> primes = new HashSet<>();
    private static long[] sumPrimes = new long[1000000];

    public static void main(String[] args) {
        initPrimes();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            System.out.println(getSumOfPrimes(n));
        }
    }

    private static long getSumOfPrimes(int n) {
        return sumPrimes[n - 1];
    }

    private static void initPrimes() {
        primes.add(2);
        primes.add(3);
        primes.add(5);
        int l = 1;
        sumPrimes[0] = 0;
        sumPrimes[1] = 2;
        for (int i = 3; i <= 1000000; i++) {
            long prev = sumPrimes[l++];
            if (isPrime(i)) {
                long next = prev + i;
                sumPrimes[l] = next;
            } else {
                sumPrimes[l] = prev;
            }
        }
    }

    private static boolean isPrime(int number) {
        if (primes.contains(number)) {
            return true;
        }
        if (number == 1) {
            return false;
        }
        for (int l = 2; l <= Math.sqrt(number); l++) {
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