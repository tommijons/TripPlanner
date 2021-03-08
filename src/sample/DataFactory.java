package sample;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Date;

public class DataFactory {
    public DataFactory(){
    }
    public ArrayList<DayTrip> getDayTrips(){
        ArrayList<DayTrip> dayTrips = new ArrayList<>();
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
