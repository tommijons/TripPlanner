package Flight;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.User;

import java.sql.*;

import java.io.File;
import java.io.IOException;

public class FlightDataFactory implements FlightDataFactoryInterface {
    String DATABASE_URL;

    public FlightDataFactory() {
        File directory = new File("./src/database"); // path í möppuna sem gagnagrunnurinn er geymdur í.
        try {
            DATABASE_URL = "jdbc:sqlite:" + directory.getCanonicalPath() + "/flight.db";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sækir alla notendur.
     *
     * @return listi af notendum
     */
    public ObservableList<User> getUsers(String email) {
        ObservableList<User> users = FXCollections.observableArrayList();

        String query = "SELECT * FROM users WHERE email LIKE ?";

        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection(DATABASE_URL);
            Statement statement = connection.createStatement();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                // read the result set
                users.add(new User(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password")
                ));
            }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return users;
    }

    /**
     * Býr til nýjan notanda
     *
     * @param name nafn
     * @param email email
     * @param password lykilorð
     * @return notandi
     */
    public User createUser(String name, String email, String password) {
        User user = new User(name, email, password);

        String query =  "INSERT INTO users VALUES (?, ?, ?)";

        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.executeUpdate();
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return user;
    }

    /**
     * Skilar öllum bókunum á tilteknu emaili
     *
     * @param user_email email notanda
     * @return lista af bókunum
     */
    public ObservableList<Booking> getBookings(String user_email) {
        ObservableList<Booking> bookings = FXCollections.observableArrayList();

        String query = "SELECT * FROM bookings WHERE user_email LIKE ?";

        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection(DATABASE_URL);
            Statement statement = connection.createStatement();
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, user_email);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                // read the result set
                int flightId = rs.getInt("flight_id");
                String userEmail = rs.getString("user_email");
                int seatId = rs.getInt("seat_id");

                Flight flight = getFlightbyID(flightId);
                ObservableList<User> users = getUsers(userEmail);
                Seat seat = getSeat(flightId, seatId);

                bookings.add(new Booking(flight, users.get(0), seat));
            }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return bookings;
    }

    /**
     * Býr til nýja bókun
     *
     * @param user_email email notanda
     * @param flight_id flugnúmer
     * @param seat_id sætisnúmer
     */
    public void createBooking(String user_email, int flight_id, int seat_id) {
        String flightId = Integer.toString(flight_id);
        String seatId = Integer.toString(seat_id);

        String query =  "INSERT INTO bookings VALUES (?, ?, ?)";

        Connection connection = null;
        try
        {
            connection = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, user_email);
            pstmt.setString(2, flightId);
            pstmt.setString(3, seatId);
            pstmt.executeUpdate();
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * Sækir öll sæti í tilteknu flugi.
     *
     * @param flight_id flugnúmer
     * @return listi af sætum
     */
    public ObservableList<Seat> getSeats(int flight_id){
        String id = Integer.toString(flight_id);
        ObservableList<Seat> seats = FXCollections.observableArrayList();

        String query = "SELECT * FROM seats WHERE flight_id = ?";

        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                // read the result set
                seats.add(new Seat(
                        rs.getInt("flight_id"),
                        rs.getInt("seatID"),
                        rs.getBoolean("isAvailable"),
                        rs.getBoolean("isFirstClass"),
                        rs.getBoolean("isEmergency")
                ));
            }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        return seats;
    }

    /**
     * Skilar einu sæti
     *
     * @param flight_id flugnúmer
     * @param seatID sætisnúmer
     * @return sæti
     */
    public Seat getSeat(int flight_id, int seatID) {
        String id = Integer.toString(flight_id);
        String seatId = Integer.toString(seatID);
        Seat seat = null;

        String query = "SELECT * FROM seats WHERE flight_id = ? AND seatID = ?";

        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, seatId);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next())
            {
                // read the result set
                seat = new Seat( rs.getInt("flight_id"),
                        rs.getInt("seatID"),
                        rs.getBoolean("isAvailable"),
                        rs.getBoolean("isFirstClass"),
                        rs.getBoolean("isEmergency"));
            }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }

        return seat;
    }

    /**
     * Bókar sæti
     *
     * @param flight_id flugnúmer
     * @param seatID sætisnúmer
     * @param isAvailable laust/frátekið
     */
    public void reserveSeat(int flight_id, int seatID, boolean isAvailable) {
        String flightId = Integer.toString(flight_id);
        String seatId = Integer.toString(seatID);

        String query = "UPDATE seats SET isAvailable = ? WHERE flight_id = ? AND seatID = ?";

        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setBoolean(1, isAvailable);
            pstmt.setString(2, flightId);
            pstmt.setString(3, seatId);
            pstmt.executeUpdate();
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * Sækir flug eftir leit,
     * parametri = '%' ef ekki á að leita eftir honum.
     *
     * @param departureLocation brottfararstaður
     * @param arrivalLocation komustaður
     * @param flightDate dagsetning flugs (ár-mánuður-dags)
     * @param mealService er flug með veitingasölu eða ekki
     *
     * @return listi af flugum
     */
    public ObservableList<Flight> getFlights(String departureLocation, String arrivalLocation, String flightDate, Boolean mealService) {
        ObservableList<Flight> flights = FXCollections.observableArrayList();

        String query =  "SELECT * FROM flights WHERE departureLocation LIKE ? AND arrivalLocation LIKE ? AND flightDate LIKE ?";

        if (mealService != null && mealService)  {
            query = "SELECT * FROM flights WHERE departureLocation LIKE ? AND arrivalLocation LIKE ? AND flightDate LIKE ? AND mealService";
        }

        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, departureLocation);
            pstmt.setString(2, arrivalLocation);
            pstmt.setString(3, flightDate);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                // read the result set
                flights.add(new Flight(
                        rs.getInt("id"),
                        rs.getString("departureLocation"),
                        rs.getString("arrivalLocation"),
                        rs.getString("departureTime"),
                        rs.getString("arrivalTime"),
                        rs.getString("flightDate"),
                        rs.getInt("price"),
                        rs.getString("airline"),
                        rs.getBoolean("mealService")
                ));
            }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return flights;
    }

    /**
     * Sækir flug eftir flugnúmeri.
     *
     * @param flight_id flugnúmer
     * @return flugi
     */
    public Flight getFlightbyID(int flight_id) {
        String id = Integer.toString(flight_id);
        Flight flight = null;

        String query =  "SELECT * FROM flights WHERE id = ?";


        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection(DATABASE_URL);
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                // read the result set
                flight = new Flight(
                        rs.getInt("id"),
                        rs.getString("departureLocation"),
                        rs.getString("arrivalLocation"),
                        rs.getString("departureTime"),
                        rs.getString("arrivalTime"),
                        rs.getString("flightDate"),
                        rs.getInt("price"),
                        rs.getString("airline"),
                        rs.getBoolean("mealService")
                );
            }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
        return flight;
    }

    public static void main(String[] args) throws IOException {

    }
}