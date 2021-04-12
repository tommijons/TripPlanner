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
        Flight flight1 = new Flight();
        Flight flight2 = new Flight();
        Hotel hotel = new Hotel();
        Tour tour = new Tour();
        TravelPackage tp = new TravelPackage(hotel,flight1,flight2,tour);
       // System.out.println(tp);
        TourController t = new TourController();
        FlightSearchController f = new FlightSearchController();
        Searcher s = new Searcher(f,1,t);
        ObservableList<Flight> list = s.searchForFlights(new FlightFilter("REY","awer",LocalDate.now(),LocalDate.now(),true));
        ObservableList<Hotel> list2 = s.searchForHotels(new HotelFilter());
        ObservableList<Tour> list3 = s.searchForTours(new TourFilter());
       // System.out.println(list);
        for(int i = 0; i < list2.size();i++) {
            System.out.println(list2.get(i).getHotel_star_rating());
        }
        //System.out.println(list3);
        FlightFilter filter = new FlightFilter("REY", "AEY",LocalDate.of(2021,01,01),LocalDate.of(2021,01,01),true);
       // System.out.println("lala: " + f.searchByAttribute(filter.getDepartureLocation(), filter.getArrivalLocation(), filter.getDepartureDate().toString(), filter.isMeal()));
        launch(args);
    }

}
