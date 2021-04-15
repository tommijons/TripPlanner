package Test;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

class TravelPackageControllerTest {
 /*   private DataFactory df = new DataFactory();
    private TravelPackage tp1;
    private TravelPackage tp2;
    private TravelPackage tp3;
    private TravelPackageController tpc;
    private ArrayList<Flight> flights;
    private ArrayList<Hotel> hotels;
    private ObservableList<Tour> tours;
    private Tour newDayTrip;
    private Tour oldDayTrip;
    private Hotel oldHotel;
    private ArrayList<Room> oldRoom;
    private boolean[] h_amenities1 = {false, false, false};
    private Flight oldFlight;
    private TravelPackage changeMe;
    @BeforeEach
    void setUp() {
        tpc = new TravelPackageController();
        flights = df.getFlights();
        hotels = df.getHotels();
        tours = df.getTours();
        LocalDate d1 = LocalDate.of(2021,4,1);
        LocalDate d2 = LocalDate.of(2021,4,5);
        newDayTrip = (new Tour( "Horseriding in Eyjafjörður","Bring warm clothes",d1, 10,10000,
                "Akureyri",7,"Family friendly"));
        oldDayTrip = (new Tour( "Buggy Tour in Rauðhólar","Children must be under parent supervision",
                d2,20,20000, "Reykjavík",5, "Action"));
        oldHotel = new Hotel(2, "Comfort Hotel Reykjavik", "Reykjavík", "Mýrargata 2", 102, 5550001,
                FOUR, new Hotel.HotelAmenities[]{SPA, FREE_WIFI}, getRoomsByHotelId(2), 2, 10000);
        oldFlight = new Flight(123,"Reykjavík","Akureyri","2200" , "2300",  "121212", 12420,"fluglygar",true);
        changeMe = new TravelPackage(oldHotel,oldFlight,oldDayTrip);
        flights.sort(Comparator.comparingInt(Flight::getPrice));
        hotels.sort(Comparator.comparingInt(Hotel::getHotel_base_price));
        tours.sort(Comparator.comparingInt(Tour::getTourPrice));

        tp1 = tpc.createCheapPackage(hotels.toArray(new Hotel[0]), flights.toArray(new Flight[0]), tours);
        tp2 = tpc.createLuxuryPackage(hotels.toArray(new Hotel[0]), flights.toArray(new Flight[0]), tours);
        tp3 = tpc.createStandardPackage(hotels.toArray(new Hotel[0]), flights.toArray(new Flight[0]), tours);
    }

    @AfterEach
    void tearDown() {
        tp1 = null;
        tp2 = null;
        tp3 = null;
        tpc = null;
        changeMe = null;
        oldFlight = null;
        oldHotel = null;
        oldDayTrip = null;
        newDayTrip = null;
    }

    @Test
    void changeDayTrip() {
        tpc.changeDayTrip(changeMe,newDayTrip);
        Assertions.assertEquals(newDayTrip,changeMe.getDaytrip());
    }

    @Test
    void createStandardPackage() {
        Assertions.assertTrue(tp3.getTotalPrice() > tp1.getTotalPrice());
        Assertions.assertTrue(tp3.getTotalPrice() < tp2.getTotalPrice());
    }

    @Test
    void createCheapPackage() {
        Assertions.assertTrue(tp1.getTotalPrice() < tp2.getTotalPrice());
    }

    @Test
    void createLuxuryPackage() {
        Assertions.assertTrue(tp1.getTotalPrice() < tp2.getTotalPrice());
    }*/
}