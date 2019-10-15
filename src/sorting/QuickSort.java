package sorting;

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
        quickSort(ar, 0, size - 1);
        printArray(ar, 0, size - 1);
    }

    private static int[] quickSort(int[] ar, int start, int end) {
        if (start >= end) {
            return ar;
        }
        if (end - start > 1) {
            int pivot = partition(ar, start, end);
            printArray(ar, start, end);
            quickSort(ar, start, pivot - 1);
            quickSort(ar, pivot + 1, end);
        } else if (end - start == 1) {
            if (ar[start] > ar[end]) {
                swap(ar, start, end);
            }
        }
        return ar;
    }

    private static void swap(int[] ar, int x, int y) {
        int temp = ar[y];
        ar[y] = ar[x];
        ar[x] = temp;
    }

    private static int partition(int[] ar, int start, int end) {
        int mid = (start + end) / 2;
        int pivot = ar[mid];
        swap(ar, mid, end);
        int lo = start;
        int hi = end - 1;
        while (lo <= hi) {
            if (ar[lo] <= pivot) {
                lo++;
                continue;
            }
            if (ar[hi] >= pivot) {
                hi--;
                continue;
            }
            if (ar[lo] > pivot && ar[hi] < pivot) {
                swap(ar, lo, hi);
            }
        }
        swap(ar, lo, end);
        return lo;
    }

    private static int[] printArray(int[] ar, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(ar[i] + " ");
        }
        System.out.println();
        return ar;
    }

}
