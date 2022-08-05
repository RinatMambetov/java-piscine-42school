package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
    private Long id;
    private String login;
    private String password;
    private List<Chatroom> createdRooms;
    private List<Chatroom> chatRooms;

    public User(Long id, String login, String password, List<Chatroom> createdRooms, List<Chatroom> chatRooms) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.chatRooms = chatRooms;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && login.equals(user.login) && password.equals(user.password)
                && Objects.equals(createdRooms, user.createdRooms)
                && Objects.equals(chatRooms, user.chatRooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, createdRooms, chatRooms);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdRooms=" + createdRooms +
                ", chatRooms=" + chatRooms +
                '}';
    }
}
