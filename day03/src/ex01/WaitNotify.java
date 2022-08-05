package ex01;

public class WaitNotify {

    private int amount;

    public WaitNotify(int amount) {
        this.amount = amount * 2;
    }

    public void produce() throws InterruptedException {
        synchronized (this) {
            while (this.amount-- > 0) {
                System.out.println("Egg");
                wait();
                notify();
            }
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(100);
        synchronized (this) {
            while (this.amount-- > 0) {
                System.out.println("Hen");
                notify();
                wait();
            }
        }
    }
}
