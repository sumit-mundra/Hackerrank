package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Knuth Morris Pratt algo for pattern search (NAYH)
 */
public class KMP {
    public static void main(String[] args) {
        kmp("abc", "abdabfabrababababfabcbaabg");
    }

    static void kmp(String needle, String haystack) {
        int i = 0;
        int j = 0;
        int match = 0;
        List<Integer> matches = new ArrayList<>();
        int[] jump = getJumpTable(needle);
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                if (j == needle.length()) {
                    matches.add(i - j + 1);
                    j = jump[j];
                    match++;
                }
                i++;
            } else {
                j = jump[j];
                if (j < 0) {
                    j++;
                    i++;
                }
            }
        }
        System.out.println("match = " + match);
        System.out.println("matches = " + matches);
    }


    static int[] getJumpTable(String s) {
        int[] T = new int[s.length() + 1];
        int cnd = 0;
        int pos = 1;
        T[0] = -1;
        while (pos < s.length()) {
            if (s.charAt(pos) == s.charAt(cnd)) {
                T[pos] = T[cnd];
            } else {
                T[pos] = cnd;
                cnd = T[cnd];
                boolean x = cnd >= 0 && s.charAt(pos) != s.charAt(cnd);
                while (cnd >= 0 && s.charAt(pos) != s.charAt(cnd)) {
                    cnd = T[cnd];
                }
            }
            pos++;
            cnd++;
        }
        T[pos] = cnd;
//        print(T);
        return T;
    }

    private static void print(int[] t) {
        for (int i : t) {
            System.out.printf(i + " ");
        }
        System.out.println();
    }

}
