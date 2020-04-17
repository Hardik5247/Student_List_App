package com.example.studentlistapp.ui.main;

public class Users {
    private String userName;
    private String userNumber;
    private String userBhavan;
    private String userBranch;

    public Users(String userName,String userNumber,String userBhavan,String userBranch) {
        this.userName = userName;
        this.userNumber = userNumber;
        this.userBhavan = userBhavan;
        this.userBranch = userBranch;
    }

    public Users() {
    }

    public String getUserBranch() {
        return userBranch;
    }

    public void setUserBranch(String userBranch) {
        this.userBranch = userBranch;
    }

    public String getUserBhavan() {
        return userBhavan;
    }

    public void setUserBhavan(String userBhavan) {
        this.userBhavan = userBhavan;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
