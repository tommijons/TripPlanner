package sample;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

class TravelPackageControllerTest {
    private DataFactory df = new DataFactory();
    private TravelPackage tp1;
    private TravelPackage tp2;
    private TravelPackage tp3;
    private TravelPackageController tpc;
    private ArrayList<Flight> flights;
    private ArrayList<Hotel> hotels;
    private ObservableList<Tour> tours;
    @BeforeEach
    void setUp() {
        tpc = new TravelPackageController();
        flights = df.getFlights();
        hotels = df.getHotels();
        tours = df.getTours();
        flights.sort(Comparator.comparingInt(Flight::getPrice));
        hotels.sort(Comparator.comparingInt(Hotel::getPrice));
        tours.sort(Comparator.comparingInt(Tour::getTourPrice));

        tp1 = tpc.createCheapPackage(hotels.toArray(new Hotel[0]), flights.toArray(new Flight[0]), tours.toArray(new Tour[0]));
        tp2 = tpc.createLuxuryPackage(hotels.toArray(new Hotel[0]), flights.toArray(new Flight[0]), tours.toArray(new Tour[0]));
        tp3 = tpc.createStandardPackage(hotels.toArray(new Hotel[0]), flights.toArray(new Flight[0]), tours.toArray(new Tour[0]));
    }

    @AfterEach
    void tearDown() {
        tp1 = null;
        tp2 = null;
        tp3 = null;
        tpc = null;
    }

    @Test
    void changeDayTrip() {
        Assertions.assertEquals(1,1);
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
    }
}