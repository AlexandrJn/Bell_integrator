package com.example.Mock1.Data;

public class User {
    private String login;
    private String password;
    private String email;
    private String date;
    public User() {}

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;

    }
    public User(String login, String date) {
        this.login = login;
        this.date = date;
    }

    public String getLogin() {
        return login;
    }
    public String getPassword() {return password;}
    public String getEmail() {
        return email;
    }
    public String getDate() {return date;}
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDate(String date) {this.date = date;}

}
