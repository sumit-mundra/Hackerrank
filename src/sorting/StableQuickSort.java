package sorting;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Stable quicksort uses external space to maintain left right and equal arrays in partition method
 */
public class StableQuickSort {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());

        NewInteger[] ar = new NewInteger[size];
        for (int i = 0; i < size; i++) {
            String array = reader.readLine();
            String[] data = array.split(" ");
            if (data.length > 1) {
                NewInteger item = new NewInteger(Integer.parseInt(data[0]), data[1]);
                ar[i] = item;
            } else {
                ar[i] = new NewInteger(Integer.parseInt(data[0]), null);
            }

        }
        StableQuickSort.quickSort(ar, 0, size - 1);
        print(ar, 0, size - 1, "Result");

    }

    private static <T extends Comparable<T>> void quickSort(T[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        if (end - start < 2) {
            if (a[start].compareTo(a[end]) > 0) {
                T temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
        } else {
            print(a, start, end, "Full array");
            System.out.println();
            int finalPos = partition(a, start, end);
            print(a, start, finalPos - 1, "Left sub-array");
            System.out.print(" ");
            print(a, finalPos + 1, end, "Right sub-array");
            System.out.println();

            quickSort(a, start, finalPos - 1);
            quickSort(a, finalPos + 1, end);
        }

    }

    /**
     * @return pivot position
     */
    private static <T extends Comparable<T>> int partition(T[] ar, int start, int end) {
        // partition the array with help of extra arrays to maintain order
        int pivotIndex = getPivotIndex(ar, start, end);
        int result = 0;
        T cur = ar[pivotIndex];
        List<T> leftAr = new ArrayList<>();
        List<T> rightAr = new ArrayList<>();
        List<T> equalAr = new ArrayList<>();
        for (int i = start; i < pivotIndex; i++) {
            if (ar[i].compareTo(cur) < 0) {
                leftAr.add(ar[i]);
            } else if (ar[i].compareTo(cur) == 0) {
                equalAr.add(ar[i]);
            } else {
                rightAr.add(ar[i]);
            }
        }
        result += equalAr.size();
        equalAr.add(cur);

        for (int i = pivotIndex + 1; i <= end; i++) {
            if (ar[i].compareTo(cur) < 0) {
                leftAr.add(ar[i]);
            } else if (ar[i].compareTo(cur) == 0) {
                equalAr.add(ar[i]);
            } else {
                rightAr.add(ar[i]);
            }
        }
        result += leftAr.size();
        int i = 0;
        int j = start;
        while (i < leftAr.size()) {
            ar[j++] = leftAr.get(i++);
        }
        i = 0;
        while (i < equalAr.size()) {
            ar[j++] = equalAr.get(i++);
        }
        i = 0;
        while (i < rightAr.size()) {
            ar[j++] = rightAr.get(i++);
        }
        return start + result;
    }

    private static <T extends Comparable<T>> int getPivotIndex(T[] a, int start, int end) {
        int mid = (start + end) / 2;
        if (a[start].compareTo(a[mid]) > 0) {
            if (a[mid].compareTo(a[end]) > 0) {
                return mid;
            } else {
                return (a[start].compareTo(a[end]) > 0) ? end : start;
            }
        } else {
            if (a[mid].compareTo(a[end]) < 0) {
                return mid;
            } else {
                return (a[start].compareTo(a[end]) > 0) ? start : end;
            }
        }
    }

    private static <T extends Comparable<T>> void print(T[] a, int start, int end, String label) {
        if (label != null && label.length() > 0) {
            System.out.print(label + ":: ");
        }
        for (int i = start; i <= end; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class NewInteger implements Comparable<NewInteger> {
        private Integer value;
        private String label;

        NewInteger(int value, String label) {
            this.value = value;
            this.label = label;
        }

        @Override
        public int compareTo(NewInteger o) {
            return this.value.compareTo(o.value);
        }

        @Override
        public String toString() {
            return (this.label != null) ? (this.value + ":" + this.label) : String.valueOf(this.value);
        }

    }

}
