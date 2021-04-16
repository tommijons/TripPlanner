package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.input.MouseEvent;

import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchResultsController extends CommonMethods implements Initializable {

    @FXML
    private Label fxDepDate;
    @FXML
    private Label fxRetDate;
    @FXML
    private Label fxHotel;
    @FXML
    private Label fxTour;
    @FXML
    private Label fxStDepDate;
    @FXML
    private Label fxStRetDate;
    @FXML
    private Label fxStHotel;
    @FXML
    private Label fxStTour;
    @FXML
    private Label fxLuxDepDate;
    @FXML
    private Label fxLuxRetDate;
    @FXML
    private Label fxLuxHotel;
    @FXML
    private Label fxLuxTour;
    @FXML
    private Label fxCheapPrice;
    @FXML
    private Label fxStPrice;
    @FXML
    private Label fxLuxPrice;

    private SearchResults sr;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        AppState app = AppState.getInstance();
        SearchResults searchR = app.getSearchResults();
        fxHotel.setText(searchR.getCheapPackage().getHotel().getHotel_name());
        fxTour.setText(searchR.getCheapPackage().getDaytrip().getTourName());
        fxDepDate.setText(searchR.getCheapPackage().getFlight().getFlightDate());
        fxRetDate.setText(searchR.getCheapPackage().getReturnFlight().getFlightDate());
        fxStHotel.setText(searchR.getStandardPackage().getHotel().getHotel_name());
        fxStTour.setText(searchR.getStandardPackage().getDaytrip().getTourName());
        fxStDepDate.setText(searchR.getStandardPackage().getFlight().getFlightDate());
        fxStRetDate.setText(searchR.getStandardPackage().getReturnFlight().getFlightDate());
        fxLuxHotel.setText(searchR.getLuxuryPackage().getHotel().getHotel_name());
        fxLuxTour.setText(searchR.getLuxuryPackage().getDaytrip().getTourName());
        fxLuxDepDate.setText(searchR.getLuxuryPackage().getFlight().getFlightDate());
        fxLuxRetDate.setText(searchR.getLuxuryPackage().getReturnFlight().getFlightDate());
        fxCheapPrice.setText(Integer.toString(searchR.getCheapPackage().getTotalPrice()));
        fxStPrice.setText(Integer.toString(searchR.getStandardPackage().getTotalPrice()));
        fxLuxPrice.setText(Integer.toString(searchR.getLuxuryPackage().getTotalPrice()));
    }

    /**
     * Birtir niðurstöðu leitar.
     * @param searchResults leitarniðurstöður
     */
    public void results(SearchResults searchResults) {
        sr = searchResults;
        AppState app = AppState.getInstance();
        SearchResults searchR = app.getSearchResults();
        fxHotel.setText(searchR.getCheapPackage().getHotel().getHotel_name());
        fxTour.setText(searchR.getCheapPackage().getDaytrip().getTourName());
        fxDepDate.setText(searchR.getCheapPackage().getFlight().getFlightDate());
        fxRetDate.setText(searchR.getCheapPackage().getReturnFlight().getFlightDate());
        fxStHotel.setText(searchR.getStandardPackage().getHotel().getHotel_name());
        fxStTour.setText(searchR.getStandardPackage().getDaytrip().getTourName());
        fxStDepDate.setText(searchR.getStandardPackage().getFlight().getFlightDate());
        fxStRetDate.setText(searchR.getStandardPackage().getReturnFlight().getFlightDate());
        fxLuxHotel.setText(searchR.getLuxuryPackage().getHotel().getHotel_name());
        fxLuxTour.setText(searchR.getLuxuryPackage().getDaytrip().getTourName());
        fxLuxDepDate.setText(searchR.getLuxuryPackage().getFlight().getFlightDate());
        fxLuxRetDate.setText(searchR.getLuxuryPackage().getReturnFlight().getFlightDate());
        fxCheapPrice.setText(Integer.toString(searchR.getCheapPackage().getTotalPrice()));
        fxStPrice.setText(Integer.toString(searchR.getStandardPackage().getTotalPrice()));
        fxLuxPrice.setText(Integer.toString(searchR.getLuxuryPackage().getTotalPrice()));
    }

    /**
     * Birtir nánari uppl um ódýra pakkann.
     * @param actionEvent
     * @throws java.io.IOException
     */
    @FXML
    private void cheapInfoHandler(MouseEvent actionEvent) throws java.io.IOException {
        AppState app = AppState.getInstance();
        SearchResults searchR = app.getSearchResults();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PackageInfo.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        PackageInfoController c = loader.getController();
        c.selectedPackage(searchR.getCheapPackage());
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    /**
     *
     * @param mouseEvent
     * @throws java.io.IOException
     */
    public void standInfoHandler(MouseEvent mouseEvent) throws java.io.IOException {
        AppState app = AppState.getInstance();
        SearchResults searchR = app.getSearchResults();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PackageInfo.fxml"));
        Parent parent = loader.load();
        Scene tableViewScene = new Scene(parent);
        PackageInfoController c = loader.getController();
        c.selectedPackage(searchR.getStandardPackage());
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    public void luxInfoHandler(MouseEvent mouseEvent) throws  java.io.IOException {
        AppState app = AppState.getInstance();
        SearchResults searchR = app.getSearchResults();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PackageInfo.fxml"));
        Parent parent = loader.load();
        Scene tableViewScene = new Scene(parent);
        PackageInfoController c = loader.getController();
        c.selectedPackage(searchR.getLuxuryPackage());
        Stage window = (Stage)((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    public void backHandler(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    /*
    public void closeMenu(MouseEvent actionEvent){
        System.exit(0);
    }*/
}