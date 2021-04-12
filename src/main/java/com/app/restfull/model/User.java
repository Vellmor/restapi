package com.app.restfull.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login",columnDefinition = "varchar(20)")
    private String login;

    @Column(name = "password",columnDefinition = "varchar(10)")
    private String password;

    private boolean active;

    protected User() {}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.active = true;
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
        int length = password.length();
        if (length > 10){
            this.password = password.substring(length-10, length);
        } else {
            this.password = password;
        }

    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
