package Spaces;

import Cars.Car;
import java.util.Comparator;

public interface ParkingSpace extends Comparable {
    void occupy(Car car);
    void freeUp();
    boolean isEmpty();
    Car peekCar();
    int compareTo(Object o);
};
