package src.model.buildings;

import java.util.ArrayList;

import src.model.Drawable;
import src.model.vehicles.cars.Car;
import src.utils.DoublePoint;

public class Workshop<C extends Car> implements Drawable {
    private int maxCars;
    private ArrayList<C> carList;

    private final Class<C> workshopType;

    private DoublePoint location;

    public Workshop(int maxCars, Class<C> workshopType) {
        this(maxCars, 0, 0, workshopType);
    }

    public Workshop(int maxCars, double x, double y, Class<C> workshopType) {
        this.maxCars = maxCars;
        carList = new ArrayList<C>();
        location = new DoublePoint(x, y);
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

    @Override
    public DoublePoint getLocation() {
        return new DoublePoint(location);
    }

    @Override
    public void setLocation(DoublePoint newLocation) {
        location = new DoublePoint(newLocation);
    }

    public ArrayList<C> getCarList() {
        return carList;
    }

    public Class<C> getType() {
        return workshopType;
    }

    public boolean acceptsCar(Car car) {
        return (workshopType.isInstance(car));
    }

    public boolean tryAddCar(Car car) {
        if (acceptsCar(car) && getCarList().size() < maxCars) {
            carList.add(workshopType.cast(car));

            return true;
        }
        return false;
    }
}
