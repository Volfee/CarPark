package Spaces;

import Cars.Car;

public class RegularSpace extends AbstractParkingSpace {

    protected Car car;
    private String type = "regular";

    public RegularSpace(int distance) {
        this.car = null;
        this.distanceFromEntrance = distance;
    }

    @Override
    public void occupy(Car car) {
        if (isEmpty()) {
            this.car = car;
        } else {
            System.err.println("This space is already occupied!");
        }
    }

    @Override
    public void freeUp() {
        this.car = null;
    }

    @Override
    public boolean isEmpty() {
        return this.car == null;
    }

    @Override
    public Car peekCar() {
        return car;
    }

    @Override
    public String checkType() {
        return type;
    }

    /** Compares to parking spaces where parking space closer to entrance is considered better. */
    @Override
    public int compareTo(Object o) {
        AbstractParkingSpace p = (AbstractParkingSpace) o;
        return (p.distanceFromEntrance - this.distanceFromEntrance) * - 1;
    }

    @Override
    public boolean canFit(Car car) {
        return true;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Parking space [<Empty>] D: " + distanceFromEntrance;
        } else {
            return "Parking space [" + car + "] D: " + distanceFromEntrance;
        }
    }
}
