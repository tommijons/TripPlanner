package sample;

import javafx.collections.ObservableList;

public class TravelPackageController {
    public void changePackage(TravelPackage travelPackage, Flight flight, Flight returnFlight, Hotel hotel, Tour daytrip){
        travelPackage.setFlight(flight);
        travelPackage.setReturnFlight(returnFlight);
        travelPackage.setHotel(hotel);
        travelPackage.setDaytrip(daytrip);
    }

    public void changeFlight(TravelPackage travelPackage, Flight flight){
        travelPackage.setFlight(flight);
    }

    public void changeHotel(TravelPackage travelPackage, Hotel hotel){
        travelPackage.setHotel(hotel);
    }

    public void changeHotelRoom(TravelPackage travelPackage, Room hotelRoom){
        //TODO
    }

    public void changeDayTrip(TravelPackage travelPackage, Tour dayTrip){
        travelPackage.setDaytrip(dayTrip);
    }

    public TravelPackage createStandardPackage(ObservableList<Hotel> hotels, ObservableList<Flight> flights, ObservableList<Flight> returnFlights, ObservableList<Tour> tours){
        return new TravelPackage(hotels.get(Math.floorDiv(hotels.size(), 2)),
                flights.get(Math.floorDiv(flights.size(), 2)),
                returnFlights.get(Math.floorDiv(flights.size(), 2)),
                tours.get(Math.floorDiv(tours.size(), 2)));
    }

    public TravelPackage createCheapPackage(ObservableList<Hotel> hotels, ObservableList<Flight> flights,ObservableList<Flight> returnFlights, ObservableList<Tour> tours){
        return new TravelPackage(hotels.get(0), flights.get(0), returnFlights.get(0), tours.get(0));
    }

    public TravelPackage createLuxuryPackage(ObservableList<Hotel> hotels, ObservableList<Flight> flights,ObservableList<Flight> returnFlights, ObservableList<Tour> tours){
        return new TravelPackage(hotels.get(hotels.size()-1),
                flights.get(flights.size() - 1),
                returnFlights.get(flights.size() - 1),
                tours.get(tours.size() - 1));
    }
}
