package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
	private long id;
	private String login;
	private String password;
	private List<Chatroom> createdRooms;
	private List<Chatroom> rooms;

	public User(long id, String login, String password, List<Chatroom> createdRooms, List<Chatroom> rooms) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.createdRooms = createdRooms;
		this.rooms = rooms;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return id == user.id && login.equals(user.login) && password.equals(user.password) && createdRooms.equals(user.createdRooms) && rooms.equals(user.rooms);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, login, password, createdRooms, rooms);
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", login='" + login + '\'' +
				", password='" + password + '\'' +
				", createdRooms=" + createdRooms +
				", rooms=" + rooms +
				'}';
	}
}
