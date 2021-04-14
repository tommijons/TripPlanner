package Hotel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import static Hotel.Hotel.HotelAmenities.*;
import static Hotel.Hotel.StarRating.*;
import static Hotel.Room.RoomAmenities.*;
import static Hotel.Room.RoomCategory.*;

public class HotelDataFactory {
    // Create all rooms
    public ArrayList<Room> all_rooms = this.createRooms();

    public HotelDataFactory() {
    }
/**
    public ObservableList<User> getUsers() {
        ObservableList<User> users = FXCollections.observableArrayList();
        User user1 = new User(1, "KalliBjarna", "password", 8889999, "kb@hi.is", "kallastræti 7");
        User user2 = new User(2, "Veddi", "myPasswrd", 9990000, "vsg@hi.is", "Háalind 24");
        User user3 = new User(3, "SollaSæta", "12345", 1009999, "solla@hi.is", "Hástræti 94");
        User user4 = new User(4, "Helga Björk", "egerhelga", 4443333, "helga@hotmail.com", "Reynimel 4");
        User user5 = new User(5, "Stjáni Blái", "PWmitt", 5665665, "stjanarinn@yahoo.com", "Laugateig 67");
        User user6 = new User(6, "Gísli Súrsson", "utlaginn", 8965665, "gislisursson@gmail.com", "Sæból 1");


        // Test filter
        ArrayList<Room> hotel_one_rooms = getRoomsByHotelId(1);

        for (Room room : hotel_one_rooms) {
            System.out.println(room.getRoom_id());
        }


        // Get all hotels
        ArrayList<Hotel> hotels = getHotels();

        // Get all rooms
        ArrayList<Room> rooms = getRooms();

        // Booking for user1
        ArrayList<Booking> booking1 = new ArrayList<>();

        ArrayList<Room> booking_room_list1 = new ArrayList<>();
        // Get the rooms for this user and add them to a list for that one user
        booking_room_list1.add(rooms.get(0));
        booking1.add(new Booking(1, hotels.get(0), user1, LocalDate.of(2021, 4, 2),
                LocalDate.of(2021, 4, 3), booking_room_list1, 2, false));
        // end of booking for user1
        users.addAll(user1, user2, user3, user4, user5, user6);
        return users;
    }**/

    public ObservableList<String> getLocation() {
        ObservableList<String> locations = FXCollections.observableArrayList();
        locations.add("Reykjavík");
        locations.add("Akureyri");
        locations.add("Egilsstaðir");
        locations.add("Ísafjörður");

        return locations;
    }

