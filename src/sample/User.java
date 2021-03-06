package sample;

public class User {
    private String userName;
    private String email;
    private long userID;

    public User(String userName, String email, long userID) {
        this.userName = userName;
        this.email = email;
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

}
