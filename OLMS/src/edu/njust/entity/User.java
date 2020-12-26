package edu.njust.entity;

/**
 * @author TYX
 * @name User
 * @description
 * @time
 **/
public class User {
    private String userId;
    private String password;
    private String userName;
    private int userType;

    public User() {
    }

    public User(String userId, String password, String userName, int userType) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
        this.userType = userType;
    }

    public String show(){
        return "User: This is a user of id:"+this.userId+", password:"+this.password+", user name:"+this.userName+", user type:"+this.userType;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
}
