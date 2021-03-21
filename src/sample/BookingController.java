package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.FixedWidth;


import java.net.URL;
import java.util.ResourceBundle;

public class BookingController implements Initializable {

    @FXML
    private TextField fxName;
    @FXML
    private TextField fxEmail;
    @FXML
    private TextField fxCCNo;

    private Booking booking;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void newBooking(User user, TravelPackage travelPackage, int ccinfo) {
        booking = new Booking(user, travelPackage, ccinfo);

    }
    public void removeBooking() {
        //
    }
}
