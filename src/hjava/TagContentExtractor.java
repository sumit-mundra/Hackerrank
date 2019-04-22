package hjava;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.hackerrank.com/challenges/tag-content-extractor/problem
 */
public class TagContentExtractor {
    private static final String regex = "<(.+)>([^<]+)</\\1>";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases > 0) {
            String line = in.nextLine();
            extractTag(line);//Write your code here
            testCases--;
        }
    }

    private static void extractTag(String line) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        boolean match = false;
        while (matcher.find()){
            match = true;
            System.out.println(matcher.group(2));
        }
        if(!match){
            System.out.println("None");
        }
    }
}

