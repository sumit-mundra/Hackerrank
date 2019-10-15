package datastructures;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;


public class JesseAndCookies {

    private static final Scanner scanner = new Scanner(System.in);

    /*
     * Complete the cookies function below.
     */
    static int cookies(int k, int[] A) {
        int count = 0;
        int size = A.length;
        for (int i = size / 2; i >= 0; i--) {
            heapify(A, size, i);
        }

        while (A[0] < k) {
            if (size < 2) {
                return -1;
            }
            int min1 = extractMin(A, size);
            size--;
            int min2 = extractMin(A, size);
            size--;
            int newCookie = min1 + 2 * min2;
            A[size] = newCookie;
            size++;
            sift(A, size, size - 1);
            count++;
        }
        return count;
    }

    private static int extractMin(int[] A, int size) {
        int result = A[0];
        int last = A[size - 1];
        A[0] = last;
        size--;
        heapify(A, size, 0);
        return result;
    }

    static void heapify(int[] A, int size, int index) {
        int lChild = 2 * index + 1;
        int rChild = 2 * index + 2;
        int minIndex = index;

        if (lChild < size && A[lChild] < A[minIndex]) {
            minIndex = lChild;
        }

        if (rChild < size && A[rChild] < A[minIndex]) {
            minIndex = rChild;
        }

        if (minIndex != index) {
            int temp = A[index];
            A[index] = A[minIndex];
            A[minIndex] = temp;
            heapify(A, size, minIndex);
        }
    }

    static void sift(int[] A, int size, int index) {
        if (index == 0) {
            return;
        }
        int parentIndex;
        if (index % 2 == 0) { // right child
            parentIndex = (index / 2) - 1;
        } else {
            parentIndex = index / 2;
        }

        int minIndex = parentIndex;
        if (A[index] < A[minIndex]) {
            minIndex = index;
        }
        int siblingIndex = -1;
        if (index % 2 == 0) { // index is right child
            siblingIndex = index - 1;
        } else {
            if (index + 1 < size) {
                siblingIndex = index + 1;
            }
        }

        if (siblingIndex != -1 && A[siblingIndex] < A[minIndex]) {
            minIndex = siblingIndex;
        }

        if (minIndex != parentIndex) { // swap parent
            int temp = A[parentIndex];
            A[parentIndex] = A[minIndex];
            A[minIndex] = temp;
            sift(A, size, parentIndex);
        }
    }

    public static void main(String[] args) throws IOException {
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        int result = cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

