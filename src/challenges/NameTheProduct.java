package challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Resultq {

    /*
     * Complete the 'productName' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY names as parameter.
     */

    public static String productName(List<String> names) {
        int[][] freq = new int[5][26];
        for (String name : names) {
            int i = 0;
            for (char character : name.toCharArray()) {
                freq[i++][character - 'a']++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 5; j++) {
            sb.append(getMinFreqChar(freq, j) + "");
        }
        return sb.toString();

    }

    private static char getMinFreqChar(int[][] freq, int i) {
        int result = 25;
        int min = freq[i][25];
        for (int j = 0; j < 26; j++) {
            int curr = freq[i][25 - j];
            if (curr < min) {
                min = curr;
                result = 25 - j;
            }
        }
        return (char) (result + 'a');
    }

}

public class NameTheProduct {
    /*
     * Complete the 'productName' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY names as parameter.
     */


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> names = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        String result = Resultq.productName(names);
        System.out.println(result);

        bufferedReader.close();
    }
}
