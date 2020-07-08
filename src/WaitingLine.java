import Cars.Car;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

public class WaitingLine implements Iterable<Car> {

    private Queue<Car> waitingLine;
    private int capacity;
    private int size;

    public WaitingLine(int capacity) {
        waitingLine = new LinkedList<>();
        this.capacity = capacity;
        size = 0;
    }

    /** Adds car to the end of queue. */
    void addCar(Car car) throws StackOverflowError {
        if (isFull())
            throw new StackOverflowError();
        waitingLine.add(car);
        size += 1;
    }

    void addAll(List<Car> cars) {
        waitingLine.addAll(cars);
        size += cars.size();
    }

    /** Remove car from the front of queue. */
    public Car removeCar() throws NoSuchElementException {
        Car carToRemove = waitingLine.remove();
        size -= 1;
        return carToRemove;
    }


    /** Checks if there is enough place in queue */
    public boolean isEmpty() {
        return size() <= 0;
    }

    /** Checks if there is enough place in queue */
    private boolean isFull() {
        return size() >= capacity;
    }

    /** Returns current size of queue. */
    private int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Car c : waitingLine) {
            result.append(c.toString()).append(" ");
        }
        return result.toString();
    }

    @Override
    public Iterator<Car> iterator() {
        return waitingLine.iterator();
    }

    public void show() {
        System.out.print("Carline: ");
        for (Car car : waitingLine) {
            System.out.print(car + " ");
        }
        System.out.println();
    }
}