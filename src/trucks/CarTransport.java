package src.trucks;

import java.awt.Color;
import java.util.Stack;

import src.cars.Car;
import src.trucks.beds.CarBed;

public class CarTransport extends Truck<CarBed> {

    public CarTransport() {
        this(new CarBed());
    }

    public CarTransport(CarBed bed) {
        super(2, Color.GRAY, 220, "Car Transporter", bed, 12000, 14200, 2500);
    }

    public void lowerRamp() {
        if (getCurrentSpeed() == 0) {
            bed.lowerRamp();
        }
    }

    public void raiseRamp() {
        bed.raiseRamp();
    }

    public void loadCar(Car car) {
        double[] selfLoc = getLocation();
        bed.loadCar(car, selfLoc);
    }

    public Car unloadCar() {
        Car car = bed.unloadCar();
        if (car != null) {
            car.setLocation(getLocation()[0], getLocation()[1] - 10); // Car is unloaded 10 units below the truck in the
                                                                      // // y-direction
        }

        return car;
    }

    public Stack<Car> getLoad() {
        return bed.getLoad();
    }

    @Override
    public void move() {
        super.move();
        double[] newLocation = getLocation();

        for (Car car : bed.getLoad()) {
            car.setLocation(newLocation[0], newLocation[1]);
        }
    }

}
