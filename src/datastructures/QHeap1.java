package datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/qheap1
 */
public class QHeap1 {


    private static List<Integer> heapArr = new ArrayList<>();

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < q; i++) {
            String input = sc.nextLine();
            String[] data = input.split(" ");
            Integer operation = Integer.parseInt(data[0]);
            Integer value = null;
            if (data.length > 1) {
                value = Integer.parseInt(data[1]);

            }
            heapOperation(operation, value);
        }
    }

    private static void print() {
        for (Integer i : heapArr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void heapOperation(Integer operation, Integer value) {
        switch (operation) {
            case 1: {
                add(value);
                break;
            }
            case 2: {
                remove(value);
                break;
            }
            case 3: {
                System.out.println(peek());
                break;
            }
        }

    }

    private static int peek() {
        return heapArr.get(0);
    }

    private static void add(int value) {
        heapArr.add(value);
        int n = heapArr.size();
        if (n > 1)
            sift(n - 1);
    }

    private static void sift(int k) {
        if (k == 0) {
            return;
        }
        int n = heapArr.size();
        int sibling = -1;
        int pI;

        if (k % 2 == 0) {
            pI = k / 2 - 1;
            sibling = k - 1;
        } else {
            pI = k / 2;
            if (k + 1 < n) {
                sibling = k + 1;
            }
        }
        int parent = heapArr.get(pI);
        int min = parent;
        int minIndex = pI;

        int self = heapArr.get(k);
        if (min > self) {
            minIndex = k;
            min = self;
        }

        if (sibling != -1) {
            if (heapArr.get(sibling) < min) {
                minIndex = sibling;
                min = heapArr.get(sibling);
            }
        }

        //swap if needed with parent
        if (minIndex != pI) {
            heapArr.set(minIndex, parent);
            heapArr.set(pI, min);
            sift(pI);
        }
    }

    private static void remove(int value) {
        int i = 0;
        while (i < heapArr.size()) {
            if (!heapArr.get(i).equals(value)) {
                i++;
            } else {
                break;
            }
        }
        int lastValue = heapArr.get(heapArr.size() - 1);
        if (i == heapArr.size() - 1) {
            heapArr.remove(heapArr.size() - 1);
        } else {
            heapArr.set(i, lastValue);
            heapArr.remove(heapArr.size() - 1);
            heapify(i);
        }
    }

    private static void heapify(int k) {
        int n = heapArr.size();
        int self = heapArr.get(k);
        int minIndex = k;
        int min = self;

        if (2 * k + 1 < n) {
            int lChild = heapArr.get(2 * k + 1);
            if (min > lChild) {
                min = lChild;
                minIndex = 2 * k + 1;
            }
        }
        if (2 * k + 2 < n) {
            int rChild = heapArr.get(2 * k + 2);
            if (min > rChild) {
                min = rChild;
                minIndex = 2 * k + 2;
            }
        }

        //swap
        if (minIndex != k) {
            heapArr.set(k, min);
            heapArr.set(minIndex, self);
            heapify(minIndex);
        }
    }
}

