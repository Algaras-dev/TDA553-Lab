package src.model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import src.model.buildings.WorkshopManager;
import src.model.vehicles.Vehicle;
import src.model.vehicles.VehicleManager;

public class WorldModel {
    private Dimension worldSize;
    public VehicleManager vehicleManager;
    public WorkshopManager workshopManager;

    public WorldModel(Dimension worldSize, VehicleManager vehicleManager, WorkshopManager workshopManager) {
        this.worldSize = worldSize;
        this.vehicleManager = vehicleManager;
        this.workshopManager = workshopManager;
    }

    public List<Drawable> getDrawableObjects() {
        List<Drawable> drawableObjects = new ArrayList<Drawable>();
        drawableObjects.addAll(List.copyOf(vehicleManager.getVehicles()));
        drawableObjects.addAll(List.copyOf(workshopManager.getWorkshops()));

        return drawableObjects;
    }

    public void update() {
        vehicleManager.move(worldSize);
        List<Vehicle> toRemove = workshopManager.tryEnterWorkshop(vehicleManager.getVehicles());
        vehicleManager.remove(toRemove);
    }
}
