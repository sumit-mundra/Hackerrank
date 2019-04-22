package euler;

import java.util.Scanner;

public class ProjectEuler008 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int k = in.nextInt();
            String num = in.next();
            System.out.println(getLargestProduct(num, n, k));
        }
    }

    private static long getLargestProduct(String num, int n, int k) {
        int maxProduct = 0;
        for (int i = 0; i <= n-k; i++) {
            boolean zeroFound = false;
            int[] digits = new int[k];
            for (int l = 0; l < k; l++) {
                digits[l] = Integer.parseInt(num.charAt(i + l)+"");
                if (digits[l] == 0) {
                    zeroFound = true;
                    break;
                }
            }
            if (zeroFound) {
                continue;
            } else{
                int product = getProduct(digits);
                maxProduct = maxProduct >= product ? maxProduct : product;
            }
        }
        return maxProduct;
    }

    private static int getProduct(int[] digits) {
        int result = 1;
        for ( int i : digits){
            result *= i;
        }
        return result;
    }

}
