package src.trucks.beds;

import java.util.Stack;
import java.awt.geom.Point2D;

import src.cars.Car;

public class CarBed implements TruckBed {
    private boolean rampUp;
    private Stack<Car> load;

    private int maxCount;
    private int maxWeight;
    private int maxLength;
    private int maxWidth;

    public CarBed() {
        this(8, 2400, 5000, 2000); // Standard values if nothing else is specified
    }

    public CarBed(int maxCount, int maxWeight, int maxLength, int maxWidth) {
        rampUp = true;
        this.maxCount = maxCount;
        this.maxWeight = maxWeight;
        this.maxLength = maxLength;
        this.maxWidth = maxWidth;

        load = new Stack<>();
    }

    public Stack<Car> getLoad() {
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
        return getLoad().size() < maxCount
                && car.getWeight() < maxWeight
                && car.getLength() < maxLength
                && car.getWidth() < maxWidth;
    }

    private boolean carInRadius(Car car, Point2D.Double selfLoc) {
        Point2D.Double carLoc = car.getLocation();
        double distance = Math.sqrt(
                Math.pow(carLoc.x - selfLoc.x, 2)
                + Math.pow(carLoc.y - selfLoc.y, 2));

        // Car must be within a radius of 25 units from the truck. selfLoc is passed as an arg from the caller
        return distance < 25;
    }

    public void loadCar(Car car, Point2D.Double selfLoc) {
        if (!rampUp && carFits(car) && carInRadius(car, selfLoc)) { // Ramp must be down and car must fit and be in radius
            load.push(car);
        }
    }

    public Car unloadCar() {
        if (load.isEmpty() || inDrivingPosition())
            return null;
        return load.pop(); // Unload according to (First In - Last Out)
    }
}

