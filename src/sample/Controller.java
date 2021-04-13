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
    private ComboBox fxPrice;
    @FXML
    private DatePicker fxArrivalDate;
    @FXML
    private DatePicker fxDepartureDate;
    @FXML
    private ComboBox fxDestination;
    @FXML
    private ComboBox fxDepartureLoc;
    @FXML
    private ComboBox fxNoTravellers;
    @FXML
    private ComboBox fxServices;
    @FXML
    private ComboBox fxNoHotel;

    private Stage stage;
    private Scene scene;
    private Parent root;
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
        ObservableList<String> departureChoices = FXCollections.observableArrayList();
        ObservableList<String> destinationChoices = FXCollections.observableArrayList();
      //  ObservableList<String> priceBoxChoice = FXCollections.observableArrayList();
        ObservableList<String> travelersChoice = FXCollections.observableArrayList();
        ObservableList<String> serviceChoice = FXCollections.observableArrayList();
        ObservableList<String> NrHotelChoice = FXCollections.observableArrayList();
        departureChoices.addAll("Reykjavík","Akureyri", "Ísafjörður","Egilstaðir");
        fxDepartureLoc.setItems(departureChoices);
        destinationChoices.addAll("Reykjavík","Akureyri", "Ísafjörður","Egilstaðir");
        fxDestination.setItems(destinationChoices);
      //  priceBoxChoice.addAll("Cheap Package", "Standard Package", "Luxury Package");
      //  fxPrice.setItems(priceBoxChoice);
        NrHotelChoice.addAll("1","2","3","4");
        fxNoHotel.setItems(NrHotelChoice);
        travelersChoice.addAll("1","2","3");
        fxNoTravellers.setItems(travelersChoice);
        serviceChoice.addAll("Family friendly", "Action", "Wheelchair accessible");
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


