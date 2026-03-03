package src.model.buildings;

import java.util.ArrayList;
import java.util.List;

import java.awt.geom.Rectangle2D;

import src.model.vehicles.cars.Car;
import src.utils.BoundingService;

public class WorkshopManager {
    private ArrayList<Workshop<? extends Car>> workshops = new ArrayList<>();

    public List<Workshop<? extends Car>> getWorkshops() {
        return List.copyOf(workshops);
    }

    public void addWorkshop(Workshop<? extends Car> workshop) {
        workshops.add(workshop);
    }

    public void removeWorkshop(Workshop<? extends Car> workshop) {
        workshops.remove(workshop);
    }

    public boolean tryEnterWorkshop(Car car, Rectangle2D.Double vehicleBounds) {
        for (Workshop<? extends Car> workshop : workshops) {
            Rectangle2D.Double workshopBounds = BoundingService.getBounds(workshop);

            // Check if vehicle intersects with workshop (proximity check)
            if (vehicleBounds.intersects(workshopBounds)) {
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
}