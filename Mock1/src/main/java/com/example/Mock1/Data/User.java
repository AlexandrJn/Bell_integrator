package com.example.Mock1.Data;

public class User {
    private String login;
    private String password;
    private String age;
    private String name;
    private String date;
    public User() {}

    public User(String login, String password, String age, String name) {
        this.login = login;
        this.password = password;
        this.age = age;
        this.name = name;

    }
    public User(String login, String date) {
        this.login = login;
        this.date = date;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {return password;}
    public String getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public String getDate() {return date;}
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDate(String date) {this.date = date;}

}
