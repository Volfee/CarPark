import Cars.Car;
import Spaces.ParkingSpace;
import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;

public class SpacesQueue implements Iterable<ParkingSpace>, Collection<ParkingSpace> {

    private PriorityQueue<ParkingSpace> availableSpaces;

    SpacesQueue() {
        this.availableSpaces = new PriorityQueue<>();
    }

    /** Allocates car in the space closest to the entrance. Removes it from the
     * queue and returns space with the car.
     * @param car - car to allocate
     * @return occupied parking space.
     */
    public ParkingSpace allocate(Car car) {
        ParkingSpace space = availableSpaces.poll();
        space.occupy(car);
        return space;
    }

    @Override
    public Iterator<ParkingSpace> iterator() {
        return availableSpaces.iterator();
    }

    @Override
    public Object[] toArray() {
        return availableSpaces.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return availableSpaces.toArray(a);
    }

    @Override
    public boolean add(ParkingSpace parkingSpace) {
        return availableSpaces.add(parkingSpace);
    }

    @Override
    public boolean remove(Object o) {
        return availableSpaces.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return availableSpaces.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends ParkingSpace> c) {
        return availableSpaces.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return availableSpaces.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return availableSpaces.retainAll(c);
    }

    @Override
    public void clear() {
        availableSpaces.clear();
    }

    @Override
    public int size() {
        return availableSpaces.size();
    }

    @Override
    public boolean isEmpty() {
        return availableSpaces.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return availableSpaces.contains(o);
    }
}
