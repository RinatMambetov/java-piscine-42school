package edu.school21.numbers;

public class NumberWorker {

    public boolean isPrime(int num) {

        if (num <= 1) {
            throw new IllegalNumberException("Error: Number is less than 1");
        }

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

    public int digitsSum(int num) {

        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return (sum);
    }
}

class IllegalNumberException extends RuntimeException {
    public IllegalNumberException(String message) {
        super(message);
    }
}
