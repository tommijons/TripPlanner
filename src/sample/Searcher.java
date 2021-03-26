package sample;

import javafx.collections.ObservableList;

import java.util.Date;

public class Searcher {
    DataFactory df = new DataFactory(); 
    //TODO remove Datafactory, replace with actual datasources
    TourSearchService ts;
    //FlightSearchService fs;
    //HotelSearchService hs;
    
    public Searcher(int FlightSearchService, int HotelSearchService, TourSearchService tourSearcher) {
        ts = tourSearcher;
        //TODO add equivalent flight and hotel searchers change arguments from int.
    }
    
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

    public ObservableList<Tour> searchForTours(TourFilter filter) {
        ObservableList<Tour> tours = ts.tours;
        tours = ts.tourServicesSearch(filter.getServices(), tours);
        tours = ts.tourDateSearch(filter.getEarliestDate(), filter.getLatestDate(), tours);
        tours = ts.tourRegionSearch(filter.getLocation(), tours);
        tours = ts.tourDurationSearch(filter.getMinDuration(), filter.getMaxDuration(), tours);
        for (Tour tour:tours) {
            if(filter.getMinSpots() > tour.getAvailableSpots()) {
                tours.remove(tour);
            }
            if(filter.getMaxPrice() < tour.getTourPrice()) {
                tours.remove(tour);
            }
        }
        return tours;
    }

    public SearchResults searchForPackages(){
        FlightFilter ff = new FlightFilter(new Date());//TODO Get Information to construct filter
        Flight[] flights = searchForFlights(ff);
        HotelFilter hf = new HotelFilter();//TODO Get Information to construct filter
        Hotel[] hotels = searchForHotels(hf);
        TourFilter dtf = new TourFilter();//TODO Get Information to construct filter
        ObservableList<Tour> tours = searchForTours(dtf);
        TravelPackageAssembler assembler = new TravelPackageAssembler(flights, hotels, tours);
        TravelPackage cheap = assembler.getCheapPackage();
        TravelPackage standard = assembler.getStandardPackage();
        TravelPackage luxury = assembler.getLuxuryPackage();

        return new SearchResults(flights, hotels, tours, cheap, standard, luxury);
    }
}
