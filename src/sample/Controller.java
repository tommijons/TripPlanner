package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ChoiceBox fxPrice;
    @FXML
    private DatePicker fxArrivalDate;
    @FXML
    private DatePicker fxDepartureDate;
    @FXML
    private ChoiceBox fxDestination;
    @FXML
    private Button fxSearchButton;
    @FXML
    private ListView fxTripList;
    @FXML
    private ChoiceBox destinationChoice;
    @FXML
    private ChoiceBox priceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<String> destinationChoices = FXCollections.observableArrayList();
        ObservableList<String> priceBoxChoice = FXCollections.observableArrayList();
        destinationChoices.addAll("Reykjavík","Akureyri", "Ísafjörður","Egilstaðir");
        fxDestination.setItems(destinationChoices);
        priceBoxChoice.addAll("Cheap Package", "Standard Package", "Luxury Package");
        fxPrice.setItems(priceBoxChoice);
    }




}


