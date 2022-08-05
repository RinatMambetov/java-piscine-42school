package ex01;

public class UserIdsGenerator {

    private static UserIdsGenerator instance = null;

    private static int id = 0;

    private UserIdsGenerator() {
    }

    public static UserIdsGenerator getInstance() {
        if (instance == null)
            return instance = new UserIdsGenerator();
        return instance;
    }

    public int generateId() {
        id++;
        return id;
    }
}
