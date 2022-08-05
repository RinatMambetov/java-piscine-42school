package ex00;

class User {

    private int id;
    private String name;
    private int balance;

    public User(int id, String name, int balance) {
        setId(id);
        setName(name);
        setBalance(balance);
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
