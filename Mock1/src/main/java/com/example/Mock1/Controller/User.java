package com.example.Mock1.Controller;

public class User {
    private String login;
    private String password;
    private String age;
    private String name;

    public User(String login, String password, String age, String name) {
        this.login = login;
        this.password = password;
        this.age = age;
        this.name = name;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public String getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setDate(String password) {
        this.password = password;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
}
