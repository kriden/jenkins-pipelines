package be.kriden.learn;

import java.util.Comparator;

public class MinTempDifferenceComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Reading r1 = (Reading) o1;
        Reading r2 = (Reading) o2;
        if(r1 != null && r2 != null) {
            return ((Integer) r1.getTempDiff()).compareTo((Integer) r2.getTempDiff());
        }
        return 1;
    }
}
