package implementation;

import java.util.Scanner;

/**
 * search for a number in sorted integer array by comparing with boundaries and mid point to decide which sub-array
 * to look further
 */
public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] ar = new int[size];
        for (int i = 0; i < size; i++) {
            ar[i] = sc.nextInt();
        }
        printArray(quickSort(ar, 0, ar.length-1));
    }

    private static int[] quickSort(int[] ar, int start, int end) {
        /*
        mid := (lo + hi) / 2
        if A[mid] < A[lo]
        swap A[lo] with A[mid]
        if A[hi] < A[lo]
        swap A[lo] with A[hi]
        if A[mid] < A[hi]
        swap A[mid] with A[hi]
        pivot := A[hi]
        */
        int lo = start;
        int hi = end;
        int cur = (lo + hi)/2;
//      pivot placement
        partition(ar, lo, hi);
        for (int i = start; i < end; i++) {
            if (ar[i] > ar[cur]) {
                int temp = ar[cur - 1];
                ar[cur] = ar[i];
                ar[cur - 1] = ar[cur];
                ar[i] = temp;
            } else if (ar[cur] > ar[hi]) {

            }
        }
        quickSort(ar, start, cur);
        quickSort(ar, cur + 1, end);
        return new int[0];
    }

    private static void partition(int[] ar, int lo, int hi) {

    }

    static int[] printArray(int[] ar) {
        for (int integer : ar) {
            System.out.printf(Integer.toString(integer) + " ");
        }
        System.out.println();
        return ar;
    }


}
