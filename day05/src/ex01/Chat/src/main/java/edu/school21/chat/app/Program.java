package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws SQLException {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres01");
        ds.setUsername("postgres");
        ds.setPassword("postgres");

        MessagesRepository repository = new MessagesRepositoryJdbcImpl(ds);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a message ID\n -> ");
        System.out.println(repository.findById(scanner.nextLong()).get());
        scanner.close();
    }
}
