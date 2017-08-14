package be.kriden.learn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeatherFile {

    private static final int HEADER_OFFSET = 2;
    private int lines = 0;
    private List<Reading> readings = new ArrayList<>();

    public WeatherFile(File file) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(file)){
            for(lines = 0; scanner.hasNextLine(); lines++) {
                String currentLine = scanner.nextLine();
                if(lines >= HEADER_OFFSET) {
                    readings.add(Reading.createFromString(currentLine));
                }
            }
        }
    }

    public List<Reading> readings() {
        return readings;
    }

    public int numberOfLines() {
        return lines;
    }
}
