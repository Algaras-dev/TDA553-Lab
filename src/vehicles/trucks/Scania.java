package src.vehicles.trucks;

import java.awt.Color;

import src.vehicles.trucks.beds.CargoBed;

public class Scania extends Truck<CargoBed> {

    public Scania() {
        this(new CargoBed(70));
    }

    public Scania(CargoBed bed) {
        super(2, Color.BLACK, 200, "Scania", bed, 9060, 5933, 2476);
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
