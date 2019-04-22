package euler;

import java.util.*;

public class ProjectEuler005 {

    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) {
        // n is below 40
        initPrimes();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            System.out.println(getSmallestMultiple(n));
        }
    }

    private static long getSmallestMultiple(int number) {
        // get all prime factors for all number from 1 to n
        // find the highest power for all factors found
        // multiply them all to get smallest multiple divisible by all
        Set<Integer> factors = new HashSet<>();
        for (int i = 2; i <= number; i++) {
            factors.addAll(getPrimeFactors(i));
        }
        long result = 1L;
        for ( int factor : factors){
            result *= highestFactor(number, factor);
        }
        return result;

    }

    private static List<Integer> getPrimeFactors(int number) {
        List<Integer> result = new ArrayList<>();
        for (int prime : primes) {
            if (prime > number)
                break;
            if (number % prime == 0) {
                result.add(prime);
            }
        }
        return result;
    }

    private static long highestPowerOfBase(int number, int base) {
        return Double.valueOf(Math.log(number) / Math.log(base)).longValue();
    }

    private static long highestFactor(int number, int primeFactor) {
        return Double.valueOf(Math.pow(primeFactor, highestPowerOfBase(number, primeFactor))).longValue();
    }

    private static void initPrimes() {
        primes.add(2);
        primes.add(3);
        primes.add(5);
        for (int i = 2; i <= 40; i++) {
            isPrime(i);
        }
    }

    static boolean isPrime(int number) {
        if (primes.contains(number)) {
            return true;
        }
        if (number == 1) {
            return false;
        }
        for (int l = 2; l <= Math.sqrt(number); l++ ) {
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