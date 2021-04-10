package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
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
        return fsc.searchByAttribute("REY","AEY", LocalDate.of(2021,01,01).toString(), filter.getMeal());
    }
    public ObservableList<Flight> searchForReturnFlights(FlightFilter filter){
        return fsc.searchByAttribute("AEY", "REY",LocalDate.of(2021,01,01).toString(), filter.getMeal());
    }

    public ObservableList<Hotel> searchForHotels(HotelFilter filter){
        return HotelSearchController.getHotelSearchResults(hdf.getHotels(), filter.getLocation(),
                filter.getCheckIn(), filter.getCheckOut(),
                filter.getSelectedNumOfGuests(),filter.getSelectedNumOfRooms(),
                filter.isThreeStar(), filter.isFourStar(), filter.isThreeStar());
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
        ObservableList<Flight> returnFlights = searchForFlights(ff);
        ObservableList<Hotel> hotels = searchForHotels(hf);
        ObservableList<Tour> tours = searchForTours(tf);
        TravelPackageAssembler assembler = new TravelPackageAssembler(flights, returnFlights, hotels, tours);
        TravelPackage cheap = assembler.getCheapPackage();
        TravelPackage standard = assembler.getStandardPackage();
        TravelPackage luxury = assembler.getLuxuryPackage();

        return new SearchResults(flights, returnFlights, hotels, tours, cheap, standard, luxury);
    }
}
