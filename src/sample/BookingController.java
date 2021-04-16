package sample;

import Flight.Booking;
import Flight.FlightDataFactory;
import Flight.Seat;
import Hotel.HotelBooking;
import Hotel.HotelDatabaseManager;
import Hotel.Room;
import Tour.TourBookingController;
import Tour.TourDataFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.FixedWidth;


import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookingController extends CommonMethods implements Initializable {

    @FXML
    private TextField fxName;
    @FXML
    private TextField fxEmail;
    @FXML
    private TextField fxCCNo;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private HotelDatabaseManager hdm;
    private FlightDataFactory fdf;
    private TourDataFactory tdf;
    private TravelPackage selectedPackage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hdm = new HotelDatabaseManager();
        fdf = new FlightDataFactory();
        tdf = new TourDataFactory();

    }
    public void getPackage(TravelPackage travelPackage) {
        selectedPackage = travelPackage;
    }

    public void bookingHandler(ActionEvent actionEvent) {

        AppState state = AppState.getInstance();
        User user = state.getUser();

        ArrayList<Room> rooms = new ArrayList<>(selectedPackage.getRooms());
        HotelBooking hb = new HotelBooking(selectedPackage.getHotel(), user, LocalDate.of(2021,01,01),LocalDate.of(2021,02,01), rooms,selectedPackage.getSeatsHome().size(),true);
        hdm.addNewBooking(hb);
        tdf.insertBooking(user.getUserName(),selectedPackage.getDaytrip().getTourID(),selectedPackage.getSeatsHome().size());
        tdf.insertUser(user);
        fdf.createUser(user.getUserName(),user.getEmail(),user.getPassword());
        ArrayList<Integer> seat_id = new ArrayList<>();
        for (int i = 0;i < selectedPackage.getSeatsOut().size();i++){
            seat_id.add(selectedPackage.getSeatsOut().get(i).getSeatID());
        }
        for(int id : seat_id) {
            Seat seat = fdf.getSeat(selectedPackage.getFlight().getId(), id);
            Flight.Booking currentBooking = new Booking(selectedPackage.getFlight(), user, seat);
            // bóka sæti
            fdf.reserveSeat(currentBooking.getFlight().getId(), currentBooking.getSeat().getSeatID(), false);
            // bæta bókun við gagnagrunn
            fdf.createBooking(currentBooking.getUser().getEmail() ,currentBooking.getFlight().getId(), currentBooking.getSeat().getSeatID());
        }
        ArrayList<Integer> seat_id2 = new ArrayList<>();
        for (int i = 0;i < selectedPackage.getSeatsHome().size();i++){
            seat_id2.add(selectedPackage.getSeatsHome().get(i).getSeatID());
        }
        for(int id : seat_id2) {
            Seat seat = fdf.getSeat(selectedPackage.getReturnFlight().getId(), id);
            Flight.Booking currentBooking = new Booking(selectedPackage.getReturnFlight(), user, seat);
            // bóka sæti
            fdf.reserveSeat(currentBooking.getFlight().getId(), currentBooking.getSeat().getSeatID(), false);
            // bæta bókun við gagnagrunn
            fdf.createBooking(currentBooking.getUser().getEmail() ,currentBooking.getFlight().getId(), currentBooking.getSeat().getSeatID());
        }
    }
    /*
    public void createBooking(User user, TravelPackage travelPackage) {
        ArrayList<Room> rooms = new ArrayList<>(travelPackage.getRooms());
        HotelBooking hb = new HotelBooking(travelPackage.getHotel(), user, LocalDate.of(2021,01,01),LocalDate.of(2021,02,01), rooms,travelPackage.getSeatsHome().size(),true);
        hdm.addNewBooking(hb);
        tdf.insertBooking(user.getUserName(),travelPackage.getDaytrip().getTourID(),travelPackage.getSeatsHome().size());
        tdf.insertUser(user);
        fdf.createUser(user.getUserName(),user.getEmail(),user.getPassword());
        ArrayList<Integer> seat_id = new ArrayList<>();
        for (int i = 0;i < travelPackage.getSeatsOut().size();i++){
            seat_id.add(travelPackage.getSeatsOut().get(i).getSeatID());
        }
        for(int id : seat_id) {
            Seat seat = fdf.getSeat(travelPackage.getFlight().getId(), id);
            Flight.Booking currentBooking = new Booking(travelPackage.getFlight(), user, seat);
            // bóka sæti
            fdf.reserveSeat(currentBooking.getFlight().getId(), currentBooking.getSeat().getSeatID(), false);
            // bæta bókun við gagnagrunn
            fdf.createBooking(currentBooking.getUser().getEmail() ,currentBooking.getFlight().getId(), currentBooking.getSeat().getSeatID());
        }
        ArrayList<Integer> seat_id2 = new ArrayList<>();
        for (int i = 0;i < travelPackage.getSeatsHome().size();i++){
            seat_id2.add(travelPackage.getSeatsHome().get(i).getSeatID());
        }
        for(int id : seat_id2) {
            Seat seat = fdf.getSeat(travelPackage.getReturnFlight().getId(), id);
            Flight.Booking currentBooking = new Booking(travelPackage.getReturnFlight(), user, seat);
            // bóka sæti
            fdf.reserveSeat(currentBooking.getFlight().getId(), currentBooking.getSeat().getSeatID(), false);
            // bæta bókun við gagnagrunn
            fdf.createBooking(currentBooking.getUser().getEmail() ,currentBooking.getFlight().getId(), currentBooking.getSeat().getSeatID());
        }
    }*/
    public void removeBooking() {
        //
    }
    public void backHandler(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SearchResults.fxml"));
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void closeMenu(MouseEvent actionEvent){
        System.exit(0);
    }


}
