package euler;

import java.util.*;

public class ProjectEuler004 {

    static SortedSet<Integer> list = new TreeSet<>();

    public static void main(String[] args) {
        getAllPalindromes();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int result = 0;
            for (int i : list) {
                if (i >= n) {
                    break;
                }
                result = i;
            }
            System.out.println(result);
        }
    }

    static void getAllPalindromes() {
        for (int i = 101; i < 1000; i++) {
            for (int j = 101; j < 1000; j++) {
                int number = i * j;
                if (isPalindrome(number)) {
                    list.add(number);
                }
            }
        }
    }

    private static boolean isPalindrome(int input) {
        String s = input + "";
        if(s.startsWith("0")){
            s.replace("0","");
        }
        char[] number = s.toCharArray();
        boolean result = true;
        int length = number.length;
        for (int i = 0; i < length / 2; i++) {
            if (number[i] != number[length - 1 - i]) {
                result = false;
            }
        }
        return result;
    }

}
