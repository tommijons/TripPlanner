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
    private ListView hotelView;
    @FXML
    private ListView flightView;
    @FXML
    private ListView daytripView;
    private DataFactory dataFactory = new DataFactory();
    private ObservableList<TravelPackage> travelPackages = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        travelPackages = dataFactory.getTravelPackages();
        travelPackageView.setItems(travelPackages);
    }
    public void selectPackage(MouseEvent mouseEvent){
       TravelPackage selectedPackage = (TravelPackage) travelPackageView.getSelectionModel().getSelectedItem();
       ObservableList<String> hotelinfo = FXCollections.observableArrayList();
       String hotelName = selectedPackage.getHotel().getName();
       String hotelLocation = selectedPackage.getHotel().getLocation();
       String hotelrating = String.valueOf(selectedPackage.getHotel().getRating());
       String hotelprice = String.valueOf(selectedPackage.getHotel().getPrice());
       String hotelurl = selectedPackage.getHotel().getUrl();
       hotelinfo.add(hotelName);
       hotelinfo.add(hotelLocation);
       hotelinfo.add(hotelprice);
       hotelinfo.add(hotelrating);
       hotelinfo.add(hotelurl);
       hotelView.setItems(hotelinfo);
       ObservableList<String> flightInfo = FXCollections.observableArrayList();
       String departureLoc = selectedPackage.getFlight().getDepartureLocation();
       String arrivalLoc = selectedPackage.getFlight().getArrivalLocation();
       String departureDate = selectedPackage.getFlight().getDepartureDate();
       String arrivalDate = selectedPackage.getFlight().getArrivalDate();
       String flightPrice = String.valueOf(selectedPackage.getFlight().getPrice());
       flightInfo.add(departureLoc);
       flightInfo.add(arrivalLoc);
       flightInfo.add(departureDate);
       flightInfo.add(arrivalDate);
       flightInfo.add(flightPrice);
       flightView.setItems(flightInfo);
       ObservableList<String> dayTripInfo = FXCollections.observableArrayList();
       String daytripLoc = selectedPackage.getDaytrip().getLocation();
       String daytripDate = selectedPackage.getDaytrip().getDate();
       String daytripPrice = String.valueOf(selectedPackage.getDaytrip().getPrice());
       String daytriphandi = String.valueOf(selectedPackage.getDaytrip().getHandicap());
       String daytripPhys = String.valueOf(selectedPackage.getDaytrip().getPhysical());
       String daytripTrans = String.valueOf(selectedPackage.getDaytrip().getTransport());
       String daytripURL = selectedPackage.getDaytrip().getURL();
       dayTripInfo.add(daytripLoc);
       dayTripInfo.add(daytripDate);
       dayTripInfo.add(daytripPrice);
       dayTripInfo.add(daytriphandi);
       dayTripInfo.add(daytripPhys);
       dayTripInfo.add(daytripTrans);
       dayTripInfo.add(daytripURL);
       daytripView.setItems(dayTripInfo);

    }
}

