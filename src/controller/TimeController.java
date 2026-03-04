package src.controller;

import javax.swing.Timer;

import src.view.WorldPanel;

public class TimeController {

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer;

    private final VehicleController vehicleController; 
    private final WorldPanel panel;

    public TimeController(int delay, VehicleController vehicleController, WorldPanel panel) {
        this.delay = delay;
        this.vehicleController = vehicleController;
        this.panel = panel;
    }

    public void start() {
        timer = new Timer(delay, _ -> {
            vehicleController.update();

            panel.updateObjects(vehicleController.getDrawableObjects());
            panel.repaint();
        });
        timer.start();
    }
}
