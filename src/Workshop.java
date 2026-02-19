package src;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import src.cars.Car;

public class Workshop<C extends Car> implements Drawable {
    private int maxCars;
    private ArrayList<C> carList;
    private String workshopType;

    private Point2D.Double location;

    public Workshop(int maxCars) {
        this(maxCars, 0, 0, "Workshop");
    }

    public Workshop(int maxCars, double x, double y, String workshopType) {
        this.maxCars = maxCars;
        carList = new ArrayList<C>();

        location = new Point2D.Double(x, y);

        this.workshopType = workshopType;
    }

    public String getName() {
        return workshopType;
    }

    public void addCar(C car) {
        if (carList.size() >= maxCars) {
            throw new IllegalStateException("Workshop is full");
        }
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

    public Point2D.Double getLocation() {
        return new Point2D.Double(location.x, location.y);
    }
}
