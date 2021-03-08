package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ListView travelPackageView;
    @FXML
    private ListView hfdView;
    private DataFactory dataFactory = new DataFactory();
    private ObservableList<TravelPackage> travelPackages = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        travelPackages = dataFactory.getTravelPackages();
        travelPackageView.setItems(travelPackages);
    }
    public void selectPackage(MouseEvent mouseEvent){
        TravelPackage selectedPackage = (TravelPackage) travelPackageView.getSelectionModel().getSelectedItem();
        ObservableList<String> travelPackageItems = FXCollections.observableArrayList();
        String hotel = selectedPackage.getHotel().getName();
        String flight = selectedPackage.getFlight().getArrivalLocation();
        String dayTrip = selectedPackage.getDaytrip().getLocation();
        travelPackageItems.add(hotel);
        travelPackageItems.add(flight);
        travelPackageItems.add(dayTrip);
        hfdView.setItems(travelPackageItems);
    }
}
