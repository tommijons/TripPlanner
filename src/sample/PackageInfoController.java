package sample;

import Flight.Flight;
import Hotel.Hotel;
import Tour.Tour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PackageInfoController implements Initializable {

    @FXML
    private ListView<TravelPackage> fxPackageInfo;

    private ObservableList<TravelPackage> packageInfo;

    private TravelPackage selectedPackage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void selectedPackage(TravelPackage travelPackages) {
        selectedPackage = travelPackages;
        packageInfo = FXCollections.observableArrayList();

        packageInfo.add(travelPackages);
        fxPackageInfo.setItems(packageInfo);
    }

    public void bookHandler(MouseEvent mouseEvent) throws java.io.IOException {
        AppState state = AppState.getInstance();
        User user = state.getUser();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Booking.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        BookingController bc = loader.getController();
        bc.createBooking(user,selectedPackage);
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void backHandler(MouseEvent mouseEvent) throws java.io.IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SearchResults.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
