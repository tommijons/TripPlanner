package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private ObservableList<TravelPackage> cheapPackage;
    private ObservableList<TravelPackage> standardPackage;
    private ObservableList<TravelPackage> luxuryPackage;
    private SearchResults cheap;
    private SearchResults standard;
    private SearchResults lux;
    @FXML
    private Button fxCheapInfo;
    @FXML
    private Button fxStandardInfo;
    @FXML
    private Button fxLuxuryInfo;
    private PackageInfoController packageInfoController;
    private SearchResults sr;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



    /**
     * Birtir niðurstöðu leitar.
     * @param searchResults leitarniðurstöður
     */
    public void results(SearchResults searchResults) {
        sr = searchResults;
        cheapPackage = FXCollections.observableArrayList();
        standardPackage = FXCollections.observableArrayList();
        luxuryPackage = FXCollections.observableArrayList();
        cheapPackage.add(searchResults.getCheapPackage());
        fxCheapPackage.setItems(cheapPackage);
        standardPackage.add(searchResults.getStandardPackage());
        fxStandardPackage.setItems(standardPackage);
        luxuryPackage.add(searchResults.getLuxuryPackage());
        fxLuxuryPackage.setItems(luxuryPackage);
    }

    /**
     * Birtir nánari uppl um ódýra pakkann.
     * @param actionEvent
     * @throws java.io.IOException
     */
    @FXML
    private void cheapInfoHandler(MouseEvent actionEvent) throws java.io.IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PackageInfo.fxml"));
        Parent parent = loader.load();
        Scene tableViewScene = new Scene(parent);
        PackageInfoController c = loader.getController();
        c.selectedPackage(sr.getCheapPackage());
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
        /*Button b =(Button)actionEvent.getSource();
        String selected = b.getId();

        if (selected.equals(fxCheapInfo.toString())){
            packageInfoController.selectedPackage(cheapPackage);
        } else if (selected.equals(fxStandardInfo.toString())) {
            packageInfoController.selectedPackage(standardPackage);
        } else if (selected.equals(fxLuxuryInfo.toString())) {
            packageInfoController.selectedPackage(luxuryPackage);
        }*/
    }

    /**
     *
     * @param mouseEvent
     * @throws java.io.IOException
     */
    public void standInfoHandler(MouseEvent mouseEvent) throws java.io.IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PackageInfo.fxml"));
        Parent parent = loader.load();
        Scene tableViewScene = new Scene(parent);
        PackageInfoController c = loader.getController();
        c.selectedPackage(sr.getStandardPackage());
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    public void luxInfoHandler(MouseEvent mouseEvent) throws  java.io.IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PackageInfo.fxml"));
        Parent parent = loader.load();
        Scene tableViewScene = new Scene(parent);
        PackageInfoController c = loader.getController();
        c.selectedPackage(sr.getLuxuryPackage());
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    public void BackButtonClicked(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    /*
    public void closeMenu(MouseEvent actionEvent){
        System.exit(0);
    }*/
}