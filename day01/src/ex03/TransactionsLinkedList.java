package ex03;

import java.util.UUID;

public class    TransactionsLinkedList implements TransactionsList {

    private final Node head = new Node(null, null, null);
    private final Node tail = new Node(null, null, null);
    int size = 0;

    public TransactionsLinkedList() {
        head.setNext(tail);
        tail.setPrev(head);
    }

    @Override
    public void addTransaction(Transaction transaction) {
        Node nextNode = head.getNext();
        Node newNode = new Node(nextNode, head, transaction);
        head.setNext(newNode);
        nextNode.setPrev(newNode);
        this.size++;
    }

    @Override
    public void deleteTransaction(UUID uuid) {
        Node temp = head.getNext();
        while (temp != this.tail) {
            if (temp.getData().getId().equals(uuid)) {
                temp.getPrev().setNext(temp.getNext());
                temp.getNext().setPrev(temp.getPrev());
                temp.setNext(null);
                temp.setPrev(null);
                temp.setData(null);
                this.size--;
                return ;
            }
            temp = temp.getNext();
        }
        throw new TransactionNotFoundException();
    }

    @Override
    public Transaction[] toArray() {

        Transaction[] array = new Transaction[size];
        Node temp = this.head.getNext();

        if (temp.getData() == null)
            throw new TransactionListEmptyException();
        for (int i = 0; i < this.size; i++) {
            array[i] = temp.getData();
            temp = temp.getNext();
        }
        return array;
    }
}

class Node {

    private Transaction data;
    private Node next;
    private Node prev;

    public Node(Node next, Node prev, Transaction data) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Transaction getData() {
        return data;
    }

    public void setData(Transaction data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}