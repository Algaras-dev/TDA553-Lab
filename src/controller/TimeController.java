package src.controller;

import javax.swing.Timer;

import src.model.WorldModel;
import src.view.WorldPanel;

public class TimeController {

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer;

    private final WorldModel model;
    private final WorldPanel panel;

    public TimeController(int delay, WorldModel model, WorldPanel panel) {
        this.delay = delay;
        this.model = model;
        this.panel = panel;
    }

    public void start() {
        timer = new Timer(delay, _ -> {
            model.update();

            panel.updateObjects(model.getDrawableObjects());
            panel.repaint();
        });
        timer.start();
    }
}
