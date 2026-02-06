package src.trucks.beds;

import java.util.LinkedList;

import src.cars.Car;

public class CarBed extends TruckBed {
    private boolean up;

    private int maxLoad;
    private LinkedList<Car> load;

    public CarBed() {
        up = true;

        load = new LinkedList<>();
    }

    @Override
    public boolean inDrivingPosition() {
        return up;
    }

    public void lower() {
        up = false;
    }

    public void raise() {
        up = true;
    }

    public void loadCar(Car car) {
        if (!up) {
            load.addLast(car);
        }
    }

    public Car unloadCar() {
        if (load.isEmpty() || up) return null;
        return load.removeLast(); // Lasta ur bilar från botten av listan enligt FI-LO
    }
}
