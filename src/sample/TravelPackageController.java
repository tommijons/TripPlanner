package sample;

import javafx.collections.ObservableList;

public class TravelPackageController {
    private FlightDataFactory flightDataFactory;
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

    public TravelPackage createStandardPackage(ObservableList<Hotel> hotels, ObservableList<Flight> flights, ObservableList<Flight> returnFlights, ObservableList<Tour> tours,FlightDataFactory fdf){
        Hotel hotel = hotels.get(1);
        Flight flightOut = flights.get(0);
        Flight flightHome = returnFlights.get(0);
        Tour tour = new Tour();
       /* for (int i = 0; i < hotels.size();i++){
            if (hotels.get(i).getHotel_star_rating() == Hotel.StarRating.FOUR){
                hotel = hotels.get(i).getHotel();
                break;
            }
        }
        for (int i = 0; i < flights.size();i++){
            for (int j = 0;j<fdf.getSeats(flights.get(i).getId()).size(); j++) {
                if (fdf.getSeats(flights.get(i).getId()).get(j).isAvailable()){
                    flightOut = flights.get(i);
                }
            }
        }
        for (int i = 0; i < returnFlights.size();i++){
            for (int j = 0;j<fdf.getSeats(returnFlights.get(i).getId()).size(); j++) {
                if (fdf.getSeats(returnFlights.get(i).getId()).get(j).isAvailable()){
                    flightOut = returnFlights.get(i);
                }
            }
        }
        TravelPackage tp = new TravelPackage(hotel,flightOut,flightHome,tour);*/
        return new TravelPackage(hotel,flightOut,flightHome,tour);
    }

    public TravelPackage createCheapPackage(ObservableList<Hotel> hotels, ObservableList<Flight> flights,ObservableList<Flight> returnFlights, ObservableList<Tour> tours,FlightDataFactory fdf){
        Hotel hotel = hotels.get(0);
        Flight flightOut = flights.get(0);
        Flight flightHome = returnFlights.get(0);
        Tour tour = tours.get(0);
    /*    for (int i = 0; i < hotels.size();i++){
            if (hotels.get(i).getHotel_star_rating() == Hotel.StarRating.THREE){
                hotel = hotels.get(i).getHotel();
                break;
            }
        }
        for (int i = 0; i < flights.size();i++){
            for (int j = 0;j<fdf.getSeats(flights.get(i).getId()).size(); j++) {
                if (!fdf.getSeats(flights.get(i).getId()).get(j).isFirstClass() && fdf.getSeats(flights.get(i).getId()).get(j).isAvailable()){
                    flightOut = flights.get(i);
                }
            }
        }
        for (int i = 0; i < returnFlights.size();i++){
            for (int j = 0;j<fdf.getSeats(returnFlights.get(i).getId()).size(); j++) {
                if (!fdf.getSeats(returnFlights.get(i).getId()).get(j).isFirstClass() && fdf.getSeats(returnFlights.get(i).getId()).get(j).isAvailable()){
                    flightOut = returnFlights.get(i);
                }
            }
        }*/
        return new TravelPackage(hotel,flightOut,flightHome,tour);
    }

    public TravelPackage createLuxuryPackage(ObservableList<Hotel> hotels, ObservableList<Flight> flights,ObservableList<Flight> returnFlights, ObservableList<Tour> tours,FlightDataFactory fdf){
        Hotel hotel = hotels.get(1);
        Flight flightOut = flights.get(0);
        Flight flightHome = returnFlights.get(0);
        Tour tour = new Tour();
        System.out.println(hotel);
        System.out.println(flights);
        System.out.println(returnFlights);
       for (int i = 0; i < hotels.size();i++){
            if (hotels.get(i).getHotel_star_rating() == Hotel.StarRating.FIVE){
                hotel = hotels.get(i);
                break;
            }
        }/*
        for (int i = 0; i < flights.size();i++){
            for (int j = 0;j<fdf.getSeats(flights.get(i).getId()).size(); j++) {
                if (fdf.getSeats(flights.get(i).getId()).get(j).isFirstClass() && fdf.getSeats(flights.get(i).getId()).get(j).isAvailable()){
                    flightOut = flights.get(i);
                }
            }
        }
        for (int i = 0; i < returnFlights.size();i++){
            for (int j = 0;j<fdf.getSeats(returnFlights.get(i).getId()).size(); j++) {
                if (fdf.getSeats(returnFlights.get(i).getId()).get(j).isFirstClass() && fdf.getSeats(returnFlights.get(i).getId()).get(j).isAvailable()){
                    flightHome = returnFlights.get(i);
                }
            }
        }*/
        return new TravelPackage(hotel,flightOut,flightHome,tour);
    }
}
