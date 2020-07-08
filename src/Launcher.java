import Cars.Car;
import Cars.RegularCar;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Launcher {

    private static Random r = new Random(123);

    /** Generates list of new cars */
    private static List<Car> generateNewCars(int regular) {
        List<Car> cars = new LinkedList<>();
        for (int i = 0; i < regular; i++) {
            Car car = new RegularCar(Math.abs(r.nextInt()) % 5);
            cars.add(car);
        }
        return cars;
    }

    public static void main(String[] args) {

        // Waiting line for new arriving cars.
        WaitingLine carLine = new WaitingLine(8);

        // Priority queue to keep track of empty spaces.
        ParkingSpaces parking = new ParkingSpaces(8, 4);


        // Main event loop
        for (int rounds = 24; rounds > 0; rounds--) {

            System.out.println("\nRounds left: " + rounds);
            parking.show();

            // Remove cars that finished shopping.
            parking.releaseFinishedCars();

            // Generate and add new arriving cars.
            int regular_cars = Math.abs(r.nextInt()) % 8;
            List<Car> newCars = generateNewCars(regular_cars);
            carLine.addAll(newCars);

            carLine.show();

            // Allocate cars to spaces.
            List<Car> noSpaceLine = new LinkedList<>();
            while (!carLine.isEmpty()) {
                Car car = carLine.removeCar();
                if (parking.hasFreeSpaces(car)) {
                    parking.add(car);
                } else {
                    noSpaceLine.add(car);
                }
            }
            carLine.addAll(noSpaceLine);



        }
    }
}


