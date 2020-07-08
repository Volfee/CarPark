package Spaces;

import Cars.Car;

public class HandicapSpace extends RegularSpace {

    private String type = "handicap";

    public HandicapSpace(int distance) {
        super(distance);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Handi Parking space [<Empty>] D: " + distanceFromEntrance;
        } else {
            return "Handi Parking space [" + car + "] D: " + distanceFromEntrance;
        }
    }

    @Override
    public boolean canFit(Car car) {
        return car.carType().equals("handicapped");
    }
}
