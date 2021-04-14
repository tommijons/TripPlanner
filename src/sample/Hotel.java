package sample;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Objects;

public class Hotel {
    enum HotelAmenities {
        SPA,
        BREAKFAST_INCLUDED,
        PARKING,
        FREE_WIFI,
        RESTAURANT,
        HANDICAP_ACCESSIBLE
    }

    enum StarRating {
        THREE,
        FOUR,
        FIVE
    }

    private int hotel_id;
    private String hotel_name;
    private String hotel_location;
    private String hotel_address;
    private int hotel_postal_code;
    private int hotel_phone_number;
    private StarRating hotel_star_rating;


    private HotelAmenities[] hotel_amenities;
    private ArrayList<Room> hotel_room_list;
    private int hotel_type;
    public int hotel_base_price;
    private String hotel_city;
    private Hotel hotel;


    public Hotel() {
        this.hotel_id = 999; //Removed redundant null checks (ILG)
        this.hotel_name = "Hotel California";
        this.hotel_location = "Hvergistan";
        this.hotel_address = "Dúfnahólar 10";
        this.hotel_postal_code = 420;
        this.hotel_phone_number = 5885522;
        this.hotel_star_rating = StarRating.FIVE;
        this.hotel_amenities = null;
        this.hotel_room_list = null;
        this.hotel_type = 1;
        this.hotel_base_price = 1000;
    }


    //public Hotel(int hotel_id, String hotel_name, String hotel_location, int hotel_phone_number, int hotel_star_rating, boolean[] hotel_amenities, ArrayList<Room> hotel_room_list, int hotel_type, int hotel_base_price) {


    public Hotel(int hotel_id, String hotel_name, String hotel_location, String hotel_address, int hotel_postal_code, int hotel_phone_number, StarRating hotel_star_rating, HotelAmenities[] hotel_amenities, ArrayList<Room> hotel_room_list, int hotel_type, int hotel_base_price) {

        this.hotel_id = hotel_id; //Removed redundant null checks (ILG)
        this.hotel_name = Objects.requireNonNull(hotel_name, "hotel_name must not be null");
        this.hotel_location = Objects.requireNonNull(hotel_location, "hotel_location must not be null");
        this.hotel_address = Objects.requireNonNull(hotel_address, "hotel_address must not be null");
        this.hotel_postal_code = hotel_postal_code;
        this.hotel_phone_number = hotel_phone_number;
        this.hotel_star_rating = hotel_star_rating;
        this.hotel_amenities = Objects.requireNonNull(hotel_amenities, "hotel_amenities must not be null");
        this.hotel_room_list = Objects.requireNonNull(hotel_room_list, "hotel_room_list must not be null");
        this.hotel_type = hotel_type;
        this.hotel_base_price = hotel_base_price;

        /*
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.hotel_location = hotel_location;
        this.hotel_phone_number = hotel_phone_number;
        this.hotel_star_rating = hotel_star_rating;
        this.hotel_amenities = hotel_amenities;
        this.hotel_room_list = hotel_room_list;
        this.hotel_type = hotel_type;
        this.hotel_base_price = hotel_base_price;
        */
    }

    public String getHotel_address() {
        return hotel_address;
    }

    public void setHotel_address(String hotel_address) {
        this.hotel_address = hotel_address;
    }

    public int getHotel_postal_code() {
        return hotel_postal_code;
    }

    public void setHotel_postal_code(int hotel_postal_code) {
        this.hotel_postal_code = hotel_postal_code;
    }

    @Override
    public String toString() {
        return "\nNafn: "+ hotel_name + "\nStjörnur: "+ hotel_star_rating;
    }

    public Hotel(String hotel_city) {
        this.hotel_city = hotel_city;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getHotel_city() {
        return hotel_city;
    }

    public void setHotel_city(String hotel_city) {
        this.hotel_city = hotel_city;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_location() {
        return hotel_location;
    }

    public void setHotel_location(String hotel_location) {
        this.hotel_location = hotel_location;
    }

    public int getHotel_phone_number() {
        return hotel_phone_number;
    }

    public void setHotel_phone_number(int hotel_phone_number) {
        this.hotel_phone_number = hotel_phone_number;
    }

    public StarRating getHotel_star_rating() {
        return hotel_star_rating;
    }

    public void setHotel_star_rating(StarRating hotel_star_rating) {
        this.hotel_star_rating = hotel_star_rating;
    }

    public HotelAmenities[] isHotel_amenities() {
        return hotel_amenities;
    }

    public void setHotel_amenities(HotelAmenities[] hotel_amenities) {
        this.hotel_amenities = hotel_amenities;
    }

    public HotelAmenities[] getHotel_amenities() {
        return hotel_amenities;
    }

    public ArrayList<Room> getHotel_room_list() {
        return hotel_room_list;
    }

    public void setHotel_room_list(ArrayList<Room> hotel_room_list) {
        this.hotel_room_list = hotel_room_list;
    }

    public int getHotel_type() {
        return hotel_type;
    }

    public void setHotel_type(int hotel_type) {
        this.hotel_type = hotel_type;
    }

    public int getHotel_base_price() {
        return hotel_base_price;
    }

    public void setHotel_base_price(int hotel_base_price) {
        this.hotel_base_price = hotel_base_price;
    }

    public Hotel getHotelByID(int hotel_id, ObservableList<Hotel> hotelList) {
        for (Hotel h : hotelList) {
            if (hotel_id == h.getHotel_id()) {
                return h;
            }
        }
        return null;
    }
}