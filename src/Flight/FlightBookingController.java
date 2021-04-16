package Flight;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import tripPackage.User;
import static java.lang.Integer.parseInt;

public class FlightBookingController implements Initializable {
    @FXML public GridPane SeatGrid, GridImage;
    public Label FromDisplay,ToDisplay, TimeDisplay, AirlineDisplay, DateDisplay, PriceDisplay;

    private FlightDataFactory dataFactory = new FlightDataFactory();
    public UserData ud = UserData.getInstance();

    // createBooking
    public void createBooking(User user, Flight flight, ArrayList<Integer> seat_id) {
        for(int id : seat_id) {
            Seat seat = dataFactory.getSeat(flight.getId(), id);
            Booking currentBooking = new Booking(flight, user, seat);
            // bóka sæti
            dataFactory.reserveSeat(currentBooking.getFlight().getId(), currentBooking.getSeat().getSeatID(), false);
            // bæta bókun við gagnagrunn
            dataFactory.createBooking(currentBooking.getUser().getEmail() ,currentBooking.getFlight().getId(), currentBooking.getSeat().getSeatID());
        }
    }

    // takkavirkni til að loada scenes
    public void backbuttonPushed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("search.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    // bóka flug takki
    public void confirmButtonPushed(ActionEvent event) throws IOException {
        if (anyChecked()){
            ObservableList<Node> children = SeatGrid.getChildren();
            for (Node child : children) {
                if (child instanceof CheckBox) {
                    CheckBox checkBox = (CheckBox) child;
                    if (checkBox.isSelected()) {
                        ud.seats.add(parseInt(checkBox.getText()));
                    }
                }
            }
            createBooking(ud.user, ud.flight, ud.seats);

            Parent tableViewParent = FXMLLoader.load(getClass().getResource("Bookingdisplay.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(tableViewScene);
            window.show();
        }
        else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Ekkert sæti valið");
            a.show();
        }
    }

    public Boolean anyChecked(){
        ObservableList<Node> children = SeatGrid.getChildren();
        int i = 0;
        for (Node bobbi : children){
            i++;
            if (bobbi instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) bobbi;
                int b = parseInt(checkBox.getText());
                Seat saeticheck = dataFactory.getSeat(ud.flight.getId(), i);
                if (b == saeticheck.getSeatID()) {
                    if (checkBox.isSelected()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @FXML
    public void priceUpdater(ActionEvent event) {
        ObservableList<Node> children = SeatGrid.getChildren();
        int flightprice = ud.flight.getPrice();
        int i = 0;
        int price = 0;
        for (Node bobbi : children) {
            i++;
            if (bobbi instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) bobbi;
                int b = parseInt(checkBox.getText());
                Seat saeticheck = dataFactory.getSeat(ud.flight.getId(), i);
                if (b == saeticheck.getSeatID()) {
                    if (checkBox.isSelected()) {
                        if (saeticheck.isFirstClass()) {
                            price += flightprice + 2000;
                        } else if (saeticheck.isEmergency()) {
                            price += flightprice + 500;
                        } else {
                            price += flightprice;
                        }
                    }
                }
            }
        }
        ud.price = price;
        PriceDisplay.setText((ud.price) + " kr.");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FromDisplay.setText(ud.flight.getDepartureLocation());
        ToDisplay.setText(ud.flight.getArrivalLocation());
        TimeDisplay.setText(ud.flight.getDepartureTime());
        AirlineDisplay.setText(ud.flight.getAirline());
        DateDisplay.setText(ud.flight.getFlightDate());
        PriceDisplay.setText("0 kr.");
        PriceDisplay.setTextAlignment(TextAlignment.CENTER);

        Image seat = new Image("/images/seat.png");
        Image firstclass = new Image("/images/firstclass.png");
        Image emergency = new Image("/images/emergency.png");

        //initializea sætisglugga
        ObservableList<Node> children = SeatGrid.getChildren();
        ObservableList<Node> myndir = GridImage.getChildren();
        int i = 0;
        int x = 0;
        for(Node child : myndir){
            i++;
            if (child instanceof ImageView){
                ImageView imageView = (ImageView) child;
                Seat saeti = dataFactory.getSeat(ud.flight.getId(), i);
                if(saeti.isEmergency()){
                    imageView.setImage(emergency);
                }
                else if(saeti.isFirstClass()){
                    imageView.setImage(firstclass);
                }
                else imageView.setImage(seat);

            }
        }
        for (Node bobbi : children){
            x++;
            if(bobbi instanceof CheckBox) {
                CheckBox checkBox = (CheckBox) bobbi;
                int b = parseInt(checkBox.getText());
                Seat saeticheck = dataFactory.getSeat(ud.flight.getId(), x);
                if(b == saeticheck.getSeatID()){
                    if(!saeticheck.isAvailable()){
                        checkBox.setOpacity(0.3);
                        checkBox.setDisable(true);
                    }
                }
            }
        }
    }
}