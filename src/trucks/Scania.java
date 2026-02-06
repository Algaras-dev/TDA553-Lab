package src.trucks;

import java.awt.*;

import src.trucks.beds.CargoBed;

public class Scania extends Truck {
    public Scania() {
        super(2, Color.BLACK, 200, "Scania", new CargoBed(70));
    }

    public void raiseBed(int degrees) {
        if (getCurrentSpeed() == 0) {
            bed.raise(degrees);
        }
    }

    public void lowerBed(int degrees) {
        if (getCurrentSpeed() == 0) {
            bed.lower(degrees);
        }
    }
}
