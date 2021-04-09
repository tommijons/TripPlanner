package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import static javafx.fxml.FXMLLoader.load;

public class TourSearchController implements Initializable {
    @FXML
    private ListView<Tour> tourListView;
    @FXML
    private TextArea infoOnTourTextArea;
    @FXML
    private Date dateFrom, dateTo;
    @FXML
    private Button buttonFindTour,buttonBookTour, buttonAdministrator,buttonCancel;
    @FXML
    private TextField cancelBookingID;
    @FXML
    private TextField showFilterTextField;
    @FXML
    private DatePicker startDatePicker;
    @FXML
    private DatePicker endDatePicker;
    @FXML
    private SplitMenuButton regionSplitMenuButton;
    @FXML
    private SplitMenuButton durationSplitMenuButton;
    @FXML
    private SplitMenuButton servicesSplitMenuButton;
    @FXML
    private MenuItem filterAllRegions;
    @FXML
    private MenuItem filterAkureyriRegion;
    @FXML
    private MenuItem filterEgilsstadirRegion;
    @FXML
    private MenuItem filterReykjavikRegion;
    @FXML
    private MenuItem filterIsafjordurRegion;
    @FXML
    private MenuItem filterAllDurations;
    @FXML
    private MenuItem filterToThreeHours;
    @FXML
    private MenuItem filterThreeToFiveHours;
    @FXML
    private MenuItem filterFiveToSevenHours;
    @FXML
    private MenuItem filterFullDay;
    @FXML
    private MenuItem filterAllServices;
    @FXML
    private MenuItem filterServicesWheelchairAccessible;
    @FXML
    private MenuItem filterServicesFamilyFriendly;
    @FXML
    private MenuItem filterServicesAction;


    private TourDataFactory tourdataFactory = new TourDataFactory();
    private ObservableList<Tour> allTours = FXCollections.observableArrayList(tourdataFactory.getTours());
    TourController filteredTours = new TourController();
    ObservableList<Tour> filteredListRegion = FXCollections.observableArrayList();
    ObservableList<Tour> filteredListDuration = FXCollections.observableArrayList();
    ObservableList<Tour> filteredListServices = FXCollections.observableArrayList();


    public void openBookingInformation(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("bookingInfo.fxml"));
        Parent tourSearchParent = loader.load();

        Scene tableViewScene = new Scene(tourSearchParent);

