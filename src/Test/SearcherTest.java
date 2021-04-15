package Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class SearcherTest {
  /*  public MockTourController mockTourController;
    public Searcher searcher;
    public TourFilter tourFilter1;
    public TourFilter tourFilter2;
    public TourFilter tourFilter3;
    @BeforeEach
    void setUp() {
        mockTourController = new MockTourController(null);
        searcher = new Searcher(0,mockTourController);
        tourFilter1 = new TourFilter(new Date(12,10,12),new Date(12,10,13), "Akureyri", 10000, "Family Friendly", 1, 2,1);
        tourFilter2 = new TourFilter(new Date(12,10,12),new Date(12,10,13), "Akureyri", 10000, "Family Friendly", 1, 2,3);
        tourFilter3 = new TourFilter(new Date(12,10,12),new Date(12,10,13), "Akureyri", 30000, "Family Friendly", 1, 2,3);
    }

    @AfterEach
    void tearDown() {
        mockTourController = null;
        searcher = null;
        tourFilter1 = null;
        tourFilter2 = null;
        tourFilter3 = null;
    }

    @Test
    void searchForTours1() {
        Assertions.assertEquals(2,searcher.searchForTours(tourFilter1).size());
    }
    @Test
    void searchForTours2() {
        Assertions.assertEquals(1,searcher.searchForTours(tourFilter2).size());
    }
    @Test
    void searchForTours3() {
        int testResult = searcher.searchForTours(tourFilter3).size();
        Assertions.assertEquals(2, testResult);
    }*/
}
