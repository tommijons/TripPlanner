package sample;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.*;
public class TravelPackageControllerTest {
    private TravelPackageController travelPackageController;
    private DataFactory df;
    private ArrayList<DayTrip> dayTrips;
    private ArrayList<Flight> flights;
    private ArrayList<Hotel> hotels;

    @Before
    public void setup() {
        travelPackageController = new TravelPackageController();
        dayTrips = df.getDayTrips();
        flights = df.getFlights();
        hotels = df.getHotels();

    }
    @After
    public void teardown() {
        dayTrips = null;
        flights = null;
        hotels = null;
        travelPackageController = null;
    }

    @Test
    public void testCreateCheapPackage() {
        assertTrue();
    }

}
