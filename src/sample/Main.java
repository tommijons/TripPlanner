package sample;

import Flight.Flight;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("TravelPackages");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(false);
        Scene scene = new Scene(root, 941,702, Color.rgb(255, 52, 120));
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        FlightSearchController fsc = new FlightSearchController();
        ObservableList<Flight> flights = fsc.searchByAttribute("REY","AEY",LocalDate.of(2021,01,01).toString(),true);
        System.out.println(flights);
        launch(args);
    }

}
