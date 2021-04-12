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
    private Button fxSearchButton;
    @FXML
    private ComboBox fxDepartureLoc;
    @FXML
    private ComboBox fxNoTravellers;
    @FXML
    private ComboBox fxServices;
    @FXML
    private ComboBox fxNoHotel;
    @FXML
    private CheckBox fxMeal;
    @FXML
    private CheckBox fx3Star;
    @FXML
    private CheckBox fx4Star;
    @FXML
    private CheckBox fx5Star;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Searcher searcher;
    private SearchResultsController searchResultsController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UIinitialize();
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

    private void UIinitialize() {
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
        serviceChoice.addAll("Family Friendly", "Action", "Wheelchair accessible");
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
        boolean threeStar = fx3Star.isSelected();
        boolean fourStar = fx4Star.isSelected();
        boolean fiveStar = fx5Star.isSelected();
        boolean meal = fxMeal.isSelected();
        String toFlug = "";
        String fromFlug = "";
        /*System.out.println(depDate);
        System.out.println(retDate);
        System.out.println(from);
        System.out.println(to);
        System.out.println(travellers);
        System.out.println(noHotelRooms);
        System.out.println(services);
        System.out.println(threeStar);
        System.out.println(fourStar);
        System.out.println(fiveStar);*/
        if (from.equals("Reykjavík")){
            fromFlug = "REY";
        }else if (from.equals("Akureyri")) {
            fromFlug = "AEY";
        }else if (from.equals("Ísafjörður")) {
            fromFlug = "ÍSF";
        }else if (from.equals("Egilsstaðir")) {
            fromFlug = "EGS";
        }
        if (to.equals("Reykjavík")){
            toFlug = "REY";
        }else if (to.equals("Akureyri")) {
            toFlug = "AEY";
        }else if (to.equals("Ísafjörður")) {
            toFlug = "ÍSF";
        }else if (to.equals("Egilsstaðir")) {
            toFlug = "EGS";
        }
        FlightFilter ff = new FlightFilter(fromFlug,toFlug,depDate,retDate,meal);
        HotelFilter hf = new HotelFilter(LocalDate.now(),LocalDate.now().plus(1,ChronoUnit.DAYS),to,travellers,noHotelRooms,true,true,true);
        TourFilter tf = new TourFilter(depDate,retDate,to,99999,services,1,99,travellers);
        FlightSearchController fsc = new FlightSearchController();
        TourController tsc = new TourController();
        searcher = new Searcher(fsc,1,tsc);
        SearchResults searchResults = searcher.searchForPackages(ff,hf,tf);
        System.out.println(searchResults.getCheapPackage().toString());
        System.out.println(searchResults.getStandardPackage().toString());
        System.out.println(searchResults.getLuxuryPackage().toString());
        /*
        FlightFilter ff = new FlightFilter(from,to,depDate,retDate,meal);
        HotelFilter hf = new HotelFilter(depDate,retDate,to,travellers,
                                noHotelRooms,threeStar,fourStar,fiveStar);
        HotelFilter hf = new HotelFilter(LocalDate.now().plus(3, ChronoUnit.DAYS),LocalDate.now().plus(6,ChronoUnit.DAYS),
                "Akureyri",1,
                1,true,true,true);
        TourFilter tf = new TourFilter(LocalDate.now(),LocalDate.now().plus(1,ChronoUnit.DAYS),"Reykjavík",99999,"Action",0,100,1);
        searcher = new Searcher(new FlightSearchController(),1,new TourController());
        AppState appState = AppState.getInstance();
        appState.setSearchResult(searcher.searchForPackages(ff,hf,tf));
        searchResultsController.results();
        try {
        root = FXMLLoader.load(getClass().getResource("SearchResults.fxml"));
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }catch (IOException io){}*/
    }

    public void closeMenu(MouseEvent actionEvent){
        System.exit(0);
    }


}


