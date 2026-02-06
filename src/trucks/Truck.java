package src.trucks;

import java.awt.Color;

import src.Vehicle;
import src.trucks.beds.TruckBed;

public abstract class Truck extends Vehicle {

    protected final TruckBed bed;

    public Truck(int nrDoors, Color color, double enginePower, String modelName, TruckBed bed) {
        super(nrDoors, color, enginePower, modelName);

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
}
