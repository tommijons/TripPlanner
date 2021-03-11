package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ChoiceBox destinationChoice;
    @FXML
    private ChoiceBox priceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> destinationChoices = FXCollections.observableArrayList();
        ObservableList<String> priceBoxChoice = FXCollections.observableArrayList();
        destinationChoices.addAll("Reykjavík","Akureyri", "Ísafjörður","Egilstaðir");
        destinationChoice.setItems(destinationChoices);
        priceBoxChoice.addAll("Cheap Package", "Standard Package", "Luxury Package");
        priceBox.setItems(priceBoxChoice);
    }




}


