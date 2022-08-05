package ex00;

public class Human {

    public static void main(String[] args) throws InterruptedException {

        if (args.length != 1 || !args[0].startsWith("--count=")) {
            System.err.println("Error: Wrong number of arguments");
            System.exit(-1);
        }
        int amount = Integer.parseInt(args[0].substring("--count=".length()));

        PrintThread egg = new PrintThread(amount, "egg");
        PrintThread hen = new PrintThread(amount, "hen");

        egg.start();
        hen.start();

        egg.join();
        hen.join();

        for (int i = 0; i < amount; i++)
            System.out.println("HUMAN");
    }
}
