package sample;

import Flight.FlightFilter;
import Flight.FlightSearchController;
import Hotel.HotelFilter;
import Tour.TourController;
import Tour.TourFilter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        String[] userInfo = getUserInfo();
        if (userInfo == null) return;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root =loader.load();
        primaryStage.setTitle("Trip planner");
        primaryStage.setResizable(false);
        Scene scene = new Scene(root, 941,702);

        primaryStage.setScene(scene);
        primaryStage.show();
        Controller c = loader.getController();
        c.newUser(userInfo[0],userInfo[1],userInfo[2]);
    }

    private String[] getUserInfo() throws java.io.IOException {
        FXMLLoader dLoader = new FXMLLoader (getClass().getResource("UserLogin.fxml"));
        dLoader.load();
        UserLoginController d1 = dLoader.getController();
        return d1.userInfo();
    }


    public static void main(String[] args) {
        Searcher searcher = new Searcher(new FlightSearchController(),new TourController());
        FlightFilter ff = new FlightFilter("REY","AEY",LocalDate.of(2021,01,01),LocalDate.of(2021,02,01),true,2);
        HotelFilter hf = new HotelFilter(LocalDate.of(2021,01,01),LocalDate.of(2021,02,01),"Akureyri",2,1,true,true,true);
        TourFilter tf = new TourFilter(LocalDate.of(2021,01,01),LocalDate.of(2021,02,01),"Akureyri",99999,"Action",1,99,2);
        searcher.searchForPackages(ff,hf,tf);
        launch(args);
    }

}
