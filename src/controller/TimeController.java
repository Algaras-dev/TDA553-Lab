package src.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        ActionListener updates = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                model.update();

                panel.updateObjects(model.getDrawableObjects());
                panel.repaint();
            }
        };

        timer = new Timer(delay, updates);
        timer.start();
    }
}
