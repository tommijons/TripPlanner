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
    private ComboBox fxInterests;

    private Searcher searcher;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        UIinitialize();
    /*    try {
            searcher = loadSearchResults();
        } catch(IOException e) {
                e.printStackTrace();
        }*/

    }

    private Searcher loadSearchResults() throws java.io.IOException{
        FXMLLoader dLoader = new FXMLLoader(getClass().getResource("SearchResult.fxml"));
        dLoader.load();
        return dLoader.getController();
    }

    private void UIinitialize() {
        ObservableList<String> departureChoices = FXCollections.observableArrayList();
        ObservableList<String> destinationChoices = FXCollections.observableArrayList();
        ObservableList<String> priceBoxChoice = FXCollections.observableArrayList();
        ObservableList<String> travelersChoice = FXCollections.observableArrayList();
        departureChoices.addAll("Reykjavík","Akureyri", "Ísafjörður","Egilstaðir");
        fxDepartureLoc.setItems(departureChoices);
        fxDepartureLoc.setValue("From");
        destinationChoices.addAll("Reykjavík","Akureyri", "Ísafjörður","Egilstaðir");
        fxDestination.setItems(destinationChoices);
        fxDestination.setValue("To");
        priceBoxChoice.addAll("Cheap Package", "Standard Package", "Luxury Package");
        fxPrice.setItems(priceBoxChoice);
        fxPrice.setValue("Price Range");
        travelersChoice.addAll("1","2","3");
        fxNoTravellers.setItems(travelersChoice);
        fxNoTravellers.setValue("No. of Travelers");
        fxInterests.setValue("Interests");
    }

    @FXML
    private void searchButtonClicked(MouseEvent mouseEvent) throws IOException {
        searcher.searchForPackages();
        //TODO
    }
    public void closeMenu(MouseEvent actionEvent){
        System.exit(0);
    }
}


