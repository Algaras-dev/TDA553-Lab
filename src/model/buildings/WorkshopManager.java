package src.model.buildings;

import java.util.ArrayList;
import java.util.List;

import src.model.vehicles.Vehicle;
import src.model.vehicles.cars.Car;
import src.utils.BoundingService;

public class WorkshopManager {
    private List<Workshop<? extends Car>> workshops = new ArrayList<>();

    public List<Workshop<? extends Car>> getWorkshops() {
        return List.copyOf(workshops);
    }

    public void add(Workshop<? extends Car> workshop) {
        workshops.add(workshop);
    }

    public void add(List<Workshop<? extends Car>> workshops) {
        for (Workshop<? extends Car> workshop : workshops) {
            add(workshop);
        }
    }

    public void removeWorkshop(Workshop<? extends Car> workshop) {
        workshops.remove(workshop);
    }

    public boolean tryEnterWorkshop(Car car) {
        for (Workshop<? extends Car> workshop : workshops) {

            if (BoundingService.objectsIntersect(car, workshop)) {
                // Check if workshop accepts the vehicle type and workshop is not full
                boolean added = workshop.tryAddCar(car);

                if (added) {
                    car.stopEngine();
                    return true;
                }
            }
        }
        return false;
    }

    public List<Vehicle> tryEnterWorkshop(List<Vehicle> vehicles) {
        List<Vehicle> toRemove = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car car) {
                boolean added = tryEnterWorkshop(car);

                if (added) {
                    toRemove.add(vehicle);
                }
            }
        }

        return toRemove;
    }
}
