package sample;

import java.util.Date;

public class Searcher {

    public Flight[] searchForFlights(FlightFilter filter){
        //This is a dummy function
        //TODO Implement Real function
        return new Flight[0];
    }

    public Hotel[] searchForHotels(HotelFilter filter){
        //This is a dummy function
        //TODO Implement Real function
        return new Hotel[0];
    }

    public DayTrip[] searchForDayTrips(DayTripFilter filter){
        //This is a dummy function
        //TODO Implement Real function
        return new DayTrip[0];
    }

    public SearchResults searchForPackages(){
        FlightFilter ff = new FlightFilter(new Date());//TODO Get Information to construct filter
        Flight[] flights = searchForFlights(ff);
        HotelFilter hf = new HotelFilter();//TODO Get Information to construct filter
        Hotel[] hotels = searchForHotels(hf);
        DayTripFilter dtf = new DayTripFilter();//TODO Get Information to construct filter
        DayTrip[] daytrips = searchForDayTrips(dtf);
        TravelPackageAssembler assembler = new TravelPackageAssembler(flights, hotels, daytrips);
        TravelPackage cheap = assembler.getCheapPackage();
        TravelPackage standard = assembler.getStandardPackage();
        TravelPackage luxury = assembler.getLuxuryPackage();

        return new SearchResults(flights, hotels, daytrips, cheap, standard, luxury);
    }
}
