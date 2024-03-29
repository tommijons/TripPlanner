package tripPackage;

import Flight.*;
import Hotel.*;
import Test.DataFactory;
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
    HotelSearchController hsc;
    TravelPackageController tpc;

    public Searcher(FlightSearchController flightSearchController,HotelSearchController hotelSearchController,TourController tourSearcher) {
        ts = tourSearcher;
        fsc = flightSearchController;
        hsc = hotelSearchController;
        tpc = new TravelPackageController();
        //TODO add equivalent flight and hotel searchers change arguments from int.
    }
    
    public ObservableList<Flight> searchForFlights(FlightFilter filter){
        return fsc.searchByAttribute(filter.getDepartureLocation(), filter.getArrivalLocation(), filter.getDepartureDate().toString(), filter.isMeal());
    }
    public ObservableList<Flight> searchForReturnFlights(FlightFilter filter){
        return fsc.searchByAttribute(filter.getArrivalLocation(), filter.getDepartureLocation(),filter.getReturnDate().toString(), filter.isMeal());
    }

    public ObservableList<Hotel> searchForHotels(HotelFilter filter){
        return hsc.getHotelSearchResults(filter.getLocation(),filter.getCheckIn(),filter.getCheckOut(),filter.getSelectedNumOfGuests(),filter.getSelectedNumOfRooms(),true,true,true);
    }

    public ObservableList<Tour> searchForTours(TourFilter filter) {
        ObservableList<Tour> tours = ts.tourRegionSearch(filter.getLocation());
       for (int i = 0;i < tours.size();i++){
            tours.get(i).setTourDate(LocalDate.of(2021,05,02));
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
        AppState state = AppState.getInstance();
        state.setHf(hf);
     //   TravelPackageAssembler assembler = new TravelPackageAssembler(flights, returnFlights, hotels, tours,ff.getNumberOfPassengers(),hf.getSelectedNumOfRooms(),hf.getCheckIn(),hf.getCheckOut(),fdf);
        TravelPackage cheap = tpc.createCheapPackage(hotels,flights, returnFlights,tours,ff.getNumberOfPassengers(),hf.getSelectedNumOfRooms(),hf.getCheckIn(),hf.getCheckOut(),fdf);
        TravelPackage standard = tpc.createStandardPackage(hotels,flights, returnFlights,tours,ff.getNumberOfPassengers(),hf.getSelectedNumOfRooms(),hf.getCheckIn(),hf.getCheckOut(),fdf);
        TravelPackage luxury = tpc.createLuxuryPackage(hotels,flights, returnFlights,tours,ff.getNumberOfPassengers(),hf.getSelectedNumOfRooms(),hf.getCheckIn(),hf.getCheckOut(),fdf);

        return new SearchResults(flights, returnFlights, hotels, tours, cheap, standard, luxury);
    }
}
