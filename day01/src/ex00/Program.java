package ex00;

class Program {

    public static void main(String[] args) {

        User user1 = new User(1, "name1", 600);
        User user2 = new User(2, "name2", 500);

        System.out.println(user1);
        System.out.println(user2);

        Transaction tran1 = new Transaction(user1, user2, Transaction.Type.INCOME, 100);
        System.out.println(tran1);
        tran1.takeTransaction();

        System.out.println(user1);
        System.out.println(user2);

        Transaction tran2 = new Transaction(user1, user2, Transaction.Type.OUTCOME, -200);
        System.out.println(tran2);
        tran2.takeTransaction();

        System.out.println(user1);
        System.out.println(user2);
    }
}
