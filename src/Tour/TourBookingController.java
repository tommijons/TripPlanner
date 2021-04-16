package Tour;

import javafx.collections.ObservableList;
import java.util.ArrayList;

public class TourBookingController{
    private TourDataFactory tourdataFactory = new TourDataFactory();

    public ObservableList<Booking> getAllBooking(){
        ObservableList<Booking> booking=tourdataFactory.getBookings();
        return booking;
    }
    public Booking getThisBooking(int bookingID){
        ObservableList<Booking> booking =getAllBooking();
        Booking thisBooking = null;
        for (Booking allBooking: booking){
            System.out.println(allBooking.getSpotsPerBooking());
            System.out.println("booking Id " + allBooking.getBookingID());
            if (allBooking.getBookingID()==bookingID){
                thisBooking = new Booking(allBooking.getUser(),allBooking.getTour(),allBooking.getSpotsPerBooking());
            }
        }
        return thisBooking;
    }

    public void addBooking(Booking booking) {
        tourdataFactory.insertBooking(booking.getUser().getPassword(), //5T-Ath. breytt úr userID í password
                booking.getTour().getTourID(),
                booking.getSpotsPerBooking());
    }

    public void deleteBooking(int bookingID){
        tourdataFactory.deleteBooking(bookingID);
    }

    public ArrayList<Booking> getBooking(int tourID){
        ArrayList<Booking> bookings = new ArrayList<>();
        ObservableList<Booking> allBookings =getAllBooking();
        for (Booking booking :allBookings){
            if(booking.getTour().getTourID()==tourID){
                bookings.add(booking);
            }
        }
        return bookings;
    }

    public int totalBookings(int tourID) {
        ObservableList<Booking> allBookings =getAllBooking();
        int total=0;
        for (Booking booking :allBookings){
            if(booking.getTour().getTourID()==tourID){
                total++;
            }
        }
        return total;
    }
}
