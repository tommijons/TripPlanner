package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Searcher {
    DataFactory df = new DataFactory();
    HotelDataFactory hdf = new HotelDataFactory();
    FlightDataFactory fdf = new FlightDataFactory();
    TourDataFactory tdf = new TourDataFactory();
    FlightSearchController fsc;
    TourController ts;



    
    public Searcher(FlightSearchController flightSearchController , int HotelSearchService, TourController tourSearcher) {
        ts = tourSearcher;
        fsc = flightSearchController;
        //TODO add equivalent flight and hotel searchers change arguments from int.
    }

    public ObservableList<Flight> searchForFlights(FlightFilter filter){
        return fsc.searchByAttribute(filter.getDepartureLocation(),filter.getArrivalLocation(), filter.getDepartureDate().toString(), filter.isMeal());
    }
    public ObservableList<Flight> searchForReturnFlights(FlightFilter filter){
        return fsc.searchByAttribute(filter.getArrivalLocation(), filter.getDepartureLocation(), filter.getReturnDate().toString(), filter.isMeal());
    }

    public ObservableList<Hotel> searchForHotels(HotelFilter filter){
        return HotelSearchController.getHotelSearchResults(hdf.getHotels(), "Akureyri",
                LocalDate.now().plus(3,ChronoUnit.DAYS), LocalDate.now().plus(6,ChronoUnit.DAYS),
                1,1,
                true, true, true);
    }

    public ObservableList<Tour> searchForTours(TourFilter filter) {
     /*   ObservableList<Tour> tours = ts.tours;
        tours = ts.tourServicesSearch(filter.getServices(), tours);
        tours = ts.tourDateSearch(filter.getEarliestDate(), filter.getLatestDate(), tours);
        tours = ts.tourRegionSearch(filter.getLocation(), tours);
        tours = ts.tourDurationSearch(filter.getMinDuration(), filter.getMaxDuration(), tours);
        ObservableList<Tour> removeTours = FXCollections.observableArrayList();
        for (Tour tour:tours) {
            if(filter.getMinSpots() > tour.getAvailableSpots()) {
                removeTours.add(tour);
            } else if(filter.getMaxPrice() < tour.getTourPrice()) {
                removeTours.add(tour);
            }
        }

        for (Tour tour:removeTours) {
            if(filter.getMinSpots() > tour.getAvailableSpots()) {
                tours.remove(tour);
            } else if(filter.getMaxPrice() < tour.getTourPrice()) {
                tours.remove(tour);
            }
        }
        return tours;*/
     /*   ObservableList<Tour> tours = ts.tourRegionSearch(filter.getLocation());FXCollections.observableArrayList();
        tours = ts.tourDateSearch(filter.getEarliestDate(),filter.getLatestDate(),tours);
        tours = ts.tourDurationSearch(filter.getMinDuration(), filter.getMaxDuration(), tours);
        tours = ts.tourServicesSearch(filter.getServices(),tours);
        return tours;*/
        ObservableList<Tour> tours = FXCollections.observableArrayList();
        tours.add(new Tour("Buggy Tour in Rauðhólar","Children must be under parent supervision",
                LocalDate.now(),20,20000, "Reykjavík",5, "Action"));
        return tours;
    }

    public SearchResults searchForPackages(FlightFilter ff, HotelFilter hf, TourFilter tf){
        ObservableList<Flight> flights = searchForFlights(ff);
        ObservableList<Flight> returnFlights = searchForReturnFlights(ff);
        ObservableList<Hotel> hotels = searchForHotels(hf);
        ObservableList<Tour> tours = searchForTours(tf);
        System.out.println(flights.size());
        System.out.println(returnFlights.size());
        System.out.println(hotels.size());
        System.out.println(tours.size());
        TravelPackageAssembler assembler = new TravelPackageAssembler(flights, returnFlights, hotels, tours, fdf);
        TravelPackage cheap = assembler.getCheapPackage();
        TravelPackage standard = assembler.getStandardPackage();
        TravelPackage luxury = assembler.getLuxuryPackage();

        return new SearchResults(flights, returnFlights, hotels, tours, cheap, standard, luxury);
    }
}
