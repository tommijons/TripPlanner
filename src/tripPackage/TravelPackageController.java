package tripPackage;
import Flight.*;
import Hotel.*;
import Tour.Tour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class TravelPackageController {
    private FlightDataFactory fdf = new FlightDataFactory();
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


    public TravelPackage createStandardPackage(ObservableList<Hotel> hotels, ObservableList<Flight> flights, ObservableList<Flight> returnFlights, ObservableList<Tour> tours, int travellers, int rooms, LocalDate checkIn,LocalDate checkOut, FlightDataFactory fdf){
        HotelSearchController hsc = new HotelSearchController();
        Hotel hotel = new Hotel();
        Flight flightOut = flights.get(0);
        Flight flightHome = returnFlights.get(0);
        Tour tour = tours.get(0);
        ObservableList<Seat> seatsOut = fdf.getSeats(flights.get(0).getId());
        ObservableList<Seat> seatsHome = fdf.getSeats(returnFlights.get(0).getId());
        ObservableList<Seat> chosenSeatsOut = FXCollections.observableArrayList();
        ObservableList<Seat> chosenSeatsHome = FXCollections.observableArrayList();

        for (int i = 0;i < seatsOut.size();i++){
            if (seatsOut.get(i).isAvailable() && !seatsOut.get(i).isFirstClass()){
                chosenSeatsOut.add(seatsOut.get(i));
                if (chosenSeatsOut.size() == travellers){
                    break;
                }
            }
        }
        if (chosenSeatsOut.size() != travellers){
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0;i < seatsHome.size();i++){
            if (seatsHome.get(i).isAvailable() && !seatsOut.get(i).isFirstClass()){
                chosenSeatsHome.add(seatsHome.get(i));
                if (chosenSeatsHome.size() == travellers){
                    break;
                }
            }
        }
        if (chosenSeatsHome.size() != travellers){
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < hotels.size();i++){
            if (hotels.get(i).getHotel_star_rating() == Hotel.StarRating.FOUR){
                hotel = hotels.get(i);
                break;
            }
        }
        if (hotel.getHotel_name() == "No hotel"){
            ObservableList<Room> noRooms = FXCollections.observableArrayList();
            return new TravelPackage(new Hotel(),new Flight(), new Flight(),new Tour(),seatsOut,seatsHome,noRooms);
        }
        ObservableList<Room> availableRooms = hsc.filterRooms(hotel,checkIn,checkOut,travellers,rooms);
        ObservableList<Room> chosenRoom = FXCollections.observableArrayList();
        for (int i = 0; i < rooms;i++){
            chosenRoom.add(availableRooms.get(i));
        }

        return new TravelPackage(hotel,flightOut,flightHome,tour,chosenSeatsOut,chosenSeatsHome,chosenRoom);
    }

    public TravelPackage createCheapPackage(ObservableList<Hotel> hotels, ObservableList<Flight> flights, ObservableList<Flight> returnFlights, ObservableList<Tour> tours,int travellers, int rooms,LocalDate checkIn,LocalDate checkOut, FlightDataFactory fdf){
        Hotel hotel = new Hotel();
        Flight flightOut = flights.get(0);
        Flight flightHome = returnFlights.get(0);
        Tour tour = new Tour();
        int cheapestTour = 999999;
        for (int i = 0; i < tours.size(); i++){
            if (tours.get(i).getTourPrice() < cheapestTour){
                tour= tours.get(i);
                cheapestTour = tours.get(i).getTourPrice();
            }
        }
        ObservableList<Seat> seatsOut = fdf.getSeats(flights.get(0).getId());
        ObservableList<Seat> seatsHome = fdf.getSeats(returnFlights.get(0).getId());
        ObservableList<Seat> chosenSeatsOut = FXCollections.observableArrayList();
        ObservableList<Seat> chosenSeatsHome = FXCollections.observableArrayList();
        for (int i = 0;i < seatsOut.size();i++){
            if (seatsOut.get(i).isAvailable() && !seatsOut.get(i).isFirstClass()){
                chosenSeatsOut.add(seatsOut.get(i));
                if (chosenSeatsOut.size() == travellers){
                    break;
                }
            }
        }
        if (chosenSeatsOut.size() != travellers){
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0;i < seatsHome.size();i++){
            if (seatsHome.get(i).isAvailable() && !seatsOut.get(i).isFirstClass()){
                chosenSeatsHome.add(seatsHome.get(i));
                if (chosenSeatsHome.size() == travellers){
                    break;
                }
            }
        }
        if (chosenSeatsHome.size() != travellers){
            throw new IndexOutOfBoundsException();
        }
       for (int i = 0; i < hotels.size();i++){
            if (hotels.get(i).getHotel_star_rating() == Hotel.StarRating.THREE){
                hotel = hotels.get(i);
                break;
            }
        }
        if (hotel.getHotel_name() == "No hotel"){
            ObservableList<Room> noRooms = FXCollections.observableArrayList();
            return new TravelPackage(new Hotel(),new Flight(), new Flight(),new Tour(),seatsOut,seatsHome,noRooms);
        }
        ObservableList<Room> availableRooms = HotelSearchController.filterRooms(hotel,checkIn,checkOut,travellers,rooms);
        ObservableList<Room> chosenRoom = FXCollections.observableArrayList();
        for (int i = 0; i < rooms;i++){
            chosenRoom.add(availableRooms.get(i));
        }
        return new TravelPackage(hotel,flightOut,flightHome,tour,chosenSeatsOut,chosenSeatsHome,chosenRoom);
    }

    public TravelPackage createLuxuryPackage(ObservableList<Hotel> hotels, ObservableList<Flight> flights, ObservableList<Flight> returnFlights, ObservableList<Tour> tours,int travellers, int rooms,LocalDate checkIn,LocalDate checkOut, FlightDataFactory fdf){
        Hotel hotel = new Hotel();
        Flight flightOut = flights.get(0);
        Flight flightHome = returnFlights.get(0);
        ObservableList<Seat> seatsOut = fdf.getSeats(flights.get(0).getId());
        ObservableList<Seat> seatsHome = fdf.getSeats(returnFlights.get(0).getId());
        ObservableList<Seat> chosenSeatsOut = FXCollections.observableArrayList();
        ObservableList<Seat> chosenSeatsHome = FXCollections.observableArrayList();
        Tour tour = new Tour();
        int expensiveTour = -1;
        for (int i = 0; i < tours.size(); i++){
            if (tours.get(i).getTourPrice() > expensiveTour){
                tour= tours.get(i);
                expensiveTour = tours.get(i).getTourPrice();
            }
        }
        for (int i = 0;i < seatsOut.size();i++){
            if (seatsOut.get(i).isAvailable() && seatsOut.get(i).isFirstClass()){
                chosenSeatsOut.add(seatsOut.get(i));
                if (chosenSeatsOut.size() == travellers){
                    break;
                }
            }
        }
        if (chosenSeatsOut.size() != travellers){
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0;i < seatsHome.size();i++){
            if (seatsHome.get(i).isAvailable() && seatsHome.get(i).isFirstClass()){
                chosenSeatsHome.add(seatsHome.get(i));
                if (chosenSeatsHome.size() == travellers){
                    break;
                }
            }
        }
        if (chosenSeatsHome.size() != travellers){
            throw new IndexOutOfBoundsException();
        }
       for (int i = 0; i < hotels.size();i++){
            if (hotels.get(i).getHotel_star_rating() == Hotel.StarRating.FIVE){
                hotel = hotels.get(i);
                break;
            }
        }
        if (hotel.getHotel_name() == "No hotel"){
            ObservableList<Room> noRooms = FXCollections.observableArrayList();
            return new TravelPackage(new Hotel(),new Flight(), new Flight(),new Tour(),seatsOut,seatsHome,noRooms);
        }
        ObservableList<Room> availableRooms = HotelSearchController.filterRooms(hotel,checkIn,checkOut,travellers,rooms);
        ObservableList<Room> chosenRoom = FXCollections.observableArrayList();
        for (int i = 0; i < rooms;i++){
            chosenRoom.add(availableRooms.get(i));
        }
        return new TravelPackage(hotel,flightOut,flightHome,tour,chosenSeatsOut,chosenSeatsHome,chosenRoom);
    }
}
