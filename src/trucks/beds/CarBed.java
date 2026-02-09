package src.trucks.beds;

import java.util.LinkedList;
import java.util.List;

import src.cars.Car;

public class CarBed implements TruckBed {
    private boolean rampUp;
    private List<Car> load;

    private int maxCount;
    private int maxWeight;
    private int maxLength;
    private int maxWidth;

    public CarBed() {
        this(8, 2400, 3200, 2000); //Standard values if nothing else is specified
    }

    public CarBed(int maxCount, int maxWeight, int maxLength, int maxWidth) {
        rampUp = true;
        this.maxCount = maxCount;
        this.maxWeight = maxWeight;
        this.maxLength = maxLength;
        this.maxWidth = maxWidth;

        load = new LinkedList<>();
    }

    public List<Car> getLoad() {
        return load;
    }

    public void raiseRamp() {
        rampUp = true;
    }

    public void lowerRamp() {
        rampUp = false;
    }

    public boolean inDrivingPosition() {
        return rampUp;
    }

    private boolean carFits(Car car) {
        return getLoad().size() < maxCount && car.getWeight() < maxWeight
                && car.getLength() < maxLength && car.getWidth() < maxWidth;
    }

    public void loadCar(Car car) {
        if (!inDrivingPosition() && carFits(car)) { // Ramp must be down and load < maxLoad
            load.addLast(car);
        }
    }

    public Car unloadCar() {
        if (load.isEmpty() || inDrivingPosition())
            return null;
        return load.removeLast(); // Unload according to (First In - Last Out)
    }
}
