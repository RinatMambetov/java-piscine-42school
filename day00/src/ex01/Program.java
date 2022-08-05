package ex01;

import java.util.Scanner;

public class Program {

    private static int steps = 0;

    private static boolean isPrimeNumber(int num) {

        int i = 3;

        if (num == 2) {
            steps++;
            return (true);
        } else if (num % 2 == 0) {
            steps++;
            return (false);
        }

        while (i < num / 2) {
            steps++;
            if (num % i == 0)
                return (false);
            i++;
        }
        steps++;
        return (true);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number:");
        int num = scan.nextInt();

        if (num < 2) {
            System.err.println("IllegalArgument");
            scan.close();
            System.exit(-1);
        }
        if (isPrimeNumber(num))
            System.out.println("true " + steps);
        else
            System.out.println("false " + steps);
        scan.close();
    }
}
