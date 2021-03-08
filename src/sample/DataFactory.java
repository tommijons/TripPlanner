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
        return flights;
    }
    public ArrayList<Hotel> getHotels(){
        ArrayList<Hotel> hotels = new ArrayList<>();
        return hotels;
    }
}
