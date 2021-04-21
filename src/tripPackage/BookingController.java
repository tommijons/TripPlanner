package tripPackage;

import Flight.Booking;
import Flight.FlightDataFactory;
import Flight.Seat;
import Hotel.*;
import Tour.TourDataFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookingController implements Initializable {

    @FXML
    private Button fxConfirm;
    @FXML
    private TextField fxName;
    @FXML
    private TextField fxAddress;
    @FXML
    private TextField fxPhone;
    @FXML
    private TextField fxCCN;
    @FXML
    private Label fxDepDate;
    @FXML
    private Label fxRetDate;
    @FXML
    private Label fxHotel;
    @FXML
    private Label fxTour;
    @FXML
    private Label fxPrice;
    private HotelDatabaseManager hdm;
    private FlightDataFactory fdf;
    private TourDataFactory tdf;
    private TravelPackage selectedPackage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hdm = new HotelDatabaseManager();
        fdf = new FlightDataFactory();
        tdf = new TourDataFactory();
        confirmOkay();
    }

    public void getPackage(TravelPackage travelPackage) {
        selectedPackage = travelPackage;
        fxDepDate.setText(selectedPackage.getFfrom().toString());
        fxRetDate.setText(selectedPackage.getTil().toString());
        fxHotel.setText(selectedPackage.getHotel().getHotel_name());
        fxTour.setText(selectedPackage.getDaytrip().getTourName());
        fxPrice.setText(Integer.toString(selectedPackage.getTotalPrice()));
    }

    private void confirmOkay() {
        fxConfirm.disableProperty()
                .bind(fxName.textProperty().isEmpty()
                        .or(fxAddress.textProperty().isEmpty())
                        .or(fxPhone.textProperty().isEmpty())
                        .or(fxCCN.textProperty().isEmpty()
                        ));
    }
    public void bookingHandler(ActionEvent actionEvent) throws IOException {

        AppState state = AppState.getInstance();
        User user = state.getUser();
        HotelFilter hf = state.getHf();
        ArrayList<Room> rooms = new ArrayList<>(selectedPackage.getRooms());
        HotelSearchController hsc = new HotelSearchController();
        hsc.createNewUser(user.getUserName(),user.getEmail());
        user.setUser_id(hsc.getUserIDByUserEmail(user.getEmail()));
        hsc.createNewBooking(selectedPackage.getHotel(),user,hf.getCheckIn(),hf.getCheckOut(),rooms,hf.getSelectedNumOfGuests());
        tdf.insertBooking(user.getUserName(),selectedPackage.getDaytrip().getTourID(),selectedPackage.getSeatsHome().size());
        tdf.insertUser(user);
        fdf.createUser(user.getUserName(),user.getEmail(),user.getPassword());
        ArrayList<Integer> seat_id = new ArrayList<>();
        System.out.println(selectedPackage);
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
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("Package booked!");
        a.show();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MyBookings.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        MyBookingsController mbc = loader.getController();
        Stage window = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void removeBooking() {
        //
    }
    public void backHandler(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SearchResults.fxml"));
        Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void closeMenu(MouseEvent actionEvent){
        System.exit(0);
    }


}
