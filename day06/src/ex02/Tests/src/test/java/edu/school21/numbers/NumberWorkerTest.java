package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {
    NumberWorker numberWorker = new NumberWorker();

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 53, 199, 1613, 4507, 7369})
    void isPrimeForPrimes(int number) {
        Assertions.assertTrue(numberWorker.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9, 81, 135, 1101, 3321, 4179})
    void isPrimeForNotPrimes(int number) {
        Assertions.assertFalse(numberWorker.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 0, -1, -10, -15, -83, -5290})
    void isPrimeForIncorrectNumbers(int number) {
        Assertions.assertThrowsExactly(IllegalNumberException.class, () -> numberWorker.isPrime(number));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", delimiter = ',')
    void isSumCorrect(int number, int sum) {
        Assertions.assertEquals(numberWorker.digitsSum(number), sum);
    }
}
