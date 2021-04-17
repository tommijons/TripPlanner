package tripPackage;


import Flight.FlightDataFactory;
import Hotel.HotelDatabaseManager;
import Tour.Booking;
import Tour.Tour;
import Tour.TourDataFactory;
import Tour.TourUserController;
import javafx.application.Application;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


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
        launch(args);
    }

}
