package challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;


public class VisuallyBalancedSection {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());
        List<List<Integer>> inputs = new ArrayList<>();
        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> colors = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(toList());

                inputs.add(colors);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        inputs.forEach(colors -> {
            long result = Resultttt.visuallyBalancedSections(colors);
//            try {
//                bufferedWriter.write(String.valueOf(result));
//                bufferedWriter.newLine();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println(result);
        });
        bufferedReader.close();
//        bufferedWriter.close();
    }


}

class Resultttt {

    /*
     * Complete the 'visuallyBalancedSections' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY colors as parameter.
     */

    public static long visuallyBalancedSections(List<Integer> colors) {
        int size = colors.size();
        long count = size;
        int index = 0;
        int[][] colorCount = new int[size][50];
        for (Integer color : colors) {
            if (index == 0) {
                colorCount[index][color - 1] = 1;
            } else {
                colorCount[index] = Arrays.copyOf(colorCount[index - 1], 50);
                colorCount[index][color - 1]++;
            }
            index++;
        }

        for (int length = 2; length <= size; length++) {
            int maxStart = size - length;
            for (int start = 0; start <= maxStart; start++) {
                int[] colorFreq = getColorFreq(start, length, colorCount);
//                printColorFreq(colorFreq);
                boolean visuallyBalanced = isVisuallyBalanced(colorFreq, length);
                if (visuallyBalanced) {
                    count++;
                }
//                System.out.println(start + "::" + length + "::" + visuallyBalanced);
            }
        }
        return count;
    }

    private static void printColorFreq(int[] colorFreq) {
        for (int i : colorFreq) {
            System.out.printf(i + "\t");
        }
        System.out.println();
    }

    private static boolean isVisuallyBalanced(int[] colorFreq, int length) {
        if (length == 1) {
            return true;
        }

        boolean result = true;
        if (length % 2 == 0) {
            for (int value : colorFreq) {
                // all must be even valued
                if (value % 2 != 0) {
                    return false;
                }
            }
        } else {
            int oddCount = 0;
            for (int value : colorFreq) {
                // exactly one odd and restEvenNumbered
                if (value % 2 != 0) {
                    oddCount++;
                    if (oddCount > 1) {
                        return false;
                    }
                }
            }
            if (oddCount == 0) {
                return false;
            }
        }
        return result;
    }

    private static int[] getColorFreq(int start, int length, int[][] colorCount) {
        int[] colorFreq = new int[50];
        for (int i = 0; i < 50; i++) {
            if (start == 0) {
                colorFreq[i] = colorCount[start + length - 1][i];
            } else {
                colorFreq[i] = colorCount[start + length - 1][i] - colorCount[start - 1][i];
            }
        }

        return colorFreq;
    }


}
