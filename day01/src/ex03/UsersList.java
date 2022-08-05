package ex03;

public interface UsersList {

    void addUser(User user);
    User getUserById(int id) throws UserNotFoundException;
    User getUserByIndex(int index) throws UserNotFoundException;
    int getUsersAmount();
}
