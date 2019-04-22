package implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/the-time-in-words/problem
 */
public class TimeInWords {

    public static final String[] hour = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight",
            "nine", "ten",
            "eleven", "twelve"};

    public static final String PAST = " past ";
    public static final String TO = " to ";

    public static final String[] minutes =
            new String[]{
                    "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
                    "twelve"
                    , "thirteen", "fourteen", "quarter", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
                    "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six",
                    "twenty seven", "twenty eight", "twenty nine", "half"
            };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(timeInWords(h, m));
    }

    static String timeInWords(int h, int m) {
        if (m == 0) {
            return hour[h - 1] + " o' clock";
        }
        boolean past = m <= 30;
        StringBuilder sb = new StringBuilder();
        if (!past) {
            m = 60 - m;
        }
        sb.append(minutes[m - 1]);
        if (m % 15 != 0) {
            if (m > 1) {
                sb.append(" minutes");
            } else {
                sb.append(" minute");
            }
        }

        StringBuilder hr = new StringBuilder();
        if (past) {
            hr.append(hour[h - 1]);
        } else {
            if (h == 12) {
                hr.append(hour[0]);
            }else{
                hr.append(hour[h]);
            }
        }

        if (past) {
            return sb.toString() + PAST + hr.toString();
        } else {
            return sb.toString() + TO + hr.toString();
        }

    }
}
