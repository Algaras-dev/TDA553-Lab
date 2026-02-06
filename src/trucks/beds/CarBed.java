package src.trucks.beds;

import java.util.LinkedList;

import src.cars.Car;

public class CarBed extends TruckBed {
    private int maxLoad;
    private LinkedList<Car> load;

    public CarBed() {
        load = new LinkedList<>();
    }

    public void loadCar(Car car) {
        if (!inDrivingPosition()) {
            load.addLast(car);
        }
    }

    public Car unloadCar() {
        if (load.isEmpty() || inDrivingPosition())
            return null;
        return load.removeLast(); // Lasta ur bilar från botten av listan enligt FI-LO
    }
}
