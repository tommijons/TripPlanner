package sample;

import Flight.FlightDataFactory;
import Hotel.HotelBooking;
import Hotel.HotelDatabaseManager;
import Hotel.Room;
import Tour.Booking;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hdm = new HotelDatabaseManager();
        fdf = new FlightDataFactory();
        tdf = new TourDataFactory();

    }

    public void createBooking(User user, TravelPackage travelPackage) {
        ArrayList<Room> rooms = new ArrayList<>(travelPackage.getRooms());
        //HotelBooking hb = new HotelBooking(travelPackage.getHotel(), user, LocalDate.now(),LocalDate.now().plus(1, ChronoUnit.DAYS), rooms,travelPackage.getSeatsHome().size(),true);
        //hdm.addNewBooking(hb);
        for (int i =0; i < travelPackage.getSeatsOut().size(); i++) {
            fdf.createBooking(user.getEmail(),travelPackage.getFlight().getId(),travelPackage.getSeatsOut().get(i).getSeatID()); 
        }
        for (int i =0; i < travelPackage.getSeatsHome().size(); i++) {
            fdf.createBooking(user.getEmail(),travelPackage.getReturnFlight().getId(),travelPackage.getSeatsHome().get(i).getSeatID());
        }
        tdf.insertBooking(user.getUserName(),travelPackage.getDaytrip().getTourID(),travelPackage.getSeatsHome().size());

        

    }
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
