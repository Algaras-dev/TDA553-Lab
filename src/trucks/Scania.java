package src.trucks;

import java.awt.*;

import src.trucks.beds.CargoBed;

public class Scania extends Truck {
    private final CargoBed bed;

    public Scania() {
        this(new CargoBed(70));
    }

    private Scania(CargoBed bed) {
        super(2, Color.BLACK, 200, "Scania", bed, 9060, 5933, 2476);
        this.bed = bed;
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
