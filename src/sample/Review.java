package sample;

public class Review {
    private User user;
    private String subject;
    private int rating;
    private String text;
    public Review(User user, String subject, int rating, String text){
        this.user = user;
        this.subject = subject;
        this.rating = rating;
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
