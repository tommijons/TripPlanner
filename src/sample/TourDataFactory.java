package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

import java.io.File;
import java.io.IOException;

public class TourDataFactory implements TourDataFactoryInterface {
    String DATABASE_URL;

    public TourDataFactory() {
        File directory = new File("./src/database");
        try {
            DATABASE_URL = "jdbc:sqlite:" + directory.getCanonicalPath() + "/tour.db";}
        catch (IOException e) {
            e.printStackTrace();}}

    /**
     * Sækir alla notendur.
     *
     * @return listi af notendum
     */
    public ObservableList<User> getUsers(String email) {
        ObservableList<User> users = FXCollections.observableArrayList();
        String query = "SELECT * FROM users WHERE email LIKE ?";
        Connection connection = null;
        try{
            // create a database connection
            connection = DriverManager.getConnection(DATABASE_URL);
            Statement statement = connection.createStatement();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                // read the result set
                users.add(new User(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password")));}}
        catch(SQLException e){
            System.err.println(e.getMessage());}
        finally{
            try{
                if(connection != null)
                    connection.close();}
            catch(SQLException e){
                // connection close failed.
                System.err.println(e.getMessage());}}
        return users;}

    public User createUser(String name, String email, String password) {
        User user = new User(name, email, password);
        String query =  "INSERT INTO users VALUES (?, ?, ?)";
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.executeUpdate();}
        catch(SQLException e){
            System.err.println(e.getMessage());}
        finally{
            try{
                if(connection != null)
                    connection.close();}
            catch(SQLException e){
                // connection close failed.
                System.err.println(e.getMessage());}}
        return user;}

    /**
     * Sækir öll sæti í tilteknu flugi.....
     * þarf þetta fyrir tours?
     * @param tour_id flugnúmer
     * @return listi af sætum
     */
    public ObservableList<Seat> getSeats(int tour_id){
        String id = Integer.toString(tour_id);
        ObservableList<Seat> seats = FXCollections.observableArrayList();
        String query = "SELECT * FROM seats WHERE tour_id = ?";
        Connection connection = null;
        try{
            // create a database connection
            connection = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                // read the result set
                seats.add(new Seat(
                        rs.getInt("tour_id"),
                        rs.getInt("seatID"),
                        rs.getBoolean("isAvailable"),
                        rs.getBoolean("isFirstClass"),
                        rs.getBoolean("isEmergency")));}}
        catch(SQLException e){
            System.err.println(e.getMessage());}
        finally{
            try{
                if(connection != null)
                    connection.close();}
            catch(SQLException e){
                // connection close failed.
                System.err.println(e.getMessage());}}
        return seats;}

    /**
     * Sækir flug eftir leit,
     * parametri = '%' ef ekki á að leita eftir honum.
     *
     * @param departureLocation brottfararstaður
     * @param arrivalLocation komustaður
     * @param tourDate dagsetning flugs (ár-mánuður-dags)
     * @param mealService er flug með veitingasölu eða ekki
     *
     * @return listi af flugum
     */
    public ObservableList<Tour> getTours(/*eitthvað... String departureLocation, String arrivalLocation, String tourDate, Boolean mealService*/) {
        ObservableList<Tour> tours = FXCollections.observableArrayList();
        String query =  "SELECT * FROM tours WHERE departureLocation LIKE ? AND arrivalLocation LIKE ? AND tourDate LIKE ?";
        if (mealService != null && mealService)  {
            query = "SELECT * FROM tours WHERE departureLocation LIKE ? AND arrivalLocation LIKE ? AND tourDate LIKE ? AND mealService";}
        Connection connection = null;
        try{
            // create a database connection
            connection = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, departureLocation);
            pstmt.setString(2, arrivalLocation);
            pstmt.setString(3, tourDate);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                // read the result set
                tours.add(new Tour(
                        rs.getInt("id"),
                        rs.getString("departureLocation"),
                        rs.getString("arrivalLocation"),
                        rs.getString("departureTime"),
                        rs.getString("arrivalTime"),
                        rs.getString("tourDate"),
                        rs.getInt("price"),
                        rs.getString("airline"),
                        rs.getBoolean("mealService")));}}
        catch(SQLException e) {
            System.err.println(e.getMessage()); }
        finally {
            try {
                if(connection != null)
                    connection.close(); }
            catch(SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage()); } }
        return tours; }

    public static void main(String[] args) throws IOException {
        TourDataFactory dataFactory = new TourDataFactory();
        /*
        ObservableList<Tour> tours = dataFactory.getTours("%", "%", "%", null);
        for (Tour tour: tours) {
            System.out.println(tour);
        }
        ObservableList<Seat> seats = dataFactory.getSeats(1);
        for (Seat seat: seats) {
            System.out.println(seat);
        }
        */
        // dataFactory.createUser("test2", "test2@test.com", "1234");
        ObservableList<User> users = dataFactory.getUsers("%");
        for (User user: users) {
            System.out.println(user);}}
}