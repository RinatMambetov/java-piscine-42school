package ex00;

import java.util.UUID;

class Transaction {

    private UUID id;
    private User recipient;
    private User sender;
    private int sum;
    private Type type;
    enum Type {
        INCOME,
        OUTCOME
    }

    public Transaction(User sender, User recipient, Type type, int sum) {
        setId();
        setSender(sender);
        setRecipient(recipient);
        setType(type);
        setSum(sum);
    }

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        if (getType() == Type.INCOME && sum < 0) {
            System.err.println("Error: Type is income and sum is negative");
            System.exit(-1);
        }
        if (getType() == Type.OUTCOME && sum > 0) {
            System.err.println("Error: Type is outcome and sum is positive");
            System.exit(-1);
        }
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + getId() +
                ", sender=" + getSender() +
                ", recipient=" + getRecipient() +
                ", type=" + getType() +
                ", sum=" + getSum() +
                '}';
    }

    public void takeTransaction() {
        if (getType() == Type.INCOME) {
            sender.setBalance(sender.getBalance() - sum);
            recipient.setBalance(recipient.getBalance() + sum);
        }
        if (getType() == Type.OUTCOME) {
            sender.setBalance(sender.getBalance() + sum);
            recipient.setBalance(recipient.getBalance() - sum);
        }
    }
}
