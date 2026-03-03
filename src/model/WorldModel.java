package src.model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import src.model.buildings.Workshop;
import src.model.vehicles.Vehicle;
import src.model.vehicles.VehicleManager;
import src.utils.ImageMapper;

public class WorldModel {
    private static Map<String, BufferedImage> imageMap = ImageMapper.map();

    public VehicleManager vehicleManager;
    // public WorkshopManager workshopManager;

    public WorldModel() {
    }

    public WorldModel(List<Drawable> objects) {
        for (Drawable object : objects) {
            if (object instanceof Vehicle) {
                vehicleManager.addVehicle((Vehicle) object);
            }

            if (object instanceof Workshop) {
                // workshopManager.addWorkshop((Workshops) object);
            }
        }
    }

    public void onTick() {

    }
}
