package euler;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/projecteuler/challenges/euler013
 */
public class ProjectEuler013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String[] number = new String[count];
        for (int i = 0; i < count; i++) {
            number[i] = sc.next();
        }
        System.out.println(getFirstTenDigitsOfSum(number));
    }

    private static String getFirstTenDigitsOfSum(String[] number) {
        StringBuilder sb = new StringBuilder();
        int q = number.length;
        int carry = 0;
        for ( int j = 1; j<=50; j++){
            int sumX = carry;
            for (int i = 0; i <q; i++) {
                sumX += Integer.valueOf(number[i].charAt(50-j)+"");
            }
            int r = sumX % 10;
            sb.append(r+"");
            carry = sumX/10;
        }
        sb.reverse();
        String result = carry+""+sb.toString();
        return result.substring(0,10);
    }
}
