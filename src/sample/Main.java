package sample;

import javafx.application.Application;
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

        TourController t = new TourController();
        FlightSearchController f = new FlightSearchController();
        Searcher s = new Searcher(f,1,t);
        ObservableList<Flight> list = s.searchForFlights(new FlightFilter("REY","AEY",LocalDate.now(),LocalDate.now(),true));
        ObservableList<Hotel> list2 = s.searchForHotels(new HotelFilter());
        HotelDataFactory hfd = new HotelDataFactory();
        ObservableList<Hotel> hotels = HotelSearchController.getHotelSearchResults(hfd.getHotels(),
                "Reykjavík",LocalDate.of(2021,01,01),LocalDate.of(2021,02,01),
                1,1,true,true,true);
        TravelPackage tp = new TravelPackage(hotels.get(0),new Flight(),new Flight(),new Tour());
        launch(args);
    }

}
