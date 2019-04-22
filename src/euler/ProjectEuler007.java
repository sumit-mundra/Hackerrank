package euler;

import java.util.*;

public class ProjectEuler007 {
    private static SortedSet<Long> primes = new TreeSet<>();

    public static void main(String[] args) {
        initPrimes();
        System.out.println("Ready");
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            System.out.println(getNthPrime(n));
        }
    }

    private static long getNthPrime(int n) {
        Iterator<Long> iterator = primes.iterator();
        long prime = iterator.next();
        for (int i = 1; i < primes.size(); i++) {
            if (i == n) {
                return prime;
            }
            prime = iterator.next();
        }
        return 0;
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

    private static void initPrimes() {
        primes.add(2L);
        primes.add(3L);
        primes.add(5L);
        long i = 1;
        while(primes.size()<10001){
            isPrime(i++);
        }
    }
}
