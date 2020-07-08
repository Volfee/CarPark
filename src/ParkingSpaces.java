import Cars.Car;
import Spaces.HandicapSpace;
import Spaces.ParkingSpace;
import Spaces.RegularSpace;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class ParkingSpaces {

    private Queue<ParkingSpace> availableSpaces = new PriorityQueue<>();
    private List<ParkingSpace> occupiedSpaces = new LinkedList<>();

    private static Random r = new Random(123);

    public ParkingSpaces(int regular_spaces, int handicap_spaces) {
        createRegularSpaces(regular_spaces);
        createHandicapSpaces(handicap_spaces);
    }

    private void createRegularSpaces(int number) {
        for (int i = 0; i < number; i++) {
            int distance = Math.abs(r.nextInt() % 20);
            availableSpaces.add(new RegularSpace(distance));
        }
    }

    private void createHandicapSpaces(int number) {
        for (int i = 0; i < number; i++) {
            int distance = Math.abs(r.nextInt() % 20);
            availableSpaces.add(new HandicapSpace(distance));
        }
    }

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

    public boolean hasFreeSpaces() {
        return availableSpaces.size() > 0;
    }

    public boolean tryToAllocate(Car car) {
        List<ParkingSpace> mismatchedSpaces = new LinkedList<>();
        boolean successful = false;
        while (!availableSpaces.isEmpty()) {
            ParkingSpace space = availableSpaces.poll();
            if(space.canFit(car)) {
                space.occupy(car);
                occupiedSpaces.add(space);
                successful = true;
                break;
            } else {
                mismatchedSpaces.add(space);
            }
        }
        availableSpaces.addAll(mismatchedSpaces);
        return successful;
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
