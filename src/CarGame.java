package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import src.controller.VehicleControlWidget;
import src.controller.VehicleController;
import src.model.WorldModel;
import src.model.buildings.Workshop;
import src.model.vehicles.Vehicle;
import src.model.vehicles.cars.Car;
import src.model.vehicles.cars.Saab95;
import src.model.vehicles.cars.Volvo240;
import src.model.vehicles.trucks.Scania;

public class CarGame {

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final static int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private static Timer timer;

    public static void main(String[] args) {

        // Vehicle objects in frame
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Volvo240());
        vehicles.getLast().setLocation(300, 0);

        vehicles.add(new Saab95());
        vehicles.getLast().setLocation(0, 100);

        vehicles.add(new Scania());
        vehicles.getLast().setLocation(0, 200);

        // Workshop objects in frame
        List<Workshop<? extends Car>> workshops = new ArrayList<>();
        workshops.add(new Workshop<>(10, 300, 300, Volvo240.class));

        WorldModel model = new WorldModel(vehicles, workshops);

        // View(s)
        MainFrame frame = new MainFrame("CarGame");

        // Controller(s)
        VehicleControlWidget controlWidget = frame.getControlWidget();
        VehicleController controller = new VehicleController(model, controlWidget);

        ActionListener drawFrame = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                model.onTick();
            }
        };

        timer = new Timer(delay, drawFrame);

    }

}
