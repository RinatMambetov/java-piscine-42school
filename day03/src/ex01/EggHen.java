package ex01;

public class EggHen {

    public static void main(String[] args) throws InterruptedException {

        if (args.length != 1 || !args[0].startsWith("--count=")) {
            System.err.println("Error: Wrong argument");
            System.exit(-1);
        }
        int amount = Integer.parseInt(args[0].substring("--count=".length()));

        WaitNotify wn = new WaitNotify(amount);

        Thread threadEgg = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread threadHen = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    wn.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        threadEgg.start();
        threadHen.start();
        threadEgg.join();
        threadHen.join();
    }
}
