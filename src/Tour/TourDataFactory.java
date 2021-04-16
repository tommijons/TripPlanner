package Tour;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tripPackage.User;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

public class TourDataFactory {

    public LocalDate millisToLocalDate(long millis){
        LocalDate date = Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDate();
        return date;
    }

    private final static String url = "jdbc:sqlite:./src/database/Team5D.DB";
    //private final static String url = "jdbc:sqlite:/Tolvunarfraedi/vor2021/HBV401G-Throun_hugbunadar/Team5D-new/Team5D/database/Team5D.DB";
    //private final static String url = "jdbc:sqlite:/Users/thorhallureythorsson/Desktop/Skólinn/Vor 21/HBV401G - Þróun Hugbúnaðar/Team5D/database/Team5D.DB";

    private Connection connect() {
        // SQLite connection string
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("connection to database has been estableshed");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insertTour(String name,String info,int Spots,
                           int price,String region,int duration,
                           String services, long date) {
        String sql = "INSERT INTO Tour VALUES(null,?,?,?,?,?,?,?,?,?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, info);
            pstmt.setInt(3, Spots);
            pstmt.setInt(4, 0);
            pstmt.setInt(5, price);
            boolean fullyB= false;
            if (Spots<=0) { fullyB=true;}
            pstmt.setBoolean(6,fullyB);
            pstmt.setString(7, region);
            pstmt.setInt(8, duration);
            pstmt.setString(9, services);
            pstmt.setLong(10,date);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteTour(int ID) {
        String sql = "DELETE FROM Tour WHERE tourID = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,ID);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateSpotsForTour(int tourID , int availableSpots){
        String sql = "UPDATE Tour SET availableSpots = ? , fullyBooked =?"
                + "WHERE tourID = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1,availableSpots );
            boolean isFull = false;
            if (availableSpots<=0){
                isFull = true;
            }
            pstmt.setBoolean(2, isFull);
            pstmt.setInt(3, tourID);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ObservableList<Tour> getTours(){
        ObservableList<Tour> allTours = FXCollections.observableArrayList();
        String sql = "SELECT tourID, tourName, tourInfo, availableSpots, bookedSpots, tourPrice, fullyBooked, tourRegion, duration, services, date FROM Tour";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                int tourID = rs.getInt("tourID");
                String tourName = rs.getString("tourName");
                String tourInfo = rs.getString("tourInfo");
                int availableSpots = rs.getInt("availableSpots");
                int bookedSpots = rs.getInt("bookedSpots");
                int tourPrice = rs.getInt("tourPrice");
                boolean fullyBooked = rs.getBoolean("fullyBooked");
                String tourRegion = rs.getString("tourRegion");
                int duration = rs.getInt("duration");
                String services = rs.getString("services");
                long date = rs.getLong("date");
                LocalDate localDate = millisToLocalDate(date);

                Tour tour= new Tour(tourName, tourInfo, localDate, availableSpots, tourPrice, tourRegion, duration, services);
                allTours.add(tour);
                tour.setTourID(tourID);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allTours;
    }

    public void insertUser(User user) {
        String sql = "INSERT INTO User VALUES(?,?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getPassword()); // 5T-Ath: breytt úr userID í password
            pstmt.setString(2, user.getUserName());
            pstmt.setString(3, user.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*public void deleteUser (String ID) {
        String sql = "DELETE FROM User WHERE userID = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1,ID);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/

    public ObservableList<User> getUsers(){
        ObservableList<User> allUsers = FXCollections.observableArrayList();
        String sql = "SELECT userID, userName, userEmail FROM User";

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {
                String userID = rs.getString("userID");
                String userName = rs.getString("userName");
                String userEmail = rs.getString("userEmail");

                User user= new User(userID,userName,userEmail);
                allUsers.add(user);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allUsers;
    }

    public void insertBooking(String user, int tour, int spots) {
        String sql = "INSERT INTO Booking VALUES(null,?,?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user);
            pstmt.setInt(2, tour);
            pstmt.setInt(3, spots);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void deleteBooking (int ID) {
        String sql = "DELETE FROM Booking WHERE bookingID = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,ID);
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ObservableList<Booking> getBookings() {
        ObservableList<Booking> allBookings = FXCollections.observableArrayList();
        TourUserController userController=new TourUserController();
        TourController tourController = new TourController();
        String sql = "SELECT bookingID, userID, tourID, spots FROM Booking";

        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                int bookingID = rs.getInt("bookingID");
                String userID = rs.getString("userID");
                int tourID = rs.getInt("tourID");
                int spots = rs.getInt("spots");

                User user =userController.findUserByID(userID);
                Tour tour = tourController.findTourByID(tourID);

                Booking booking = new Booking(user, tour, spots);
                booking.setBookingID(bookingID);
                allBookings.add(booking);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allBookings;
    }
}
