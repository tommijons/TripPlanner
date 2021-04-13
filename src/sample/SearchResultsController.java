package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchResultsController extends CommonMethods implements Initializable {

    private Scene scene;
    @FXML
    private BorderPane fxPane;
    @FXML
    private ListView<TravelPackage> fxCheapPackage;
    @FXML
    private ListView<TravelPackage> fxStandardPackage;
    @FXML
    private ListView<TravelPackage> fxLuxuryPackage;
    private ObservableList<TravelPackage> cheapPackage = FXCollections.observableArrayList();
    private ObservableList<TravelPackage> standardPackage = FXCollections.observableArrayList();
    private ObservableList<TravelPackage> luxuryPackage = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        scene = new Scene(fxPane);
    }

    /**
     * Birtir niðurstöðu leitar.
     * @param searchResults leitarniðurstöður
     */
    public void results(SearchResults searchResults) {
        Stage window = new Stage();
        window. setScene(scene);
        window.show();
        cheapPackage.add(searchResults.getCheapPackage());
        fxCheapPackage.setItems(cheapPackage);
        standardPackage.add(searchResults.getStandardPackage());
        fxStandardPackage.setItems(standardPackage);
        luxuryPackage.add(searchResults.getLuxuryPackage());
        fxLuxuryPackage.setItems(luxuryPackage);
    }

    /**
     * Velja pakka. TODO
     * @param mouseEvent
     */
    @FXML
    private void getSelectedPackage(MouseEvent mouseEvent) {
        ObservableList selectedPackage = FXCollections.observableArrayList();
        ListView lv =(ListView)mouseEvent.getSource();
        selectedPackage = lv.getSelectionModel().getSelectedItems();
    }

    /**
     * Handler fyrir bókanir. TODO
     * @param event
     * @throws IOException
     */
    @FXML
    private void bookingHandler(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("booking.fxml"));
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void BackButtonClicked(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void closeMenu(MouseEvent actionEvent){
        System.exit(0);
    }


}
