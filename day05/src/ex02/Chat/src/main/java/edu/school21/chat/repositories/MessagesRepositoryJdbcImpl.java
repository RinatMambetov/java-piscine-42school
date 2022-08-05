package edu.school21.chat.repositories;

import edu.school21.chat.exceptions.NotSavedSubEntityException;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{
    private DataSource ds;

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

        return optionalMessage;
    }

    @Override
    public void save(Message message) throws NotSavedSubEntityException {
        String query = "INSERT INTO chat.message (author, chatroom, text, date) VALUES (?, ?, ?, ?);";

        try (Connection conn = ds.getConnection();
            PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);){
            statement.setLong(1, message.getAuthor().getId());
            statement.setLong(2, message.getRoom().getId());
            statement.setString(3, message.getText());
            statement.setTimestamp(4, Timestamp.valueOf(message.getDate()));

            statement.execute();

            ResultSet id = statement.getGeneratedKeys();
            id.next();

            message.setId(id.getLong(1));
        } catch (SQLException e) {
            throw new NotSavedSubEntityException("Can't save message");
        }

    }
}