        //access the controller and call a method
        BookingInfoController controller = loader.getController();
        controller.initData(tourListView.getSelectionModel().getSelectedItem());

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void buttonFindTourOnAction(ActionEvent actionEvent) {
        LocalDate valueStart = startDatePicker.getValue();
        LocalDate valueEnd = endDatePicker.getValue();
        TourController filteredTours = new TourController();
        ObservableList filteredList = filteredTours.tourDateSearch(valueStart, valueEnd, allTours);
        tourListView.setItems(filteredList);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        filterAllRegions.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                filteredListDuration.clear();
                filteredListServices.clear();
                showFilterTextField.setText("All tours");
                tourListView.setItems(allTours);
                }
            });

        filterAkureyriRegion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!filteredListDuration.isEmpty()){
                    filteredListRegion = filteredTours.tourRegionSearch("Akureyri", filteredListDuration);
                    filteredListDuration.clear();
                }
                else if (!filteredListServices.isEmpty()) {
                    filteredListRegion = filteredTours.tourRegionSearch("Akureyri", filteredListServices);
                    filteredListServices.clear();
                }
                else if (!filteredListDuration.isEmpty()  && !filteredListServices.isEmpty()) {
                    ObservableList<Tour> concat = FXCollections.concat(filteredListDuration, filteredListServices);
                    filteredListRegion = filteredTours.tourRegionSearch("Akureyri", concat);
                    filteredListDuration.clear();
                    filteredListServices.clear();
                }
                else {
                    filteredListRegion = filteredTours.tourRegionSearch("Akureyri", allTours);
                }

                showFilterTextField.setText("Akureyri");
                tourListView.setItems(filteredListRegion);
            }
        });

        filterEgilsstadirRegion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!filteredListDuration.isEmpty()){
                    filteredListRegion = filteredTours.tourRegionSearch("Egilsstaðir", filteredListDuration);
                    filteredListDuration.clear();
                }
                else if (!filteredListServices.isEmpty()) {
                    filteredListRegion = filteredTours.tourRegionSearch("Egilsstaðir", filteredListServices);
                    filteredListServices.clear();
                }
                else if (!filteredListDuration.isEmpty()  && !filteredListServices.isEmpty()) {
                    ObservableList<Tour> concat = FXCollections.concat(filteredListDuration, filteredListServices);
                    filteredListRegion = filteredTours.tourRegionSearch("Egilsstaðir", concat);
                    filteredListDuration.clear();
                    filteredListServices.clear();
                }
                else {
                    filteredListRegion = filteredTours.tourRegionSearch("Egilsstaðir", allTours);
                }

                showFilterTextField.setText("Egilsstaðir");
                tourListView.setItems(filteredListRegion);
            }
        });

        filterReykjavikRegion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!filteredListDuration.isEmpty()){
                    filteredListRegion = filteredTours.tourRegionSearch("Reykjavík", filteredListDuration);
                    filteredListDuration.clear();
                }
                else if (!filteredListServices.isEmpty()) {
                    filteredListRegion = filteredTours.tourRegionSearch("Reykjavík", filteredListServices);
                    filteredListServices.clear();
                }
                else if (!filteredListDuration.isEmpty()  && !filteredListServices.isEmpty()) {
                    ObservableList<Tour> concat = FXCollections.concat(filteredListDuration, filteredListServices);
                    filteredListRegion = filteredTours.tourRegionSearch("Reykjavík", concat);
                    filteredListDuration.clear();
                    filteredListServices.clear();
                }
                else {
                    filteredListRegion = filteredTours.tourRegionSearch("Reykjavík", allTours);
                }

                showFilterTextField.setText("Reykjavík");
                tourListView.setItems(filteredListRegion);
            }
        });

        filterIsafjordurRegion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!filteredListDuration.isEmpty()){
                    filteredListRegion = filteredTours.tourRegionSearch("Ísafjörður", filteredListDuration);
                    filteredListDuration.clear();
                }
                else if (!filteredListServices.isEmpty()) {
                    filteredListRegion = filteredTours.tourRegionSearch("Ísafjörður", filteredListServices);
                    filteredListServices.clear();
                }
                else if (!filteredListDuration.isEmpty()  && !filteredListServices.isEmpty()) {
                    ObservableList<Tour> concat = FXCollections.concat(filteredListDuration, filteredListServices);
                    filteredListRegion = filteredTours.tourRegionSearch("Ísafjörður", concat);
                    filteredListDuration.clear();
                    filteredListServices.clear();
                }
                else {
                    filteredListRegion = filteredTours.tourRegionSearch("Ísafjörður", allTours);
                }

                showFilterTextField.setText("Ísafjörður");
                tourListView.setItems(filteredListRegion);
            }
        });

        filterAllDurations.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                filteredListRegion.clear();
                filteredListServices.clear();
                showFilterTextField.setText("All tours");
                tourListView.setItems(allTours);
            }
        });

        filterToThreeHours.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!filteredListRegion.isEmpty()){
                    filteredListDuration = filteredTours.tourDurationSearch(0, 3, filteredListRegion);
                    filteredListRegion.clear();
                }
                else if (!filteredListServices.isEmpty()) {
                    filteredListDuration = filteredTours.tourDurationSearch(0, 3, filteredListServices);
                    filteredListServices.clear();
                }
                else if (!filteredListRegion.isEmpty()  && !filteredListServices.isEmpty()) {
                    ObservableList<Tour> concat = FXCollections.concat(filteredListRegion, filteredListServices);
                    filteredListDuration = filteredTours.tourDurationSearch(0,3, concat);
                    filteredListRegion.clear();
                    filteredListServices.clear();
                }
                else {
                    filteredListDuration = filteredTours.tourDurationSearch(0,3, allTours);
                }
                showFilterTextField.setText("3 hours or less");
                tourListView.setItems(filteredListDuration);
            }
        });

        filterThreeToFiveHours.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!filteredListRegion.isEmpty()){
                    filteredListDuration = filteredTours.tourDurationSearch(3, 5, filteredListRegion);
                    filteredListRegion.clear();
                }
                else if (!filteredListServices.isEmpty()) {
                    filteredListDuration = filteredTours.tourDurationSearch(3, 5, filteredListServices);
                    filteredListServices.clear();
                }
                else if (!filteredListRegion.isEmpty()  && !filteredListServices.isEmpty()) {
                    ObservableList<Tour> concat = FXCollections.concat(filteredListRegion, filteredListServices);
                    filteredListDuration = filteredTours.tourDurationSearch(3,5, concat);
                    filteredListRegion.clear();
                    filteredListServices.clear();
                }
                else {
                    filteredListDuration = filteredTours.tourDurationSearch(3,5, allTours);
                }
                showFilterTextField.setText("3 to 5 hours");
                tourListView.setItems(filteredListDuration);
            }
        });

        filterFiveToSevenHours.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!filteredListRegion.isEmpty()){
                    filteredListDuration = filteredTours.tourDurationSearch(5, 7, filteredListRegion);
                    filteredListRegion.clear();
                }
                else if (!filteredListServices.isEmpty()) {
                    filteredListDuration = filteredTours.tourDurationSearch(5, 7, filteredListServices);
                    filteredListServices.clear();
                }
                else if (!filteredListRegion.isEmpty()  && !filteredListServices.isEmpty()) {
                    ObservableList<Tour> concat = FXCollections.concat(filteredListRegion, filteredListServices);
                    filteredListDuration = filteredTours.tourDurationSearch(5,7, concat);
                    filteredListRegion.clear();
                    filteredListServices.clear();
                }
                else {
                    filteredListDuration = filteredTours.tourDurationSearch(5,7, allTours);
                }
                showFilterTextField.setText("5 to 7 hours");
                tourListView.setItems(filteredListDuration);
            }
        });
        filterFullDay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!filteredListRegion.isEmpty()){
                    filteredListDuration = filteredTours.tourDurationSearch(7, 24, filteredListRegion);
                    filteredListRegion.clear();
                }
                else if (!filteredListServices.isEmpty()) {
                    filteredListDuration = filteredTours.tourDurationSearch(7, 24, filteredListServices);
                    filteredListServices.clear();
                }
                else if (!filteredListRegion.isEmpty()  && !filteredListServices.isEmpty()) {
                    ObservableList<Tour> concat = FXCollections.concat(filteredListRegion, filteredListServices);
                    filteredListDuration = filteredTours.tourDurationSearch(7,24, concat);
                    filteredListRegion.clear();
                    filteredListServices.clear();
                }
                else {
                    filteredListDuration = filteredTours.tourDurationSearch(7,24, allTours);
                }
                showFilterTextField.setText("Full day (7+ hours)");
                tourListView.setItems(filteredListDuration);
            }
        });

        filterAllServices.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                filteredListRegion.clear();
                filteredListDuration.clear();
                showFilterTextField.setText("All tours");
                tourListView.setItems(allTours);
            }
        });

        filterServicesWheelchairAccessible.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (!filteredListRegion.isEmpty()){
                    filteredListServices = filteredTours.tourServicesSearch("Wheelchair accessible", filteredListRegion);
                    filteredListRegion.clear();
                }
                else if (!filteredListDuration.isEmpty()) {
                    filteredListServices = filteredTours.tourServicesSearch("Wheelchair accessible", filteredListDuration);
                    filteredListDuration.clear();
                }
                else if (!filteredListRegion.isEmpty()  && !filteredListDuration.isEmpty()) {
                    ObservableList<Tour> concat = FXCollections.concat(filteredListRegion, filteredListDuration);
                    filteredListServices = filteredTours.tourServicesSearch("Wheelchair Accessible", concat);
                    filteredListRegion.clear();
                    filteredListDuration.clear();
                }
                else {
                    filteredListServices = filteredTours.tourServicesSearch("Wheelchair Accessible", filteredListRegion);
                }
                showFilterTextField.setText("Wheelchair accessible");
                tourListView.setItems(filteredListServices);
            }
        });
        filterServicesFamilyFriendly.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!filteredListRegion.isEmpty()){
                    filteredListServices = filteredTours.tourServicesSearch("Family friendly", filteredListRegion);
                    filteredListRegion.clear();

                }
                else if (!filteredListDuration.isEmpty()) {
                    filteredListServices = filteredTours.tourServicesSearch("Family friendly", filteredListDuration);
                    filteredListDuration.clear();
                }
                else if (!filteredListRegion.isEmpty()  && !filteredListDuration.isEmpty()) {
                    ObservableList<Tour> concat = FXCollections.concat(filteredListRegion, filteredListDuration);
                    filteredListServices = filteredTours.tourServicesSearch("Family friendly", concat);
                    filteredListRegion.clear();
                    filteredListDuration.clear();
                }
                else {
                    filteredListServices = filteredTours.tourServicesSearch("Family friendly", filteredListRegion);
                }
                showFilterTextField.setText("Family friendly");
                tourListView.setItems(filteredListServices);
            }
        });
        filterServicesAction.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!filteredListRegion.isEmpty()){
                    filteredListServices = filteredTours.tourServicesSearch("Action", filteredListRegion);
                }
                else if (!filteredListDuration.isEmpty()) {
                    filteredListServices = filteredTours.tourServicesSearch("Action", filteredListDuration);
                }
                else if (!filteredListRegion.isEmpty()  && !filteredListDuration.isEmpty()) {
                    ObservableList<Tour> concat = FXCollections.concat(filteredListRegion, filteredListDuration);
                    filteredListServices = filteredTours.tourServicesSearch("Action", concat);
                }
                else {
                    filteredListServices = filteredTours.tourServicesSearch("Action", filteredListRegion);
                }
                showFilterTextField.setText("Action & adventure");
                tourListView.setItems(filteredListServices);
            }
        });

        tourListView.setItems(allTours);

