package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class Program {
    public static void main(String[] args) throws SQLException {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres03");
        ds.setUsername("postgres");
        ds.setPassword("postgres");

        MessagesRepository repository = new MessagesRepositoryJdbcImpl(ds);

        Optional<Message> messageOptional;
        messageOptional = repository.findById(1L);
        System.out.println(messageOptional.get());

        if (messageOptional.isPresent()) {
            Message message = messageOptional.get();
            User user = new User(1L, "testName", "testPass", new ArrayList<>(), new ArrayList<>());
            message.setText("testText");
            message.setAuthor(user);
            message.setDate(LocalDateTime.now());
            repository.update(message);
        }

        System.out.println(messageOptional.get());
    }
}
