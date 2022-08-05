package ex03;

class User {

    private int id;
    private String name;
    private int balance;
    private final TransactionsList transactions = new TransactionsLinkedList();

    public User(String name, int balance) {
        setId(UserIdsGenerator.getInstance().generateId());
        setName(name);
        setBalance(balance);
    }

    public TransactionsList getTransactions() {
        return transactions;
    }

    public void setTransaction(Transaction transaction) {
        transactions.addTransaction(transaction);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if (balance < 0) {
            System.err.println("Error: Start balance is negative");
            System.exit(-1);
        }
        else
            this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", balance=" + getBalance() +
                '}';
    }
}
