package sorting;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;


/**
 * https://www.hackerrank.com/challenges/big-sorting/problem
 */
public class BigSorting {

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {
        TreeMap<Integer, List<String>> map = new TreeMap<>();
        for (String item : unsorted) {
            map.computeIfAbsent(item.length(), k -> new ArrayList<>());
            map.get(item.length()).add(item);
        }

        String[] result = new String[unsorted.length];
        int k = 0;
        for (int key : map.keySet()) {
            k = radixSort(map.get(key), result, k);
        }
        return result;
    }

    private static int radixSort(List<String> list, String[] result, int cursor) {
        if (list.size() == 0) {
            return cursor;
        }
        if (list.size() == 1) {
            result[cursor++] = list.get(0);
            return cursor;
        }
        //implement radix sort --> use counting sort for each value.
        String[] operand = list.toArray(new String[0]);

        int digits = list.get(0).length();
        for (int i = digits - 1; i >= 0; i--) {
            String[] out = new String[operand.length];
            int[] count = new int[10];

            for (String value : operand) {
                int index = value.charAt(i) - '0';
                count[index]++;
            }

            for (int j = 1; j < count.length; j++) {
                count[j] = count[j] + count[j - 1];
            }

            for (int m = operand.length - 1; m >= 0; m--) {
                int index = operand[m].charAt(i) - '0';
                out[count[index] - 1] = operand[m];
                count[index]--;
            }

            operand = out;
        }

        for (String item : operand) {
            result[cursor++] = item;
        }
        return cursor;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] unsorted = bufferedReader.lines().skip(1).toArray(String[]::new);

        System.out.println("read");
        long x = System.currentTimeMillis();

        String[] result = bigSorting(unsorted);
        long duration = System.currentTimeMillis() - x;

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);
            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedReader.close();

        bufferedWriter.newLine();
        bufferedWriter.write(Long.toString(duration));
        bufferedWriter.close();
    }
}

