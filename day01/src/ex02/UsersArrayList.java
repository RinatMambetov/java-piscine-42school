package ex02;

public class UsersArrayList implements UsersList {

    private int capacity = 10;
    private int size = 0;

    private User[] users = new User[capacity];

    @Override
    public void addUser(User user) throws NullPointerException {
        if (size == capacity - 1)
            users = increaseUsers(users);
        if (user != null) {
            users[size] = user;
            size++;
        } else
            throw new NullPointerException();
    }

    private User[] increaseUsers(User[] users) {
        capacity *= 1.5;
        User[] newUsers = new User[capacity];
        for (int i = 0; i < size; i++) {
            newUsers[i] = users[i];
        }
        return newUsers;
    }

    @Override
    public User getUserById(int id) throws UserNotFoundException {

        for (int i = 0; i < size; i++) {
            if (users[i].getId() == id)
                return users[i];
        }
        throw new UserNotFoundException();
    }

    @Override
    public User getUserByIndex(int index) throws UserNotFoundException, ArrayIndexOutOfBoundsException {
        if (index < 0)
            throw new ArrayIndexOutOfBoundsException();
        if (users[index] == null)
            throw new UserNotFoundException();
        return users[index];
    }

    @Override
    public int getUsersAmount() {
        return size;
    }
}
