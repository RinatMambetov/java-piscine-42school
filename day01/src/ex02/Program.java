package ex02;

public class Program {

    public static void main(String[] args) {

        UsersArrayList ua = new UsersArrayList();
        ua.addUser(new User("name1", 100));
        ua.addUser(new User("name2", 200));
        ua.addUser(new User("name3", 300));
        ua.addUser(new User("name4", 400));
        System.out.println(ua.getUserById(2));
        System.out.println(ua.getUserByIndex(2));
        System.out.println(ua.getUsersAmount());
    }
}
