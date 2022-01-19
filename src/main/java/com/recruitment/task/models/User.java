package com.recruitment.task.models;

public class User {
    private String userName;
    private String userPassword;
    private String roles;

    public User() {
    }

    public User(String userName, String userPassword, String roles) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.roles = roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
