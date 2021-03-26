package sample;

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
    public void changeHotelRoom(TravelPackage travelPackage, Room hotelRoom){
        //TODO
    }
    public void changeDayTrip(TravelPackage travelPackage, Tour dayTrip){
        travelPackage.setDaytrip(dayTrip);
    }
    public TravelPackage createStandardPackage(Hotel[] hotels, Flight[] flights, Tour[] dayTrips){
        return new TravelPackage(hotels[Math.floorDiv(hotels.length, 2)],
                flights[Math.floorDiv(flights.length, 2)],
                dayTrips[Math.floorDiv(dayTrips.length, 2)]);
    }
    public TravelPackage createCheapPackage(Hotel[] hotels, Flight[] flights, Tour[] dayTrips){
        return new TravelPackage(hotels[0], flights[0], dayTrips[0]);
    }
    public TravelPackage createLuxuryPackage(Hotel[] hotels, Flight[] flights, Tour[] dayTrips){
        return new TravelPackage(hotels[hotels.length - 1],
                flights[flights.length - 1],
                dayTrips[dayTrips.length - 1]);
    }

}
