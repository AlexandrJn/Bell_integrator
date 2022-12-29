package com.example.Mock1.Data;

public class ActualUser {
    private String login;
    private String date;

    public ActualUser(String login, String date) {
    this.login = login;
    this.date = date;
    }
    public String getLogin() {
        return login;
    }
    public String getDate() {
        return date;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setDate(String date) {
        this.date = date;
    }

}
