package src.vehicles.trucks;

import java.awt.Color;

import src.vehicles.Vehicle;
import src.vehicles.trucks.beds.TruckBed;

public abstract class Truck<B extends TruckBed> extends Vehicle {

    protected final B bed;

    public Truck(int nrDoors, Color color, double enginePower, String modelName, B bed, int weight, int length, int width) {
        super(nrDoors, color, enginePower, modelName, weight, length, width);
        this.bed = bed;
    }

    @Override
    public void startEngine() {
        if (bed.inDrivingPosition()) {
            super.startEngine();
        }
    }

    @Override
    public void gas(double amount) {
        if (bed.inDrivingPosition()) {
            super.gas(amount);
        }
    }

    @Override
    protected double speedMultiplier() {
        return 0.5;
    }
}
