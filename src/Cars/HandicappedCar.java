package Cars;

import Cars.RegularCar;

public class HandicappedCar extends RegularCar {

    public HandicappedCar(int shoppingTime) {
        super(shoppingTime);
        this.type = "handicapped";
    }

    @Override
    public String toString() {
        return "(Handi_" + this.id + ", time: " + this.timeLeft + ")";

    }
}
