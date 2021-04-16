package Tour;

import sample.User;

public class Booking {
    private int bookingID;
    private User user;
    private Tour tour;
    private int spotsPerBooking;

    @Override
    public String toString() {
        return String.valueOf(bookingID);
    }

    public Booking(User user, Tour tour, int spotsPerBooking) {
        this.user = user;
        this.tour = tour;
        this.spotsPerBooking=spotsPerBooking;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public int getSpotsPerBooking() {
        return spotsPerBooking;
    }

    public void setSpotsPerBooking(int spotsPerBooking) {
        this.spotsPerBooking = spotsPerBooking;
    }
}