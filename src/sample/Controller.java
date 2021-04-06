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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
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
    private ChoiceBox fxDepartureLoc;
    @FXML
    private ChoiceBox fxNoTravellers;
    @FXML
    private ChoiceBox fxInterests;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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

    public void searchButtonClicked(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("SearchResults.fxml"));
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}


