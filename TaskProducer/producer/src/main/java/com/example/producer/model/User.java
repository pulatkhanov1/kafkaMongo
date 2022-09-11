package com.example.producer.model;

import java.time.LocalDateTime;

public class User {
private String name;
private String surname;
private String email;

private LocalDateTime date;

	public User(String name, String surname, String email, LocalDateTime localDateTime) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.date = localDateTime;
	}

	public User() {
	}

	public User(String name, String surname, String email) {
		this.name = name;
		this.surname = surname;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", email='" + email + '\'' +
				", date=" + date +
				'}';
	}
}
