package ex03;

import java.util.Arrays;
import java.util.UUID;

public class Program {

    public static void main(String[] args) {

        User user1 = new User("name1", 100);
        User user2 = new User("name2", 200);
        User user3 = new User("name3", 300);

        TransactionsLinkedList transactionsLinkedList = new TransactionsLinkedList();
        Transaction transaction1 = new Transaction(user1, user2, Transaction.Type.INCOME, 50);
        Transaction transaction2 = new Transaction(user2, user3, Transaction.Type.INCOME, 100);
        Transaction transaction3 = new Transaction(user3, user1, Transaction.Type.INCOME, 150);
        user1.setTransaction(transaction1);
        user2.setTransaction(transaction1);
        user2.setTransaction(transaction2);
        user3.setTransaction(transaction2);
        user3.setTransaction(transaction3);
        user1.setTransaction(transaction3);
        transaction1.takeTransaction();
        transaction2.takeTransaction();
        transaction3.takeTransaction();
        transactionsLinkedList.addTransaction(transaction1);
        transactionsLinkedList.addTransaction(transaction2);
        transactionsLinkedList.addTransaction(transaction3);

        UUID uuid1 = transaction1.getId();
        UUID uuid2 = transaction2.getId();
        UUID uuid3 = transaction3.getId();
        System.out.println("uuid1 => " + uuid1);
        System.out.println("uuid2 => " + uuid2);
        System.out.println("uuid3 => " + uuid3);

        System.out.println(Arrays.toString(transactionsLinkedList.toArray()));
        System.out.println("size before delete " + transactionsLinkedList.size);
        transactionsLinkedList.deleteTransaction(uuid1);
        System.out.println(Arrays.toString(transactionsLinkedList.toArray()));
        System.out.println("size after delete " + transactionsLinkedList.size);

        System.out.println(Arrays.toString(user1.getTransactions().toArray()));
        System.out.println(Arrays.toString(user2.getTransactions().toArray()));
        System.out.println(Arrays.toString(user3.getTransactions().toArray()));
    }
}
