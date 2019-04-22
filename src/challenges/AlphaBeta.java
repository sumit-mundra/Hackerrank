package challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Resultt {

    /*
     * Complete the 'alphaBeta' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY pile as parameter.
     */

    public static int alphaBeta(List<Integer> pile) {
        int max = pile.get(0);
        int secondMax = 0;
        for (Integer coins : pile) {
            if (secondMax == 0 && coins != max) {

            }
            if (max < coins) {
                secondMax = max;
                max = coins;
            }
        }
        return secondMax;
    }

}

public class AlphaBeta {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> pile = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Resultt.alphaBeta(pile);

        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
