package src.model;

import java.awt.Dimension;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import src.model.buildings.Workshop;
import src.model.buildings.WorkshopManager;
import src.model.vehicles.Vehicle;
import src.model.vehicles.VehicleManager;
import src.model.vehicles.cars.Car;
import src.utils.BoundingService;
import src.utils.CollisionService;

public class WorldModel {
    private Dimension worldSize;
    public VehicleManager vehicleManager = new VehicleManager();
    public WorkshopManager workshopManager = new WorkshopManager();

    public WorldModel(Dimension worldSize, List<Vehicle> vehicles, List<Workshop<? extends Car>> workshops) {
        this.worldSize = worldSize;
        for (Vehicle vehicle : vehicles) {
            vehicleManager.addVehicle(vehicle);
        }
        for (Workshop<? extends Car> workshop : workshops) {
            workshopManager.addWorkshop(workshop);
        }
    }

    public List<Drawable> getDrawableObjects() {
        List<Drawable> drawableObjects = new ArrayList<Drawable>();
        drawableObjects.addAll(List.copyOf(vehicleManager.getVehicles()));
        drawableObjects.addAll(List.copyOf(workshopManager.getWorkshops()));

        return drawableObjects;
    }

    public void update() {
        for (Vehicle vehicle : vehicleManager.getVehicles()) {
            Rectangle2D.Double vehicleBounds = BoundingService.getBounds(vehicle);

            if (CollisionService.collidesWithEdges(worldSize, vehicleBounds)) {
                vehicle.turnAround();
            }

            vehicle.move();

            if (vehicle instanceof Car) {
                boolean added = workshopManager.tryEnterWorkshop((Car) vehicle, vehicleBounds);

                if (added) {
                    vehicleManager.removeVehicle(vehicle);
                }
            }
        }
    }
}