    // , int hotel_type, int hotel_base_price
    public ArrayList<Hotel> getHotels() {
        // Get all rooms!!
        ArrayList<Room> all_rooms = getRooms();

        // Listinn af ollum hotelunum okkar
        ArrayList<Hotel> hotels = new ArrayList();

        // Hotel Reykjavik
        hotels.add(new Hotel(1, "Economy Hotel Reykjavik", "Reykjavík", "Þórunnartún 1", 105, 5550000,
                THREE, new Hotel.HotelAmenities[]{BREAKFAST_INCLUDED, PARKING}, getRoomsByHotelId(1), 1, 10000));

        // Hotel Reykjavik
        hotels.add(new Hotel(2, "Comfort Hotel Reykjavik", "Reykjavík", "Mýrargata 2", 102, 5550001,
                FOUR, new Hotel.HotelAmenities[]{SPA, FREE_WIFI}, getRoomsByHotelId(2), 2, 10000));

        // Hotel Egilstaðir
        hotels.add(new Hotel(3, "Economy Hotel Egilstadir", "Egilsstaðir", "Lyngás 5-7", 700, 4550000,
                THREE, new Hotel.HotelAmenities[]{BREAKFAST_INCLUDED, HANDICAP_ACCESSIBLE}, getRoomsByHotelId(3), 1, 10000));

        // Hotel Egilstaðir
        hotels.add(new Hotel(4, "Comfort Hotel Egilstadir", "Egilsstaðir", "Kaupvangur 17", 700, 4550001,
                FIVE, new Hotel.HotelAmenities[]{RESTAURANT, SPA, PARKING}, getRoomsByHotelId(4), 2, 10000));

        // Hotel Akureyri
        hotels.add(new Hotel(5, "Economy Hotel Akureyri", "Akureyri", "Þingvallastræti 23", 600, 4560000,
                THREE, new Hotel.HotelAmenities[]{FREE_WIFI}, getRoomsByHotelId(5), 1, 10000));

        // Hotel Akureyri
        hotels.add(new Hotel(6, "Comfort Hotel Akureyri", "Akureyri", "Hafnarstræti 67", 600, 4560001,
                FOUR, new Hotel.HotelAmenities[]{RESTAURANT, PARKING, FREE_WIFI}, getRoomsByHotelId(6), 2, 10000));

        // Hotel Ísafjörður
        hotels.add(new Hotel(7, "Economy Hotel Isafjordur", "Ísafjörður", "Silfurtorgi 2", 400, 4500000,
                THREE, new Hotel.HotelAmenities[]{BREAKFAST_INCLUDED, PARKING}, getRoomsByHotelId(7), 1, 10000));

        // Hotel Ísafjörður
        hotels.add(new Hotel(8, "Comfort Hotel Isafjordur", "Ísafjörður", "Mánagata 3", 400, 4500001,
                FIVE, new Hotel.HotelAmenities[]{SPA, PARKING, HANDICAP_ACCESSIBLE, FREE_WIFI}, getRoomsByHotelId(8), 2, 10000));

        // Hotel Reykjavik
        hotels.add(new Hotel(9, "Luxury Hotel Reykjavik", "Reykjavík", "Mýrargata 7", 102, 5550002,
                FIVE, new Hotel.HotelAmenities[]{PARKING, HANDICAP_ACCESSIBLE,SPA, FREE_WIFI}, getRoomsByHotelId(9), 2, 10000));

        // Hotel Egilstaðir
        hotels.add(new Hotel(10, "Basic Hotel Egilstadir", "Egilsstaðir", "Lyngás 6-9", 700, 4550003,
                FOUR, new Hotel.HotelAmenities[]{BREAKFAST_INCLUDED, HANDICAP_ACCESSIBLE}, getRoomsByHotelId(10), 1, 10000));

        // Hotel Akureyri
        hotels.add(new Hotel(11, "Luxury Hotel Akureyri", "Akureyri", "Þingvallastræti 420", 600, 4560003,
                FIVE, new Hotel.HotelAmenities[]{FREE_WIFI}, getRoomsByHotelId(11), 1, 10000));

        // Hotel Ísafjörður
        hotels.add(new Hotel(12, "Standard Hotel Isafjordur", "Ísafjörður", "Silfurtorgi 11", 400, 4500003,
                FOUR, new Hotel.HotelAmenities[]{BREAKFAST_INCLUDED, PARKING}, getRoomsByHotelId(12), 1, 10000));

        return hotels;

    }

    //ArrayList<LocalDate> room_occupancy_setup = new ArrayList<>();

