package Hotel;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Room {
    public Room() {
    }

    //public Room(String rCatagory, String rCapacity, String rPrice, String[] rAmen) {
    //}

    enum RoomCategory {
        SINGLE,
        DOUBLE,
        FAMILY
    }

    enum RoomAmenities {
        TV,
        OCEAN_VIEW,
        BALCONY,
        REFRIGERATOR,
        ROOM_SERVICE
    }

    private int room_id;
    private int hotel_id;
    private RoomCategory room_category; // SINGLE, DOUBLE or FAMILY
    private double room_price_multiplier;
    private int room_price;
    private RoomAmenities[] room_amenities;
    private ArrayList<ArrayList<LocalDate>> room_occupancy;
    private int room_capacity;
    private ObservableValue<Boolean> isChecked = new SimpleBooleanProperty(false);
    private String roomAmenityString;


    public Room(int room_id, RoomCategory room_category, double room_price_multiplier, RoomAmenities[] room_amenities,
                ArrayList<ArrayList<LocalDate>> room_occupancy, int hotel_id, RoomCategory room_capacity) {
        this.room_id = room_id;
        this.hotel_id = hotel_id;
        this.room_category = room_category;
        this.room_price_multiplier = room_price_multiplier;
        this.room_amenities = room_amenities;
        this.room_occupancy = room_occupancy;
        this.room_price = -1;

        if (room_capacity == RoomCategory.SINGLE) {
            this.room_capacity = 1;
        } else if (room_capacity == RoomCategory.DOUBLE) {
            this.room_capacity = 2;
        } else {
            this.room_capacity = 4;
        }
    }


    public Room(int room_id, RoomCategory room_category, double room_price_multiplier, int room_capacity, int room_price, int hotel_id,
                ArrayList<ArrayList<LocalDate>> room_occupancy, RoomAmenities[] room_amenities,
                String roomAmenityString) {
        this.room_id = room_id;
        this.hotel_id = hotel_id;
        this.room_category = room_category;
        this.room_capacity = room_capacity;
        this.room_price_multiplier = room_price_multiplier;
        this.room_price = room_price;
        this.room_occupancy = room_occupancy;
        this.room_amenities = room_amenities;
        this.roomAmenityString = roomAmenityString;
    }

    public int getRoom_price() {
        return room_price;
    }

    public void setRoom_price(int room_price) {
        this.room_price = room_price;
    }

    public String getRoomAmenityString() {
        return roomAmenityString;
    }

    public void setRoomAmenityString(String roomAmenityString) {
        this.roomAmenityString = roomAmenityString;
    }
    /*
    // Constructor for the table view in RoomSearch.fxml
    public Room(RoomCategory roomCategory, int room_capacity, double room_price_multiplier, String roomAmenityString) {
        this.room_category = roomCategory;
        this.room_price_multiplier = room_price_multiplier;
        this.room_capacity = room_capacity;
        this.roomAmenityString = roomAmenityString;
    }
     */

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public RoomCategory getRoom_category() {
        return room_category;
    }

    public void setRoom_category(RoomCategory room_category) {
        this.room_category = room_category;
    }

    public double getRoom_price_multiplier() {
        return room_price_multiplier;
    }

    public void setRoom_price_multiplier(double room_price_multiplier) {
        this.room_price_multiplier = room_price_multiplier;
    }

    public RoomAmenities[] getRoom_amenities() {
        return room_amenities;
    }

    public void setRoom_amenities(RoomAmenities[] room_amenities) {
        this.room_amenities = room_amenities;
    }

    public ArrayList<ArrayList<LocalDate>> getRoom_occupancy() {
        return room_occupancy;
    }

    public void setRoom_occupancy(ArrayList<ArrayList<LocalDate>> room_occupancy) {
        this.room_occupancy = room_occupancy;
    }

    public int getRoom_capacity() {
        return room_capacity;
    }

    public void setRoom_capacity(RoomCategory room_capacity) {
        if (room_capacity == RoomCategory.SINGLE) {
            this.room_capacity = 1;
        } else if (room_capacity == RoomCategory.DOUBLE) {
            this.room_capacity = 2;
        } else {
            this.room_capacity = 4;
        }
    }

    public ObservableValue<Boolean> getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(ObservableValue<Boolean> isChecked) {
        this.isChecked = isChecked;
    }

    /*
    public void setRoom_price(double hotel_base_price, double room_price_multiplier) {
        this.room_price = hotel_base_price * room_price_multiplier;
    }
 */

    @Override
    public String toString() {
        return "Room{" +
                "room_id=" + room_id +
                ", hotel_id=" + hotel_id +
                ", room_category=" + room_category +
                ", room_price_multiplier=" + room_price_multiplier +
                ", room_price=" + room_price +
                ", room_amenities=" + Arrays.toString(room_amenities) +
                ", room_occupancy=" + room_occupancy +
                ", room_capacity=" + room_capacity +
                ", isChecked=" + isChecked +
                ", roomAmenityString='" + roomAmenityString + '\'' +
                '}';
    }
}