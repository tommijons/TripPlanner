package tripPackage;

public class User {
    private int user_id;
    private String userName;
    private String email;
    private String password;

    public User(String un, String e, String p) {
        userName = un;
        email = e;
        password = p;
    }
    public User(){
        userName = "Resu";
        email = "email";
        password = "password123";
    }
    public User(int Userid, String userName, String email){
        this.user_id = Userid;
        this.userName = userName;
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(long userID) {
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
