package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchResultsController extends CommonMethods implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private BorderPane fxPane;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        scene = new Scene(fxPane);
    }

    public void results() {
        Stage window = new Stage();
        window. setScene(scene);
        window.show();
    }

    public void BookingButtonClicked(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Booking.fxml"));
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void BackButtonClicked(MouseEvent mouseEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void closeMenu(MouseEvent actionEvent){
        System.exit(0);
    }
}
