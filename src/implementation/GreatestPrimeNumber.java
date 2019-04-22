package implementation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GreatestPrimeNumber {

    Set<Long> primes = new HashSet<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long n = in.nextLong();
            long multipleOfSix = (n/6)*6;
            long i = multipleOfSix - 1;
            long j = multipleOfSix - 5;
            while( i >=5 || j>=1){
                if (isPrime(i)) {
                    System.out.println(i);
                    break;
                }
                i = i - 6;
                j = j - 6;
            }
        }
    }


    static boolean isPrime(long number) {
        for (long l = 2; l <= Math.sqrt(number); l++) {
            if (number == 1) {
                return false;
            }
            if (number == 2 || number == 3 || number == 5) {
                return true;
            }
            if (number % l == 0) {
                return false;
            }
        }
        return true;
    }
}