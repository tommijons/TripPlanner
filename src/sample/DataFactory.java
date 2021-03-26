package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import static sample.Room.RoomAmmenities;
import static sample.Room.RoomAmmenities.*;
import static sample.Room.RoomCategory.*;

public class DataFactory {
    public ArrayList<Room> all_rooms = this.createRooms();
    public DataFactory(){
    }
    public ObservableList<TravelPackage> getTravelPackages(){
        ObservableList<TravelPackage> travelPackages = FXCollections.observableArrayList();
        ObservableList<Tour> tours = getTours();
        ArrayList<Flight> flights = getFlights();
        ArrayList<Hotel> hotels = getHotels();
        TravelPackage travelPackage1 = new TravelPackage(hotels.get(0),flights.get(0),tours.get(0));
        TravelPackage travelPackage2 = new TravelPackage(hotels.get(1),flights.get(1),tours.get(1));
        TravelPackage travelPackage3 = new TravelPackage(hotels.get(2),flights.get(2),tours.get(2));
        travelPackages.add(travelPackage1);
        travelPackages.add(travelPackage2);
        travelPackages.add(travelPackage3);
        return travelPackages;
    }
    public ObservableList<Tour> getTours(){
        ObservableList<Tour> tours = FXCollections.observableArrayList();

        LocalDate d1 = LocalDate.of(2021,4,1);
        LocalDate d2 = LocalDate.of(2021,4,5);
        LocalDate d3 = LocalDate.of(2021,5,11);
        LocalDate d4 = LocalDate.of(2021,5,21);
        LocalDate d5 = LocalDate.of(2021,6,4);
        LocalDate d6 = LocalDate.of(2021,6,16);
        LocalDate d7 = LocalDate.of(2021,7,10);
        LocalDate d8 = LocalDate.of(2021,7,11);
        LocalDate d9 = LocalDate.of(2021,8,7);
        LocalDate d10 = LocalDate.of(2021,8,24);


        Tour tour1 = (new Tour( "Horseriding in Eyjafjörður","Bring warm clothes",d1, 10,10000,
                "Akureyri",7,"Family friendly"));
        tour1.setTourID(1);
        tours.add(tour1);
        Tour tour2= (new Tour( "Buggy Tour in Rauðhólar","Children must be under parent supervision",
                d2,20,20000, "Reykjavík",5, "Action"));
        tour2.setTourID(2);
        tours.add(tour2);
        Tour tour3=(new Tour( "Kajaking in Lagarfljót","Bring warm clothes, you could get wet.",d3,10,15000,
                "Egilsstaðir", 3, "Family friendly"));
        tour3.setTourID(3);
        tours.add(tour3);
        Tour tour4=(new Tour( "Walk around Skaftafell","Bring warm clothes and packed lunch.",d4,50,20000,
                "Reykjavík", 15, "Family friendly"));
        tour4.setTourID(4);
        tours.add(tour4);
        Tour tour5=(new Tour( "Diving in Silfra","Bring dry clothes.",d5,25,18000,
                "Reykjavík", 6, "Action"));
        tour5.setTourID(5);
        tours.add(tour5);
        Tour tour6=(new Tour( "Snowmobil trip","Bring warm clothes.",d6,15,25000,
                "Ísafjörður", 6, "Action"));
        tour6.setTourID(6);
        tours.add(tour6);
        Tour tour7 = (new Tour( "Walk around Reykjavík","Come dressed according to weather.",d7, 25,7000,
                "Reykjavík",2, "Wheelchair accessible"));
        tour1.setTourID(7);
        tours.add(tour7);
        Tour tour8 = (new Tour( "Biking around Þingvellir","Bring warm clothes. Bikes are available for rent.",d8, 15,10000,
                "Reykjavík",8, "Family friendly"));
        tour1.setTourID(8);
        tours.add(tour8);
        Tour tour9 = (new Tour( "Skiing in Hlíðarfjall","Skiing accuipment is available for rent",d9, 20,15000,
                "Akureyri",5, "Action"));
        tour1.setTourID(9);
        tours.add(tour9);

        return tours;
    }

