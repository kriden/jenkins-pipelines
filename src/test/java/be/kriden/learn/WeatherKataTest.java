package be.kriden.learn;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

public class WeatherKataTest {
    @Test
    public void weatherKata() throws FileNotFoundException {
        WeatherFile data = new WeatherFile(new File(getClass().getResource("/weather.dat").getPath()));
        data.readings().sort(new MinTempDifferenceComparator());
        Reading min  = data.readings().get(0);


        System.out.println(min.getDay()+": "+min.getMaxTemp()+"/"+min.getMinTemp()+">>"+min.getTempDiff());
    }
}
