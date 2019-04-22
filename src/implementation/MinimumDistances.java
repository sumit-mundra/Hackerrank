package implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/minimum-distances/problem
 */
public class MinimumDistances {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(minimumDistances(a));
    }

    static int minimumDistances(int[] a) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        boolean noDupFound = true;
        int minDistance = -1;
        for (int i = 0; i < a.length; i++) {
            if (hashMap.get(a[i]) == null) {
                hashMap.put(a[i], i);
            } else {
                noDupFound = false;
                int distance = Math.abs(i - hashMap.get(a[i]));
                if (minDistance < 0) {
                    minDistance = distance;
                } else {
                    minDistance = distance < minDistance ? distance : minDistance;
                }
            }
        }
        if (noDupFound) {
            return -1;
        } else {
            return minDistance;
        }
    }
}

