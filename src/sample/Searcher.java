package sample;

import java.util.Date;

public class Searcher {
    DataFactory df = new DataFactory();
    public Flight[] searchForFlights(FlightFilter filter){
        //This is a dummy function
        //TODO Implement Real function
        return df.getFlights().toArray(new Flight[0]);
    }

    public Hotel[] searchForHotels(HotelFilter filter){
        //This is a dummy function
        //TODO Implement Real function
        return df.getHotels().toArray(new Hotel[0]);
    }

    public Tour[] searchForDayTrips(TourFilter filter){
        //This is a dummy function
        //TODO Implement Real function
        return df.getTours().toArray(new Tour[0]);
    }

    public SearchResults searchForPackages(){
        FlightFilter ff = new FlightFilter(new Date());//TODO Get Information to construct filter
        Flight[] flights = searchForFlights(ff);
        HotelFilter hf = new HotelFilter();//TODO Get Information to construct filter
        Hotel[] hotels = searchForHotels(hf);
        TourFilter dtf = new TourFilter();//TODO Get Information to construct filter
        Tour[] dayTrips = searchForDayTrips(dtf);
        TravelPackageAssembler assembler = new TravelPackageAssembler(flights, hotels, dayTrips);
        TravelPackage cheap = assembler.getCheapPackage();
        TravelPackage standard = assembler.getStandardPackage();
        TravelPackage luxury = assembler.getLuxuryPackage();

        return new SearchResults(flights, hotels, dayTrips, cheap, standard, luxury);
    }
}
