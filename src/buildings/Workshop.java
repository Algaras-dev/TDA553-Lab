package src.buildings;

import java.awt.geom.Point2D;
import java.util.ArrayList;

import src.gui.Drawable;
import src.vehicles.cars.Car;

public class Workshop<C extends Car> implements Drawable {
    private int maxCars;
    private ArrayList<C> carList;

    private Class<C> workshopType;

    private Point2D.Double location;

    public Workshop(int maxCars, Class<C> workshopType) {
        this(maxCars, 0, 0, workshopType);
    }

    public Workshop(int maxCars, double x, double y, Class<C> workshopType) {
        this.maxCars = maxCars;
        carList = new ArrayList<C>();
        location = new Point2D.Double(x, y);
        this.workshopType = workshopType;
    }

    public String getName() {
        return workshopType.getSimpleName() + "Workshop";
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
            if (car.getModelName().equals(modelName)) {

                carList.remove(car);
                return car;
            }
        }

        return null;
    }

    public Point2D.Double getLocation() {
        return new Point2D.Double(location.x, location.y);
    }

    public Class<C> getType() {
        return workshopType;
    }

    public boolean acceptsCar(Car car) {
        return (workshopType.isInstance(car));
    }

    public boolean tryAddCar(Car car) {
        if (acceptsCar(car)) {
            carList.add(workshopType.cast(car));

            return true;
        }
        return false;
    }
}
