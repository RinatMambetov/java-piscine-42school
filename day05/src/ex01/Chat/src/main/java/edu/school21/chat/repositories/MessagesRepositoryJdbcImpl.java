package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{
    private final DataSource ds;

    public MessagesRepositoryJdbcImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {
        Optional<Message> optionalMessage;

        Connection conn = ds.getConnection();

        Statement statementMess = conn.createStatement();
        String queryMess = "SELECT * FROM chat.message WHERE id=" + id;
        ResultSet resultMess = statementMess.executeQuery(queryMess);
        resultMess.next();

        Statement statementUser = conn.createStatement();
        String queryUser = "SELECT * FROM chat.user WHERE id=" + resultMess.getString("author");
        ResultSet resultUser = statementUser.executeQuery(queryUser);
        resultUser.next();

        Statement statementRoom = conn.createStatement();
        String queryRoom = "SELECT * FROM chat.chatroom WHERE id=" + resultMess.getString("chatroom");
        ResultSet resultRoom = statementRoom.executeQuery(queryRoom);
        resultRoom.next();

        User user = new User(resultUser.getLong("id"), resultUser.getString("login"),
                resultUser.getString("password"), null, null);
        Chatroom room = new Chatroom(resultRoom.getLong("id"), resultRoom.getString("name"),
                null, null);
        optionalMessage = Optional.of(new Message(resultMess.getLong("id"), user, room, resultMess.getString("text"),
                resultMess.getTimestamp("date").toLocalDateTime()));

        conn.close();

        return optionalMessage;
    }
}