    public ArrayList<Room> createRooms() {
        ArrayList<Room> all_rooms = new ArrayList<>();
        ArrayList<LocalDate> room_occupancy_setup = new ArrayList<>();
        ArrayList<ArrayList<LocalDate>> room_occupancy = new ArrayList<>();
        ArrayList<LocalDate> room_occupancy_user_one = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        room_occupancy_user_one.add(today);
        room_occupancy_user_one.add(tomorrow);
        room_occupancy.add(room_occupancy_user_one);

        // Economy Hotel Reykjavík
        all_rooms.add(new Room(1, SINGLE, 1.5, new Room.RoomAmenities[]{TV}, room_occupancy, 1, SINGLE));
        all_rooms.add(new Room(2, DOUBLE, 1.5, new Room.RoomAmenities[]{TV, REFRIGERATOR}, room_occupancy, 1, DOUBLE));
        all_rooms.add(new Room(3, FAMILY, 1.5, new Room.RoomAmenities[]{TV, REFRIGERATOR, BALCONY}, room_occupancy, 1, FAMILY));

        // Comfort Hotel Reykjavík
        all_rooms.add(new Room(4, SINGLE, 2, new Room.RoomAmenities[]{TV, BALCONY, ROOM_SERVICE}, room_occupancy, 2, SINGLE));
        all_rooms.add(new Room(5, DOUBLE, 2, new Room.RoomAmenities[]{TV, OCEAN_VIEW, ROOM_SERVICE}, room_occupancy, 2, DOUBLE));
        all_rooms.add(new Room(6, FAMILY, 2, new Room.RoomAmenities[]{TV, OCEAN_VIEW, ROOM_SERVICE}, room_occupancy, 2, FAMILY));

        // Economy Hotel Egilstaðir
        all_rooms.add(new Room(7, SINGLE, 1.5, new Room.RoomAmenities[]{ROOM_SERVICE}, room_occupancy, 3, SINGLE));
        all_rooms.add(new Room(8, DOUBLE, 1.5, new Room.RoomAmenities[]{BALCONY, ROOM_SERVICE}, room_occupancy, 3, DOUBLE));
        all_rooms.add(new Room(9, FAMILY, 1.5, new Room.RoomAmenities[]{BALCONY, ROOM_SERVICE}, room_occupancy, 3, FAMILY));

        // Comfort Hotel Egilstaðir
        all_rooms.add(new Room(10, SINGLE, 3, new Room.RoomAmenities[]{ROOM_SERVICE, OCEAN_VIEW}, room_occupancy, 4, SINGLE));
        all_rooms.add(new Room(11, DOUBLE, 3, new Room.RoomAmenities[]{BALCONY, OCEAN_VIEW, ROOM_SERVICE, TV}, room_occupancy, 4, DOUBLE));
        all_rooms.add(new Room(12, FAMILY, 3, new Room.RoomAmenities[]{BALCONY, OCEAN_VIEW, ROOM_SERVICE, TV}, room_occupancy, 4, FAMILY));

        // Economy Hotel Akureyri
        all_rooms.add(new Room(13, SINGLE, 1.5, new Room.RoomAmenities[]{TV, REFRIGERATOR}, room_occupancy, 5, SINGLE));
        all_rooms.add(new Room(14, DOUBLE, 1.5, new Room.RoomAmenities[]{TV, REFRIGERATOR, BALCONY}, room_occupancy, 5, DOUBLE));
        all_rooms.add(new Room(15, FAMILY, 1.5, new Room.RoomAmenities[]{TV, REFRIGERATOR, BALCONY}, room_occupancy, 5, FAMILY));

        // Comfort Hotel Akureyri
        all_rooms.add(new Room(16, SINGLE, 2, new Room.RoomAmenities[]{TV, ROOM_SERVICE, BALCONY, REFRIGERATOR}, room_occupancy, 6, SINGLE));
        all_rooms.add(new Room(17, DOUBLE, 2, new Room.RoomAmenities[]{TV, ROOM_SERVICE, BALCONY, REFRIGERATOR}, room_occupancy, 6, DOUBLE));
        all_rooms.add(new Room(18, FAMILY, 2, new Room.RoomAmenities[]{TV, ROOM_SERVICE, BALCONY, REFRIGERATOR}, room_occupancy, 6, FAMILY));

        // Economy Hotel Ísafjörður
        all_rooms.add(new Room(19, SINGLE, 1.5, new Room.RoomAmenities[]{TV, OCEAN_VIEW}, room_occupancy, 7, SINGLE));
        all_rooms.add(new Room(20, DOUBLE, 1.5, new Room.RoomAmenities[]{TV, REFRIGERATOR, OCEAN_VIEW}, room_occupancy, 7, DOUBLE));
        all_rooms.add(new Room(21, FAMILY, 1.5, new Room.RoomAmenities[]{TV, REFRIGERATOR, OCEAN_VIEW}, room_occupancy, 7, FAMILY));

        // Comfort Hotel Ísafjörður
        all_rooms.add(new Room(22, SINGLE, 3, new Room.RoomAmenities[]{TV, OCEAN_VIEW, ROOM_SERVICE, REFRIGERATOR}, room_occupancy, 8, SINGLE));
        all_rooms.add(new Room(23, DOUBLE, 3, new Room.RoomAmenities[]{TV, OCEAN_VIEW, ROOM_SERVICE, REFRIGERATOR}, room_occupancy, 8, DOUBLE));
        all_rooms.add(new Room(24, FAMILY, 3, new Room.RoomAmenities[]{TV, OCEAN_VIEW, ROOM_SERVICE, REFRIGERATOR}, room_occupancy, 8, FAMILY));

        all_rooms.add(new Room(25, SINGLE, 3, new Room.RoomAmenities[]{TV, OCEAN_VIEW, ROOM_SERVICE, REFRIGERATOR}, room_occupancy, 9, SINGLE));
        all_rooms.add(new Room(26, DOUBLE, 3, new Room.RoomAmenities[]{TV, OCEAN_VIEW, ROOM_SERVICE, REFRIGERATOR}, room_occupancy, 9, DOUBLE));
        all_rooms.add(new Room(27, FAMILY, 3, new Room.RoomAmenities[]{TV, OCEAN_VIEW, ROOM_SERVICE, REFRIGERATOR}, room_occupancy, 9, FAMILY));

        all_rooms.add(new Room(28, SINGLE, 2, new Room.RoomAmenities[]{TV, OCEAN_VIEW, ROOM_SERVICE, REFRIGERATOR}, room_occupancy, 10, SINGLE));
        all_rooms.add(new Room(29, DOUBLE, 2, new Room.RoomAmenities[]{TV, OCEAN_VIEW, ROOM_SERVICE, REFRIGERATOR}, room_occupancy, 10, DOUBLE));
        all_rooms.add(new Room(30, FAMILY, 2, new Room.RoomAmenities[]{TV, OCEAN_VIEW, ROOM_SERVICE, REFRIGERATOR}, room_occupancy, 10, FAMILY));

        all_rooms.add(new Room(31, SINGLE, 3, new Room.RoomAmenities[]{TV, OCEAN_VIEW, ROOM_SERVICE, REFRIGERATOR}, room_occupancy, 11, SINGLE));
        all_rooms.add(new Room(32, DOUBLE, 3, new Room.RoomAmenities[]{TV, OCEAN_VIEW, ROOM_SERVICE, REFRIGERATOR}, room_occupancy, 11, DOUBLE));
        all_rooms.add(new Room(33, FAMILY, 3, new Room.RoomAmenities[]{TV, OCEAN_VIEW, ROOM_SERVICE, REFRIGERATOR}, room_occupancy, 11, FAMILY));

        all_rooms.add(new Room(34, SINGLE, 2, new Room.RoomAmenities[]{TV, OCEAN_VIEW, ROOM_SERVICE, REFRIGERATOR}, room_occupancy, 12, SINGLE));
        all_rooms.add(new Room(35, DOUBLE, 2, new Room.RoomAmenities[]{TV, OCEAN_VIEW, ROOM_SERVICE, REFRIGERATOR}, room_occupancy, 12, DOUBLE));
        all_rooms.add(new Room(36, FAMILY, 2, new Room.RoomAmenities[]{TV, OCEAN_VIEW, ROOM_SERVICE, REFRIGERATOR}, room_occupancy, 12, FAMILY));

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


    public ArrayList<Room> getRooms() {
        return all_rooms;
    }

}
