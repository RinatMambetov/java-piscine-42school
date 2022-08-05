package ex00;

public class PrintThread extends Thread {

    private final int amount;
    private final String word;

    public PrintThread(int amount, String word) {
        this.amount = amount;
        this.word = word;
    }

    @Override
    public void run() {
        for (int i = 0; i < amount; i++) {
            System.out.println(word);
        }
    }
}
