package fool;

public class Elevator {

    private int currentFloor;
    public Elevator() {
        currentFloor = 1;
    }

    int getFloor() {
        return currentFloor;
    }

    void updateFloor(int f) {
        currentFloor = f;
    }
}