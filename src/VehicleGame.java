package src;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import src.controller.TimeController;
import src.controller.VehicleController;
import src.model.WorldModel;
import src.model.buildings.Workshop;
import src.model.buildings.WorkshopManager;
import src.model.vehicles.Vehicle;
import src.model.vehicles.VehicleFactory;
import src.model.vehicles.VehicleManager;
import src.model.vehicles.cars.Car;
import src.model.vehicles.cars.Volvo240;
import src.view.MainFrame;
import src.view.VehicleControlPanel;
import src.view.WorldPanel;

public class VehicleGame {

    public static void main(String[] args) {
        // Set frame and world size
        final int width = 1000;
        final int height = 800;
        final int worldPanelHeight = height * 2 / 3;
        final int controlWidgetHeight = height * 1 / 3;

        // * Model(s)
        // Vehicle objects in frame
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(VehicleFactory.createVolvo240(300, 0));
        vehicles.add(VehicleFactory.createSaab95(0, 100));
        vehicles.add(VehicleFactory.createScania(0, 200));

        VehicleManager vehicleManager = new VehicleManager();
        vehicleManager.add(vehicles);

        // Workshop objects in frame
        List<Workshop<? extends Car>> workshops = new ArrayList<>();
        workshops.add(new Workshop<>(10, 300, 300, Volvo240.class));

        WorkshopManager workshopManager = new WorkshopManager();
        workshopManager.add(workshops);

        WorldModel model = new WorldModel(new Dimension(width, worldPanelHeight), vehicleManager, workshopManager);

        // * View(s)
        MainFrame frame = new MainFrame(width, height, "CarGame");
        WorldPanel worldPanel = new WorldPanel(width, worldPanelHeight);
        VehicleControlPanel controlWidget = new VehicleControlPanel(width, controlWidgetHeight);

        // Build view
        frame.add(worldPanel);
        frame.add(controlWidget);
        frame.display();

        // * Controller(s)
        VehicleController controller = new VehicleController(model, controlWidget);
        TimeController timeController = new TimeController(50, controller, worldPanel);

        timeController.start();
    }
}
