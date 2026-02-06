package src.trucks;

import java.awt.*;

import src.trucks.beds.CarBed;

public class CarTransport extends Truck {
    public CarTransport() {
        super(2, Color.GRAY, 220, "Car Transporter", new CarBed());
    }

    public void lowerRamp() {
        if (getCurrentSpeed() == 0) {
            bed.lower();
        }
    }

}
