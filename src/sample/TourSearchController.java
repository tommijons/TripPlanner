package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;

import java.time.LocalDate;
public class TourSearchController {

    //frá 5D
    private TourDataFactory dataFactory = new TourDataFactory();
    private ObservableList<Tour> allTours = FXCollections.observableArrayList(tourdataFactory.getTours());
                                 //new TourController???
    TourSearchController filteredTours = new TourSearchController();
    ObservableList<Tour> filteredListRegion = FXCollections.observableArrayList();
    ObservableList<Tour> filteredListDuration = FXCollections.observableArrayList();
    ObservableList<Tour> filteredListServices = FXCollections.observableArrayList();


    //private final TourDataFactory dataFactory = new TourDataFactory();
    //public ObservableList<Tour> tourList = FXCollections.observableArrayList();
    //ObservableList<String> RegionList = FXCollections.observableArrayList(/*eitthvað regions list?"","REY","EGS","AEY","IFJ","VEY","KEF"*/);
    //ObservableList<String> ServiceList = FXCollections.observableArrayList(/*eitthvað service list?"","REY","EGS","AEY","IFJ","VEY","KEF"*/);


    /**
     * Leitar að tour eftir attributum
     * @param region
     * @param duration1 min duration
     * @param duration2 max duration
     * @param service service???
     * @param startDate tourDate verður að vera eftir startDate
     * @param endDate tourDate verður að vera á undan endDate
     * @return listi af tours
     */

    public ObservableList<Tour> searchByAttribute(String region, int duration1, int duration2, String service, LocalDate startDate, LocalDate endDate) {

        //???
        //ég get ekki látið int eða localdate vera "%"...
        //ég nota null í staðinn.
        String reg = region == null || region.equals("") ? null : region;
        String d1 = duration1 == null ? null : duration1;
        String d2 = duration2 == null ? null : duration2;
        String ser = service == null || service.equals("") ? null : service;
        String sdat = startDate == null ? null : startDate;
        String edat = endDate == null ? null : endDate;


        return dataFactory.getTours(reg, d1, d2, ser, sdat, edat);
    }



    public static void main(String[] args) {
        TourSearchController searcher = new TourSearchController();

        // Dæmi um að leita eftir flugum frá Reykjavík
        ObservableList<Tour> searchedTours = searcher.searchByAttribute("REY", null, null, null);
        // Prenta útkomu
        for(Tour tour: searchedTours) {
            System.out.println(tour);}
    }

}

