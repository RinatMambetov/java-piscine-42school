package ex03;

public class TransactionNotFoundException extends RuntimeException {

    @Override
    public String toString() {
        return "Error: Transaction not found";
    }
}
