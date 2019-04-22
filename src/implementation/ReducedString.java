package implementation;

import java.util.Scanner;

public class ReducedString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(superReducedString(input));
    }


    // Complete the superReducedString function below.
    static String superReducedString(String s) {
        char[] c = s.toCharArray();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        boolean isReduced = false;
        while (i < c.length) {
            if (i != (c.length - 1) && c[i + 1] == c[i]) {
                i = i + 2;
                isReduced = true;
            } else {
                sb.append(c[i]);
                i = i + 1;
            }
        }
        if (sb.toString().isEmpty()) {
            return "Empty String";
        }
        if(!isReduced){
            return sb.toString();
        }
        return superReducedString(sb.toString());
    }

}
