package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {
    NumberWorker numberWorker = new NumberWorker();

    @ParameterizedTest
    @ValueSource(ints = {2, 107, 151, 193, 239})
    void isPrimeForPrimes(int number) {
        Assertions.assertTrue(numberWorker.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {22, 159, 165, 208, 309})
    void isPrimeForNotPrimes(int number) {
        Assertions.assertFalse(numberWorker.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 0, -1, -55, -250})
    void isPrimeForIncorrectNumbers(int number) {
        Assertions.assertThrowsExactly(IllegalNumberException.class, () -> numberWorker.isPrime(number));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", delimiter = ',')
    void isSumCorrect(int number, int sum) {
        Assertions.assertEquals(numberWorker.digitsSum(number), sum);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data_fails.csv", delimiter = ',')
    void isSumIncorrect(int number, int sum) {
        Assertions.assertNotEquals(numberWorker.digitsSum(number), sum);
    }
}
