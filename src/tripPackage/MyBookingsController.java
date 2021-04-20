package tripPackage;

import Flight.Booking;
import Flight.FlightDataFactory;
import Hotel.HotelBooking;
import Hotel.HotelSearchController;
import Tour.TourDataFactory;
import Tour.TourUserController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MyBookingsController implements Initializable {
    @FXML
    private ListView<Flight.Booking> fxMyFlights;
    @FXML
    private ListView<Tour.Booking> fxMyTours;
    @FXML
    private ListView<HotelBooking> fxMyHotels;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AppState state = AppState.getInstance();
        String email = state.getUser().getEmail();
        FlightDataFactory fdf = new FlightDataFactory();
        TourDataFactory tdf = new TourDataFactory();
        TourUserController tuc = new TourUserController();
        fxMyFlights.setItems(fdf.getBookings(email));
        HotelSearchController hsc = new HotelSearchController();
        ObservableList<Tour.Booking> tourBookings = FXCollections.observableArrayList();
        ObservableList<Tour.Booking> allTourBookings = tdf.getBookings();
       for (int i = 0; i < allTourBookings.size();i++){
           if (allTourBookings.get(i).getUser() != null) {
               if (allTourBookings.get(i).getUser().getUserName().equals(state.getUser().getUserName())) {
                   tourBookings.add(allTourBookings.get(i));
               }
           }
        }
       fxMyTours.setItems(tourBookings);
       ObservableList<HotelBooking> hotelBookings = hsc.getBookingsByUserName(state.getUser().getUserName());
       System.out.println(state.getUser().getUserName());
       System.out.println(hotelBookings.size());
       fxMyHotels.setItems(hotelBookings);
    }
    public void backHandler(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
