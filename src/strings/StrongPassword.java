package strings;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class StrongPassword {

    private static final Scanner scanner = new Scanner(System.in);

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        int deficitLength = 6 - password.length();
        int deficit = 0;
        if (!password.matches(".*[0-9].*")) {
            deficit++;
        }
        if (!password.matches(".*[a-z].*")) {
            deficit++;
        }
        if (!password.matches(".*[A-Z].*")) {
            deficit++;
        }
        if (!password.matches(".*[!@#$%^&*()\\-+].*")) {
            deficit++;
        }
        System.out.println("deficit = " + deficit);
        return deficitLength > deficit ? deficitLength : deficit;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
