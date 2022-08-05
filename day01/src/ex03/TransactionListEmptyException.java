package ex03;

public class TransactionListEmptyException extends RuntimeException {

    @Override
    public String toString() {
        return "Error: Transaction list is empty";
    }
}
