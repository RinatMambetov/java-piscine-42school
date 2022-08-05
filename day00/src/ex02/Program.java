package ex02;

import java.util.Scanner;

public class Program {

    private static boolean isPrimeNumber(int num) {

        int i = 3;

        if (num == 2) {
            return (true);
        } else if (num % 2 == 0) {
            return (false);
        }
        while (i < num / 2) {
            if (num % i == 0)
                return (false);
            i++;
        }
        return (true);
    }

    private static int getSum(int num) {

        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return (sum);
    }

    public static void main(String[] args) {

        int num;
        int sum;
        int counter = 0;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a sequence:");
        while ((num = scan.nextInt()) != 42) {
            sum = getSum(num);
            if (isPrimeNumber(sum))
                counter++;
        }
        scan.close();
        System.out.println("Count of coffee-request - " + counter);
    }
}
