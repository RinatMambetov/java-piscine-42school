package ex03;

import java.util.Scanner;

public class Program {

    private static long result = 1000_000_000_000_000_000L;
    private static int prevWeek = 0;

    private static void printError(Scanner scan) {

        System.err.println("IllegalArgument");
        scan.close();
        System.exit(-1);
    }

    private static void scanWeek(Scanner scan) {

        if (scan.next().equals("42")) {
            scan.close();
            printResult();
            System.exit(0);
        }
        if (scan.nextInt() != prevWeek + 1)
            printError(scan);
        prevWeek++;
    }

    private static int getMinScore(Scanner scan) {

        int i = 0;
        int num;
        int min = 9;

        while (i < 5) {
            num = scan.nextInt();
            if (num < 1 || num > 9)
                printError(scan);
            if (num < min)
                min = num;
            i++;
        }
        return min;
    }

    private static void printResult() {

        int i = 1;
        int j;

        while (result > 1) {
            if (result % 10 == 0)
                break;
            j = 0;
            System.out.print("Week " + i + " ");
            while (j < result % 10) {
                System.out.print("=");
                j++;
            }
            System.out.println(">");
            result /= 10;
            i++;
        }
    }

    public static void main(String[] args) {

        int i = 0;
        int min;
        int j;
        int multiplier;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter weeks and scores:");
        while (i < 19) {
            if (i == 18)
                printError(scan);
            scanWeek(scan);
            min = getMinScore(scan);
            j = 0;
            multiplier = 1;
            while (j++ < i)
                multiplier *= 10;
            if (i == 0)
                result += min;
            else
                result += (long) multiplier * min;
            i++;
        }
    }
}