/*
        tourListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(tourListView.isFocused()){
                String info = String.format(newValue.getTourName() + "\n" + "\n" +
                        newValue.getTourInfo() + "\n" + "\n" + "Tour Date: " + newValue.getTourDate() + "\n" + "\n" + "Tour Price: " + newValue.getTourPrice() + " ISK");
                infoOnTourTextArea.setText(info);
            }
        });




        tourListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {
                        infoOnTourTextArea.setText(new_val);
                        label.setTextFill(Color.web(new_val));
                    }
                });
*/

        tourListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tour>() {
            @Override
            public void changed(ObservableValue<? extends Tour> observable, Tour oldValue, Tour newValue) {
                infoOnTourTextArea.setText(newValue.getTourName() + "\n" + "\n" +
                        newValue.getTourInfo() + "\n" + "\n" + "Tour Date: " +
                        newValue.getTourDate() + "\n" + "\n" + "Tour Price: " +
                        newValue.getTourPrice() + " ISK");
            }
        });
    }


    public void addButtonOnActivity(ActionEvent actionEvent) {
        System.out.println("halló");
    }


    public void buttonAdministratorOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("adminLogin.fxml"));
        Parent searchPanel = loader.load();
        Scene tableViewScene = new Scene(searchPanel);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    public void buttonCancelOnAction(ActionEvent actionEvent) {
        TourBookingController bookingController= new TourBookingController();
        String bookingId= cancelBookingID.getText();
        int id;
        try {
            id = Integer.parseInt(bookingId);
        }
        catch (NumberFormatException e)
        {
            id = 0;
        }
        bookingController.deleteBooking(id);

    }

    public void buttonSearchOnAction(ActionEvent actionEvent) {

    }
}
