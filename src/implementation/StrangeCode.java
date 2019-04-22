package implementation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import static java.lang.Math.log;

public class StrangeCode {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the strangeCounter function below.
    static long strangeCounter(long t) {
        long n = (long) Math.ceil((log((t + 3d) / 3) / log(2)));
        long l = (long) Math.pow(2, n) - 1;
        return 1 + 3 * l - t;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        long t = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = strangeCounter(t);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
