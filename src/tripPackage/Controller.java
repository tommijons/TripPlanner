package tripPackage;


import Flight.FlightFilter;
import Flight.FlightSearchController;
import Hotel.HotelFilter;
import Hotel.HotelSearchController;
import Tour.TourController;
import Tour.TourFilter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.time.LocalDate;
import java.util.ResourceBundle;

import static java.time.temporal.ChronoUnit.DAYS;

public class Controller implements Initializable {

    @FXML
    private DatePicker fxArrivalDate;
    @FXML
    private DatePicker fxDepartureDate;
    @FXML
    private ComboBox<String> fxDestination;
    @FXML
    private ComboBox<String> fxDepartureLoc;
    @FXML
    private ComboBox<String> fxNoTravellers;
    @FXML
    private ComboBox<String> fxServices;
    @FXML
    private ComboBox<String> fxNoHotel;
    @FXML
    private Label fxUserName;
    @FXML
    private Label fxNoPackagesText;

    private static final String[] locations = {"Reykjavík","Akureyri", "Ísafjörður","Egilsstaðir"};
    private static final String[] services = {"Family friendly", "Action", "Wheelchair accessible"};
    private static final String[] numbers = {"1","2","3","4","5"};
    private static final String ERROR_SEARCH = "No Packages found based \non selected search criteria";
    private static final String ERROR_BOOKING = "You have no booked trips";

    private Searcher searcher;
    private FlightSearchController fsc;
    private TourController tsc;
    private User theUser;
    private HotelSearchController hsc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        uiInitialize();
        fsc = new FlightSearchController();
        tsc = new TourController();
        hsc = new HotelSearchController();
        searcher = new Searcher(fsc,hsc, tsc);
    }

    private void uiInitialize() {
        ObservableList<String> departureChoices = FXCollections.observableArrayList(locations);
        ObservableList<String> destinationChoices = FXCollections.observableArrayList(locations);
        ObservableList<String> travelersChoice = FXCollections.observableArrayList(numbers);
        ObservableList<String> serviceChoice = FXCollections.observableArrayList(services);
        ObservableList<String> nrHotelChoice = FXCollections.observableArrayList(numbers);
        fxDepartureLoc.setItems(departureChoices);
        fxDestination.setItems(destinationChoices);
        fxNoHotel.setItems(nrHotelChoice);
        fxNoTravellers.setItems(travelersChoice);
        fxServices.setItems(serviceChoice);
        fxNoPackagesText.setText("");
    }

    @FXML
    private void searchHandler(MouseEvent mouseEvent) throws java.io.IOException {
        LocalDate depDate = fxDepartureDate.getValue();
        LocalDate retDate = fxArrivalDate.getValue();
        String from = String.valueOf(fxDepartureLoc.getValue());
        String to = String.valueOf(fxDestination.getValue());
        int travellers = Integer.parseInt(String.valueOf(fxNoTravellers.getValue()));
        int noHotelRooms = Integer.parseInt(String.valueOf(fxNoHotel.getValue()));
        String services = String.valueOf(fxServices.getValue());

        String fromFlug = switch (from) {
            case "Reykjavík" -> "REY";
            case "Akureyri" -> "AEY";
            case "Ísafjörður" -> "IFJ";
            case "Egilsstaðir" -> "EGS";
            default -> "";
        };

        String toFlug = switch (to) {
            case "Reykjavík" -> "REY";
            case "Akureyri" -> "AEY";
            case "Ísafjörður" -> "IFJ";
            case "Egilsstaðir" -> "EGS";
            default -> "";
        };
        FlightFilter ff = new FlightFilter(fromFlug,toFlug,LocalDate.of(2021,01,01),LocalDate.of(2021,02,01),true,travellers);
        HotelFilter hf = new HotelFilter(depDate,retDate,to,travellers,noHotelRooms,true,true,true);
        TourFilter tf = new TourFilter(depDate,retDate,to,99999,services,1,99,travellers);
        AppState app = AppState.getInstance();
        try {
            SearchResults searchResults = searcher.searchForPackages(ff, hf, tf);
            app.setSearchResult(searchResults);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("SearchResults.fxml"));
            Parent parent = loader.load();
            Scene scene = new Scene(parent);
            SearchResultsController c = loader.getController();
            c.results(searchResults);
            Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        }catch (IndexOutOfBoundsException indexOutOfBoundsException){
            fxNoPackagesText.setText(ERROR_SEARCH);
        }
    }

    public void newUser (String name, String email, String password) {
        theUser = new User(name, email, password);
        fxUserName.setText("Hi " + name);

    }

    @FXML
    private void myBookHandler(MouseEvent mouseEvent) throws java.io.IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("MyBookings.fxml"));
            Parent parent = loader.load();
            Scene scene = new Scene(parent);
            MyBookingsController mbc = loader.getController();
            Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException e){
            e.printStackTrace();
            fxNoPackagesText.setText(ERROR_BOOKING);
        }
    }

    public void closeMenu(MouseEvent actionEvent){
        System.exit(0);
    }


}


