package Cars;

public class RegularCar implements Car {
    int id;
    int timeLeft; // hours spend in shopping
    String type;

    public RegularCar(int timeLeft) {
        this.id = RegularCar.newId();
        this.timeLeft = timeLeft;
        this.type = "regular";
    }

    @Override
    public int timeLeft() {
        return this.timeLeft;
    }

    @Override
    public void spendTime() {
        this.timeLeft -= 1;
    }

    @Override
    public String carType() {
        return type;
    }

    private static int nextId = 0;

    private static int newId() {
        nextId++;
        return nextId;
    }

    @Override
    public String toString() {
        return "(Reg_" + id + ", time: " + timeLeft + ")";

    }


}
