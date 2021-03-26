package sample;

import javafx.collections.ObservableList;

public class TravelPackageController {
    public void changePackage(TravelPackage travelPackage, Flight flight, Hotel hotel, Tour daytrip){
        travelPackage.setFlight(flight);
        travelPackage.setHotel(hotel);
        travelPackage.setDaytrip(daytrip);
    }
    public void changeFlight(TravelPackage travelPackage, Flight flight){
        travelPackage.setFlight(flight);
    }
    public void changeHotel(TravelPackage travelPackage, Hotel hotel){
        travelPackage.setHotel(hotel);
    }
    public void changeHotelRoom(TravelPackage travelPackage, HotelRoom hotelRoom){
        //TODO
    }
    public void changeDayTrip(TravelPackage travelPackage, Tour dayTrip){
        travelPackage.setDaytrip(dayTrip);
    }
    public TravelPackage createStandardPackage(Hotel[] hotels, Flight[] flights, ObservableList<Tour> tours){
        return new TravelPackage(hotels[Math.floorDiv(hotels.length, 2)],
                flights[Math.floorDiv(flights.length, 2)],
                tours.get(Math.floorDiv(tours.size(), 2)));
    }
    public TravelPackage createCheapPackage(Hotel[] hotels, Flight[] flights, ObservableList<Tour> tours){
        return new TravelPackage(hotels[0], flights[0], tours.get(0));
    }
    public TravelPackage createLuxuryPackage(Hotel[] hotels, Flight[] flights, ObservableList<Tour> tours){
        return new TravelPackage(hotels[hotels.length - 1],
                flights[flights.length - 1],
                tours.get(tours.size() - 1));
    }

}
