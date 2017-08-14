package be.kriden.learn;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ReadingTest {

    @Test
    public void emptyStringInitializesDefaultObject() {
        Reading reading = Reading.createFromString("");
        assertNull(reading);
    }

    @Test
    public void formattedStringIntializesObject() {
        Reading reading = Reading.createFromString("1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5");
        assertEquals(1, reading.getDay());
        assertEquals(88, reading.getMaxTemp());
        assertEquals(59, reading.getMinTemp());
    }

    @Test
    public void calculatesTempDifference() {
        assertEquals(20, difference(100, 80));
        assertEquals(20, difference(-100, -80));
        assertEquals(90, difference(10, -80));
        assertEquals(0, difference(-50, -50));
    }

    private int difference(int maxTemp, int minTemp) {
        Reading reading = new Reading(1, maxTemp, minTemp);
        return reading.getTempDiff();
    }
}
