package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Date;

public class DataFactory {
    public DataFactory(){
    }
    public ObservableList<TravelPackage> getTravelPackages(){
        ObservableList<TravelPackage> travelPackages = FXCollections.observableArrayList();
        return travelPackages;
    }
    public ArrayList<DayTrip> getDayTrips(){
        ArrayList<DayTrip> dayTrips = new ArrayList<>();
        DayTrip daytrip1 = new DayTrip("Grindavík","12032021", 1000,true,true,false, "www.erkomideldgos.is");
        DayTrip daytrip2 = new DayTrip("Vogar","14032021", 2000,true,true, false,"www.erkomideldgos.is");
        DayTrip daytrip3 = new DayTrip("Hafnarfjörður","16032021", 3000,false,false, true,"www.erkomideldgos.is");
        dayTrips.add(daytrip1);
        dayTrips.add(daytrip2);
        dayTrips.add(daytrip3);
        return dayTrips;
    }
    public ArrayList<Flight> getFlights(){
        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(new Flight("Reykjavík","Akureyri","02/03/21" , "12/03/21",  23900));
        flights.add(new Flight("Reykjavík","Ísafjörður","03/03/21" , "14/03/21",  22900));
        flights.add(new Flight("Akureyri","Reykjavík","12/03/21" , "17/03/21",  25900));
        return flights;
    }
    public ArrayList<Hotel> getHotels(){
        ArrayList<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel("Hótel Edda", "Akureyri", "www.edda.is", 4, 12000));
        hotels.add(new Hotel("Hótel Ísafjörður", "Ísafjörður", "www.hotelis.is", 3, 10000));
        hotels.add(new Hotel("Fosshótel", "Reykjavík", "fosshotel.is", 3, 12000));
        return hotels;
    }
}
