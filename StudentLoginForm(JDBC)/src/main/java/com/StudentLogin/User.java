package com.StudentLogin;

public class User {
    private String userName;
    private String password;

    // Getter method for userName
    public String getUserName() {
        return userName;
    }

    // Setter method for userName
    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Getter method for password
    public String getPassword() {
        return password;
    }

    // Setter method for password
    public void setPassword(String password) {
        this.password = password;
    }
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

	

}
