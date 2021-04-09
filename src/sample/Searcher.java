package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.Date;

public class Searcher {
    DataFactory df = new DataFactory();
    HotelDataFactory hdf = new HotelDataFactory();
    FlightDataFactory fdf = new FlightDataFactory();
    FlightSearchController fsc;
    //TODO remove Datafactory, replace with actual datasources
    TourSearchService ts;
    //FlightSearchService fs;
    
    public Searcher(FlightSearchController flightSearchController , int HotelSearchService, TourSearchService tourSearcher) {
        ts = tourSearcher;
        fsc = flightSearchController;
        //TODO add equivalent flight and hotel searchers change arguments from int.
    }
    
    public ObservableList<Flight> searchForFlights(FlightFilter filter){
        ObservableList<Flight> flights = fsc.flightList;
        flights = fsc.searchByAttribute(filter.getDepartureLocation(),filter.getArrivalLocation(), filter.getFlightDate(), filter.getMeal());

        //TODO Implement Real function
        return flights;
    }
    public ObservableList<Flight> searchForReturnFlights(FlightFilter filter){
        ObservableList<Flight> returnFlights = fsc.flightList;
        returnFlights = fsc.searchByAttribute(filter.getDepartureLocation(),filter.getArrivalLocation(), filter.getFlightDate(), filter.getMeal());

        //TODO Implement Real function
        return returnFlights;
    }

    public ObservableList<Hotel> searchForHotels(HotelFilter filter){
        //This is a dummy function
        //TODO Implement Real function
        return HotelSearchController.getHotelSearchResults(hdf.getHotels(), filter.getLocation(),
                filter.getCheckIn(), filter.getCheckOut(),
        filter.getMinBeds(),filter.getMinSize(),
                filter.isThreeStar(), filter.isFourStar(), filter.isThreeStar());
    }

    public ObservableList<Tour> searchForTours(TourFilter filter) {
        ObservableList<Tour> tours = ts.tours;
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
        return tours;
    }

    public SearchResults searchForPackages(){
        FlightFilter ff = new FlightFilter();//TODO Get Information to construct filter
        ObservableList<Flight> flights = searchForFlights(ff);
        FlightFilter rff = new FlightFilter();//TODO Get Information to construct filter
        ObservableList<Flight> returnFlights = searchForFlights(ff);
        HotelFilter hf = new HotelFilter();
        ObservableList<Hotel> hotels = searchForHotels(hf);
        TourFilter dtf = new TourFilter();//TODO Get Information to construct filter
        ObservableList<Tour> tours = searchForTours(dtf);
        TravelPackageAssembler assembler = new TravelPackageAssembler(flights, returnFlights, hotels, tours);
        TravelPackage cheap = assembler.getCheapPackage();
        TravelPackage standard = assembler.getStandardPackage();
        TravelPackage luxury = assembler.getLuxuryPackage();

        return new SearchResults(flights, returnFlights, hotels, tours, cheap, standard, luxury);
    }
}
