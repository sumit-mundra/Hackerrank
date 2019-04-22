package euler;

import java.util.Scanner;

public class ProjectEuler009 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            System.out.println(getCByMaths(n));
        }
    }

    static int getCByMaths(int n) {
        int maxProduct = -1;
        double start = (Math.sqrt(2) - 1) * n;
        double end = n / 2;
        int x = Double.valueOf(start).intValue();
        int y = Double.valueOf(end).intValue();
        for (int c = x + 1; c < y; c++) {
            int discriminant = c * c - n * n + 2 * n * c;
            if (discriminant < 0) {
                continue;
            }
            double x1 = ((n - c) + Math.sqrt(discriminant)) / 2;
            double x2 = ((n - c) - Math.sqrt(discriminant)) / 2;
            int b1 = Double.valueOf(x1).intValue();
            int b2 = Double.valueOf(x2).intValue();

            int a1 = n - (c + b1);
            int a2 = n - (c + b2);

            if (a1 > 0 && b1 > 0 && (a1 * a1 + b1 * b1 == c * c)) {
                int product = a1 * b1 * c;
                maxProduct = maxProduct > product ? maxProduct : product;
            }

            if (a2 > 0 && b2 > 0 && (a2 * a2 + b2 * b2 == c * c)) {
                int product = a2 * b2 * c;
                maxProduct = maxProduct > product ? maxProduct : product;
            }
        }
        return maxProduct;
    }
}