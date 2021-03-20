package sample;

public class TravelPackageController {
    public void changePackage(TravelPackage travelPackage, Flight flight, Hotel hotel, DayTrip daytrip){
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
    public void changeDayTrip(TravelPackage travelPackage, DayTrip dayTrip){
        travelPackage.setDaytrip(dayTrip);
    }
    public void createPackages(Flight[] flights, Hotel[] hotels, DayTrip[] dayTrips){
        //TODO
    }
    public void createCheaperPackages(){
        //TODO
    }
}
