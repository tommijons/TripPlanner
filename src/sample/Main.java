package sample;


import Flight.Booking;
import Flight.FlightDataFactory;
import Hotel.HotelDatabaseManager;
import Tour.TourDataFactory;
import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
        User user = new User(userInfo[0],userInfo[1],userInfo[2]);
        AppState state = AppState.getInstance();
        state.setUser(user);
        User user1 = state.getUser();
    }

    private String[] getUserInfo() throws java.io.IOException {
        FXMLLoader dLoader = new FXMLLoader (getClass().getResource("UserLogin.fxml"));
        dLoader.load();
        UserLoginController d1 = dLoader.getController();
        return d1.userInfo();
    }


    public static void main(String[] args) {
      /*  HotelDatabaseManager hdm = new HotelDatabaseManager();
        System.out.println("hdmusers: " + hdm.getUsers());
        FlightDataFactory fdf = new FlightDataFactory();
        ObservableList<User> users = FXCollections.observableArrayList();
        users.addAll(fdf.getUsers("test@email.com"));
        ObservableList<Booking> bookings = FXCollections.observableArrayList();
        bookings.addAll(fdf.getBookings("test@email.com"));
        for(int i = 0; i < users.size();i++){
            System.out.println(bookings.get(i));
            System.out.println(users.get(i));
        }

        TourDataFactory tdf = new TourDataFactory();
        System.out.println("tdfbookings: "+tdf.getBookings());
        System.out.println("tdfusers: "+tdf.getUsers());*/
        launch(args);
    }

}
