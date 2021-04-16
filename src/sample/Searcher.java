package sample;

import Flight.*;
import Hotel.*;
import Tour.Tour;
import Tour.TourController;
import Tour.TourDataFactory;
import Tour.TourFilter;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class Searcher {
    DataFactory df = new DataFactory();
    HotelDatabaseManager hdf = new HotelDatabaseManager();
    FlightDataFactory fdf = new FlightDataFactory();
    TourDataFactory tdf = new TourDataFactory();
    FlightSearchController fsc;
    TourController ts;



    
    public Searcher(FlightSearchController flightSearchController,TourController tourSearcher) {
        ts = tourSearcher;
        fsc = flightSearchController;
        //TODO add equivalent flight and hotel searchers change arguments from int.
    }
    
    public ObservableList<Flight> searchForFlights(FlightFilter filter){
        return fsc.searchByAttribute(filter.getDepartureLocation(), filter.getArrivalLocation(), filter.getDepartureDate().toString(), filter.isMeal());
    }
    public ObservableList<Flight> searchForReturnFlights(FlightFilter filter){
        return fsc.searchByAttribute(filter.getArrivalLocation(), filter.getDepartureLocation(),filter.getReturnDate().toString(), filter.isMeal());
    }

    public ObservableList<Hotel> searchForHotels(HotelFilter filter){
        return HotelSearchController.getHotelSearchResults(hdf.getAllHotels(), filter.getLocation(),
                filter.getCheckIn(),filter.getCheckOut(),filter.getSelectedNumOfGuests(), filter.getSelectedNumOfRooms(),true,true,true);
    }

    public ObservableList<Tour> searchForTours(TourFilter filter) {
        ObservableList<Tour> tours = ts.tourRegionSearch(filter.getLocation());
        System.out.println(tours.size());
        for (int i = 0;i < tours.size();i++){
            tours.get(i).setTourDate(LocalDate.of(2021,01,02));
        }
        tours = ts.tourDateSearch(filter.getEarliestDate(),filter.getLatestDate(),tours);
        tours = ts.tourDurationSearch(filter.getMinDuration(), filter.getMaxDuration(), tours);
        tours = ts.tourServicesSearch(filter.getServices(),tours);
        return tours;
    }

    public SearchResults searchForPackages(FlightFilter ff, HotelFilter hf, TourFilter tf){
        ObservableList<Flight> flights = searchForFlights(ff);
        ObservableList<Flight> returnFlights = searchForReturnFlights(ff);
        ObservableList<Hotel> hotels = searchForHotels(hf);
        ObservableList<Tour> tours = searchForTours(tf);
        TravelPackageAssembler assembler = new TravelPackageAssembler(flights, returnFlights, hotels, tours,ff.getNumberOfPassengers(),hf.getSelectedNumOfRooms(),hf.getCheckIn(),hf.getCheckOut(),fdf);
        TravelPackage cheap = assembler.getCheapPackage();
        TravelPackage standard = assembler.getStandardPackage();
        TravelPackage luxury = assembler.getLuxuryPackage();

        return new SearchResults(flights, returnFlights, hotels, tours, cheap, standard, luxury);
    }
}
