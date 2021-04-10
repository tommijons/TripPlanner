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
        HotelFilter filter = new HotelFilter(LocalDate.now().plus(3,ChronoUnit.DAYS),LocalDate.now().plus(6,ChronoUnit.DAYS),
                "Akureyri",1,
                1,true,true,true);
        HotelDataFactory hdf = new HotelDataFactory();
        ObservableList<Hotel> list =  HotelSearchController.getHotelSearchResults(hdf.getHotels(),filter.getLocation(),
                filter.getCheckIn(), filter.getCheckOut(),
                filter.getSelectedNumOfGuests(),filter.getSelectedNumOfRooms(),
                filter.isThreeStar(), filter.isFourStar(), filter.isThreeStar());
        System.out.println(list);
        FlightSearchController fsc = new FlightSearchController();
        ObservableList<Flight> flist = fsc.searchByAttribute("REY", "AEY", LocalDate.of(2021,01,01).toString(), true);
        System.out.println(flist.get(0).getAirline());
        System.out.print(LocalDate.of(2021,01,01).toString());
        launch(args);
    }

}
