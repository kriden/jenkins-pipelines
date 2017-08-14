package be.kriden.learn;

public class Reading {
    private int minTemp;
    private int maxTemp;
    private int day = -1;

    public static Reading createFromString(String currentLine) {
        if(!currentLine.isEmpty()) {
            String[] data = currentLine.replaceAll("\\s+", " ").trim().split(" ");
            try {
                int day = getCleanValue(data, 0);
                int maxTemp = getCleanValue(data, 1);
                int minTemp = getCleanValue(data, 2);
                return new Reading(day, maxTemp, minTemp);
            } catch(NumberFormatException nfe) {
                return null;
            }
        }
        return null;
    }

    private static Integer getCleanValue(String[] data, int index) {
        String value = data[index].replace("*", "");
        return Integer.valueOf(value);
    }

    public Reading(int day, int maxTemp, int minTemp) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public int getTempDiff() {
        return Math.abs(maxTemp - minTemp);
    }
}
