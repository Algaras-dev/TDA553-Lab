package src;

import java.util.ArrayList;

import src.cars.Car;

public class Workshop<C extends Car> {
    private int maxCars;
    private ArrayList<C> carList;

    public Workshop(int maxCars) {
        this.maxCars = maxCars;
        carList = new ArrayList<C>();
    }

    public void addCar(C car) {
        carList.add(car);
    }

    public C returnCar() {
        return carList.removeLast();
    }

    public C returnCar(String modelName) {
        for (C car : carList) {
            if (car.getModelName() == modelName) {

                carList.remove(car);
                return car;
            }
        }

        return null;
    }
}
