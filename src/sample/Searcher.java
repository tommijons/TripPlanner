package sample;

import Flight.Flight;
import javafx.collections.ObservableList;

public class Searcher {
    DataFactory df = new DataFactory();
    HotelDataFactory hdf = new HotelDataFactory();
    FlightDataFactory fdf = new FlightDataFactory();
    TourDataFactory tdf = new TourDataFactory();
    FlightSearchController fsc;
    TourController ts;



    
    public Searcher(FlightSearchController flightSearchController, TourController tourSearcher) {
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
    //    ObservableList<Hotel> hotels = FXCollections.observableArrayList();
     //   hotels.add(new Hotel(1,"economy", filter.getLocation(), "strætisgata1",105,4254141,Hotel.StarRating.THREE,new Hotel.HotelAmenities[]{BREAKFAST_INCLUDED, PARKING},hdf.getRoomsByHotelId(1),2,10000));
     //   hotels.add(new Hotel(1,"first class", filter.getLocation(), "strætisgata1",105,4254141,Hotel.StarRating.FOUR,new Hotel.HotelAmenities[]{BREAKFAST_INCLUDED, PARKING},hdf.getRoomsByHotelId(1),2,10000));
      //  hotels.add(new Hotel(1,"luxury", filter.getLocation(), "strætisgata1",105,4254141,Hotel.StarRating.FIVE,new Hotel.HotelAmenities[]{BREAKFAST_INCLUDED, PARKING},hdf.getRoomsByHotelId(1),2,10000));
        return HotelSearchController.getHotelSearchResults(hdf.getHotels(), filter.getLocation(),
                filter.getCheckIn(),filter.getCheckOut(),filter.getSelectedNumOfGuests(), filter.getSelectedNumOfRooms(),true,true,true);
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
        ObservableList<Tour> tours = ts.tourRegionSearch(filter.getLocation());
        tours = ts.tourDateSearch(filter.getEarliestDate(),filter.getLatestDate(),tours);
        tours = ts.tourDurationSearch(filter.getMinDuration(), filter.getMaxDuration(), tours);
        tours = ts.tourServicesSearch(filter.getServices(),tours);
        return tours;/*
        ObservableList<Tour> tours = FXCollections.observableArrayList();
        tours.add(new Tour("Buggy Tour in Rauðhólar","Children must be under parent supervision",
                LocalDate.now(),20,20000, "Reykjavík",5, "Action"));
        return tours;*/
    }

    public SearchResults searchForPackages(FlightFilter ff, HotelFilter hf, TourFilter tf){
        ObservableList<Flight> flights = searchForFlights(ff);
        ObservableList<Flight> returnFlights = searchForReturnFlights(ff);
        ObservableList<Hotel> hotels = searchForHotels(hf);
        ObservableList<Tour> tours = searchForTours(tf);
        TravelPackageAssembler assembler = new TravelPackageAssembler(flights, returnFlights, hotels, tours, fdf);
        TravelPackage cheap = assembler.getCheapPackage();
        TravelPackage standard = assembler.getStandardPackage();
        TravelPackage luxury = assembler.getLuxuryPackage();

        return new SearchResults(flights, returnFlights, hotels, tours, cheap, standard, luxury);
    }
}
