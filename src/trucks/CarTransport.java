package src.trucks;

import java.awt.*;

import src.cars.Car;
import src.trucks.beds.CarBed;

public class CarTransport extends Truck {
    private final CarBed bed;

    public CarTransport() {
        this(new CarBed());
    }

    private CarTransport(CarBed bed) {
        super(2, Color.GRAY, 220, "Car Transporter", bed, 12000, 14200, 2500);
        this.bed = bed;
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
        double[] carLoc = car.getLocation();
        double distance = Math.sqrt(
                Math.pow(carLoc[0] - selfLoc[0], 2) +
                        Math.pow(carLoc[1] - selfLoc[1], 2));

        // Car must be within a radius of 25 units from the truck
        if (distance < 25) {
            bed.loadCar(car);
        }
    }

    public Car unloadCar() {
        Car car = bed.unloadCar();
        if (car != null) {
            car.setLocation(getLocation()[0], getLocation()[1] - 10); //Car is unloaded 10 units below the truck in the y-direction
        }

        return car;
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
