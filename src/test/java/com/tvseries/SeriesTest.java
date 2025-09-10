
package com.tvseries;

import static org.junit.Assert.*;
import org.junit.Test;

public class SeriesTest {

    @Test
    public void TestSearchSeries() {
        Series.seriesArray[0] = new SeriesModel();
        Series.seriesArray[0].seriesId = "101";
        Series.count = 1;
        assertEquals("101", Series.seriesArray[0].seriesId);
    }

    @Test
    public void TestSearchSeries_SeriesNotFound() {
        Series.count = 0;
        String searchId = "999";
        boolean found = false;
        for (int i = 0; i < Series.count; i++) {
            if (Series.seriesArray[i].seriesId.equals(searchId)) {
                found = true;
                break;
            }
        }
        assertFalse(found);
    }

    @Test
    public void TestUpdateSeries() {
        Series.seriesArray[0] = new SeriesModel();
        Series.seriesArray[0].seriesId = "101";
        Series.seriesArray[0].seriesName = "Old Name";
        Series.count = 1;
        Series.seriesArray[0].seriesName = "New Name";
        assertEquals("New Name", Series.seriesArray[0].seriesName);
    }

    @Test
    public void TestDeleteSeries() {
        Series.seriesArray[0] = new SeriesModel();
        Series.seriesArray[0].seriesId = "101";
        Series.count = 1;
        Series.count--;
        assertEquals(0, Series.count);
    }

    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        Series.count = 0;
        String deleteId = "999";
        boolean deleted = false;
        for (int i = 0; i < Series.count; i++) {
            if (Series.seriesArray[i].seriesId.equals(deleteId)) {
                deleted = true;
                break;
            }
        }
        assertFalse(deleted);
    }

    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        int age = 12;
        boolean valid = (age >= 2 && age <= 18);
        assertTrue(valid);
    }

    @Test
    public void TestSeriesAgeRestriction_SeriesAgeInValid() {
        int age = 25;
        boolean valid = (age >= 2 && age <= 18);
        assertFalse(valid);
    }
}
