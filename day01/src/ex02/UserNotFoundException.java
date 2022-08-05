package ex02;

public class UserNotFoundException extends RuntimeException {

    @Override
    public String toString() {
        return "Error: User not found";
    }
}
