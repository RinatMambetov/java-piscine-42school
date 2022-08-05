package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) throws SQLException {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres02");
        ds.setUsername("postgres");
        ds.setPassword("postgres");

        MessagesRepository repository = new MessagesRepositoryJdbcImpl(ds);

        User user = new User(1L, "testUser", "testPass", new ArrayList<>(), new ArrayList<>());
        Chatroom room = new Chatroom(1L, "testRoom", user, new ArrayList<>());
        Message message = new Message(null, user, room, "testText", LocalDateTime.now());

        repository.save(message);
        System.out.print("Success!\nNew message id = ");
        System.out.println(message.getId());

        System.out.println(repository.findById(message.getId()).get());
    }
}
