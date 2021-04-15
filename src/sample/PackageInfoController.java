package sample;

import Flight.Flight;
import Hotel.Hotel;
import Tour.Tour;
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

import java.net.URL;
import java.util.ResourceBundle;

public class PackageInfoController implements Initializable {

    @FXML
    private ListView<TravelPackage> fxPackageInfo;

    private ObservableList<TravelPackage> packageInfo;
    private ObservableList<Hotel> hotelInfo;
    private ObservableList<Tour> tourInfo;
    private SearchResults searchResults;

    private ObservableList<TravelPackage> selectedPackage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void selectedPackage(TravelPackage travelPackages) {
        packageInfo = FXCollections.observableArrayList();
        hotelInfo = FXCollections.observableArrayList();
        tourInfo = FXCollections.observableArrayList();
        packageInfo.add(travelPackages);
        fxPackageInfo.setItems(packageInfo);
    }

    public void backHandler(MouseEvent mouseEvent) throws java.io.IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SearchResults.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
