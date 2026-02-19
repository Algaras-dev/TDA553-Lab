package src.vehicles.cars;

import java.awt.Color;

public class Volvo240 extends Car {

    private static final double trimFactor = 1.25;

    public Volvo240() {
        super(4, Color.BLACK, 100, "Volvo240", 1300, 4790, 1720);
    }

    @Override
    protected double speedMultiplier() {
        return trimFactor;
    }

}
