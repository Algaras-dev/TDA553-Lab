package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import src.model.Drawable;
import src.model.WorldModel;
import src.model.vehicles.Vehicle;
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

        // Objects in frame
        List<Vehicle> objects = new ArrayList<>();
        objects.add(new Volvo240());
        objects.getLast().setLocation(300, 0);

        objects.add(new Saab95());
        objects.getLast().setLocation(0, 100);

        objects.add(new Scania());
        objects.getLast().setLocation(0, 200);

        WorldModel model = new WorldModel();
        // View(s)
        // Controller(s)

        ActionListener drawFrame = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                model.onTick();
            }
        };

        timer = new Timer(delay, drawFrame);

    }

}
