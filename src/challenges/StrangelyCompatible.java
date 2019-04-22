package challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'strangelyCompatible' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY students as parameter.
     */

    public static long strangelyCompatible(List<String> students) {
        long result = 0;
        int[][] lookup = new int[students.size()][26];
        for (int i = 0; i < students.size(); i++) {
            for (int j = i + 1; j < students.size(); j++) {
                if (isStrangelyCompatible(students, i, j)) {
                    result++;
                    System.out.println(students.get(i) + "::" + students.get(j));
                }
            }
        }
        return result;

    }

    static boolean isStrangelyCompatible(List<String> students, int l, int j) {
        String p1 = students.get(l);
        String p2 = students.get(j);
        int mismatch = 0;
        int i = 0;
        int length = p1.length();
        while (i < length) {
            if (p1.charAt(i) != p2.charAt(i)) {
                mismatch++;
                if (mismatch > 1) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }

}

public class StrangelyCompatible {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> students = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        long result = Result.strangelyCompatible(students);
        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