    public ArrayList<Flight> getFlights(){
        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(new Flight("Reykjavík","Akureyri","02/03/21" , "12/03/21",  23900));
        flights.add(new Flight("Reykjavík","Ísafjörður","03/03/21" , "14/03/21",  22900));
        flights.add(new Flight("Akureyri","Reykjavík","12/03/21" , "17/03/21",  25900));
        return flights;
    }
    public ArrayList<Hotel> getHotels() {
        // Get all rooms!!
        ArrayList<ArrayList<Room>> all_rooms = getRooms();

        // Listinn af ollum hotelunum okkar
        ArrayList<Hotel> hotels = new ArrayList();

        // Hotel Reykjavik
        boolean[] h_amenities1 = {false, false, false};
        hotels.add(new Hotel(1, "Hotel Edda Reykjavik", "Reykjavík", 5550000,
                2, h_amenities1, all_rooms.get(0), 3, 10000));

        // Hotel Reykjavik
        boolean[] h_amenities2 = {false, false, false};
        hotels.add(new Hotel(2, "Hotel Icelandair Reykjavik", "Reykjavík", 5550001,
                4, h_amenities2, all_rooms.get(0), 3, 10000));

        // Hotel Egilstaðir
        boolean[] h_amenities3 = {false, false, false};
        hotels.add(new Hotel(3, "Hotel Edda Egilstadir", "Egilsstaðir", 4550000,
                1, h_amenities3, all_rooms.get(0), 3, 10000));
        return hotels;

    }
    ArrayList<LocalDate> room_occupancy_setup = new ArrayList<>();

    public ArrayList<Room> createRooms() {
        ArrayList<Room> all_rooms = new ArrayList<>();

        all_rooms.add(new Room(1, SINGLE, 1.5, new RoomAmmenities[]{TV, BALCONY}, room_occupancy_setup, 1, 2));
        all_rooms.add(new Room(2, DOUBLE, 1.5, new RoomAmmenities[]{TV, OCEAN_VIEW}, room_occupancy_setup, 2,2));
        all_rooms.add(new Room(3, FAMILY, 1.5, new RoomAmmenities[]{TV, BALCONY}, room_occupancy_setup, 1,1));

        return all_rooms;
    }

    public ArrayList<Room> getRoomsByHotelId(int hotel_id) {
        ArrayList<Room> filtered_rooms = new ArrayList<Room>();

        for (Room room : this.all_rooms) {
            if (room.getHotel_id() == hotel_id) {
                filtered_rooms.add(room);
            }
        }

        return filtered_rooms;
    }
    public ArrayList<ArrayList<Room>> getRooms() {

        // Listi af listum af herbergjum
        ArrayList<ArrayList<Room>> all_rooms = new ArrayList<>();

        // Listi númer 1 af herbergjum
        ArrayList<Room> rooms_for_hotel_1 = new ArrayList<>();
        // Eitt eintak af herbergi
        boolean[] r_amenities1 = {false, false, false};
        rooms_for_hotel_1.add(new Room(1, SINGLE, 1.5, new RoomAmmenities[]{TV, BALCONY}, room_occupancy_setup, 2,2));

        // Annad eintak af herbergi
        boolean[] r_amenities2 = {false, false, false};
        rooms_for_hotel_1.add(new Room(2, SINGLE, 2.5, new RoomAmmenities[]{TV, BALCONY}, room_occupancy_setup, 1,2));

        // Thridja eintak af herbergi
        boolean[] r_amenities3 = {false, false, false};
        rooms_for_hotel_1.add(new Room(3, SINGLE, 2.5, new RoomAmmenities[]{TV, BALCONY}, room_occupancy_setup, 0,1));

        // Setjum oll herbergi fyrir hotel 1 inn i adallistann
        all_rooms.add(rooms_for_hotel_1);
        return all_rooms;
    }

}
}
