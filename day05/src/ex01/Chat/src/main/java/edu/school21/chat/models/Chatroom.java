package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {
    private Long id;
    private String name;
    private User owner;
    private List<Message> messages;

    public Chatroom(Long id, String name, User owner, List<Message> messages) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chatroom chatroom = (Chatroom) o;
        return id.equals(chatroom.id) && name.equals(chatroom.name) && owner.equals(chatroom.owner) && Objects.equals(messages, chatroom.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, owner, messages);
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", messages=" + messages +
                '}';
    }
}
