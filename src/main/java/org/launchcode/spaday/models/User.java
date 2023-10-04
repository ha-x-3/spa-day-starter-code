package org.launchcode.spaday.models;

import org.springframework.cglib.core.Local;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class User {

    private int id;
    private static int nextId = 1;
    private String username;
    private String email;
    private String password;
    private String timeJoined;

    public User(String username, String email) {
        this.id = nextId;
        this.username = username;
        this.email = email;
        this.timeJoined = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getTimeJoined() {
        return timeJoined;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return id + " : " + username + " : " + email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
