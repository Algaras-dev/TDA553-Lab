package src.model;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

import src.model.buildings.Workshop;
import src.model.buildings.WorkshopManager;
import src.model.vehicles.Vehicle;
import src.model.vehicles.VehicleManager;
import src.model.vehicles.cars.Car;
import src.utils.ImageMapper;

public class WorldModel {
    private static Map<String, BufferedImage> imageMap = ImageMapper.map();

    public VehicleManager vehicleManager = new VehicleManager();
    public WorkshopManager workshopManager = new WorkshopManager();

    public WorldModel() {
    }

    public WorldModel(List<Vehicle> vehicles, List<Workshop<? extends Car>> workshops) {
        for (Vehicle vehicle : vehicles) {
            vehicleManager.addVehicle(vehicle);
        }
        for (Workshop<? extends Car> workshop : workshops) {
            workshopManager.addWorkshop(workshop);
        }
    }

    public void onTick() {

    }
}
