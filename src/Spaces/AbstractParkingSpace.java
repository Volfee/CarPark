package Spaces;

import java.util.Comparator;

public abstract class AbstractParkingSpace implements ParkingSpace {
    protected int distanceFromEntrance;

    public static class DistanceComparator implements Comparator<AbstractParkingSpace> {

        @Override
        public int compare(AbstractParkingSpace o1, AbstractParkingSpace o2) {
            return o1.distanceFromEntrance - o2.distanceFromEntrance;
        }
    }
}
