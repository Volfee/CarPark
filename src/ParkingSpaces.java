import Cars.Car;
import Spaces.CompactSpace;
import Spaces.ParkingSpace;
import Spaces.RegularSpace;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class ParkingSpaces {

    private SpacesQueue availableSpaces = new SpacesQueue();
    private List<ParkingSpace> occupiedSpaces = new LinkedList<>();

    private static Random r = new Random(123);

    public ParkingSpaces(int regular_spaces, int compact_spaces) {
        createRegularSpaces(regular_spaces);
        // createCompactSpaces(compact_spaces);
    }

    private void createRegularSpaces(int number) {
        for (int i = 0; i < number; i++) {
            int distance = Math.abs(r.nextInt() % 20);
            availableSpaces.add(new RegularSpace(distance));
        }
    }

    // private void createCompactSpaces(int number) {
    //     for (int i = 0; i < number; i++) {
    //         int distance = Math.abs(r.nextInt() % 20);
    //         availableSpaces.add(new CompactSpace(distance));
    //     }
    // }

    public void releaseFinishedCars() {
        List<ParkingSpace> spacesToRelease = new LinkedList<>();
        for (ParkingSpace s : occupiedSpaces) {
            if (s.peekCar().timeLeft() <= 0) {
                s.freeUp();
                spacesToRelease.add(s);
                availableSpaces.add(s);
            } else {
                s.peekCar().spendTime();
            }
        }
        occupiedSpaces.removeAll(spacesToRelease);
    }

    public boolean hasFreeSpaces(Car car) {
        return !availableSpaces.isEmpty();
    }

    public void add(Car car) {
        ParkingSpace space = availableSpaces.allocate(car);
        occupiedSpaces.add(space);
    }

    public void show() {
        Queue<ParkingSpace> sortedSpaces = new PriorityQueue<>();
        sortedSpaces.addAll(availableSpaces);
        sortedSpaces.addAll(occupiedSpaces);
        while(!sortedSpaces.isEmpty()) {
            System.out.println(sortedSpaces.poll());
        }
    }


}
