package leetcode;

public class Testcase {
    class Solution {
        public int balancedStringSplit(String s) {
            char[] ar = s.toCharArray();
            char prev = '0';
            int prevLength = 0;
            int curLength = 0;
            int result = 0;
            for (int i = 1; i < ar.length; i++) {
                if (prev == '0') {
                    prev = ar[i];
                    prevLength++;
                }
                if (ar[i] == prev) {
                    if (curLength == 0) {
                        prevLength++;
                    } else {
                        curLength = 0;
                        prevLength = 1;

                        result++;
                    }
                } else {
                    if (curLength < prevLength) {
                        curLength++;
                    } else {
                        result++;
                        curLength = 0;
                        prevLength = 0;
                        prev = '0';
                    }
                }
            }
            return result;
        }
    }
}
