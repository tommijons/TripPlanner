package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;

public class TourSearchController {

    private final TourDataFactory dataFactory = new TourDataFactory();
    public ObservableList<Tour> tourList = FXCollections.observableArrayList();
    ObservableList<String> Departure_LocationsList = FXCollections.observableArrayList("","REY","EGS","AEY","IFJ","VEY","KEF");
    ObservableList<String> Arrival_LocationsList = FXCollections.observableArrayList("","REY","EGS","AEY","IFJ","VEY","KEF");



    /**
     * Leitar af flugi eftir attributum
     * @param departureLocation brottfararstaður, departureLocation = null ef ekki á að leita eftir
     * @param arrivalLocation komustaður, arrivalLocation = null ef ekki á að leita eftir
     * @param tourDate dagsetning (ár-mánuður-dagur), tourDate = null ef ekki á að leita eftir
     * @param meal máltíð í flugi eða ekki, meal = null ef ekki á að leita eftir
     * @return listi af flugum
     */

    public ObservableList<Tour> searchByAttribute(String departureLocation, String arrivalLocation, String tourDate, Boolean meal) {
        String dep = departureLocation == null || departureLocation.equals("") ? "%" : departureLocation;
        String arr = arrivalLocation == null || arrivalLocation.equals("") ? "%" : arrivalLocation;
        String date = tourDate == null || tourDate.equals("") ? "%" : tourDate;

        return dataFactory.getTours(dep, arr, date, meal);
    }



    public static void main(String[] args) {
        TourSearchController searcher = new TourSearchController();

        // Dæmi um að leita eftir flugum frá Reykjavík
        ObservableList<Tour> searchedTours = searcher.searchByAttribute("REY", null, null, null);
        // Prenta útkomu
        for(Tour tour: searchedTours) {
            System.out.println(tour);
        }
    }

}

