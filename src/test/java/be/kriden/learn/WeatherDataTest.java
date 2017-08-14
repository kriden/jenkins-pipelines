package be.kriden.learn;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class WeatherDataTest {

    @Test(expected = NullPointerException.class)
    public void nonExistingFileThrowsException() throws FileNotFoundException {
        new WeatherFile(null);
    }

    @Test
    public void canReadEmptyFile() throws FileNotFoundException {
        WeatherFile kata = kataFromEmtpyFile();
        assertEquals(0, kata.numberOfLines());
    }


    @Test
    public void collectsReadings() throws FileNotFoundException {
        WeatherFile kata = kataFromCorrectFile();
        assertEquals(31, kata.readings().size());
    }

    @Test
    public void readingContainsStructuredInformation() throws FileNotFoundException {
        WeatherFile kata = kataFromCorrectFile();
        Reading reading = kata.readings().get(0);

        assertEquals(1, reading.getDay());
    }

    private WeatherFile kataFromCorrectFile() throws FileNotFoundException {
        return createWithSourceFile("/weather.dat");
    }

    private WeatherFile kataFromEmtpyFile() throws FileNotFoundException {
        return createWithSourceFile("/weather-empty.dat");
    }

    private WeatherFile createWithSourceFile(String filename) throws FileNotFoundException {
        return new WeatherFile(getClass().getResourceAsStream(filename));
    }

}