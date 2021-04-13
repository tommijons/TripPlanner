package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

public class Controller extends CommonMethods implements Initializable {

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

    private final String[] locations = {"Reykjavík","Akureyri", "Ísafjörður","Egilstaðir"};
    private final String[] services = {"Family friendly", "Action", "Wheelchair accessible"};
    private final String[] numbers = {"1","2","3","4","5"};

    private Searcher searcher;
    private SearchResultsController searchResultsController;
    private FlightSearchController fsc;
    private TourController tsc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        uiInitialize();
        fsc = new FlightSearchController();
        tsc = new TourController();
        searcher = new Searcher(fsc,tsc);

       try {
            searchResultsController = loadSearchResults();
        } catch(IOException e) {
                e.printStackTrace();
        }
    }

    private SearchResultsController loadSearchResults() throws java.io.IOException{
        FXMLLoader dLoader = new FXMLLoader(getClass().getResource("SearchResults.fxml"));
        dLoader.load();
        return dLoader.getController();
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
    }

    @FXML
    private void searchHandler(MouseEvent mouseEvent) {
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
            case "Egilstaðir" -> "EGS";
            default -> "";
        };

        String toFlug = switch (to) {
            case "Reykjavík" -> "REY";
            case "Akureyri" -> "AEY";
            case "Ísafjörður" -> "IFJ";
            case "Egilstaðir" -> "EGS";
            default -> "";
        };
        System.out.println("controller: " + fromFlug);
        System.out.println("controller: " + toFlug);

        FlightFilter ff = new FlightFilter(fromFlug,toFlug,depDate,retDate,true);
        HotelFilter hf = new HotelFilter(depDate,retDate,to,travellers,noHotelRooms,true,true,true);
        TourFilter tf = new TourFilter(depDate,retDate,to,99999,services,1,99,travellers);

        SearchResults searchResults = searcher.searchForPackages(ff,hf,tf);
        searchResultsController.results(searchResults);
    }

    public void closeMenu(MouseEvent actionEvent){
        System.exit(0);
    }
}


