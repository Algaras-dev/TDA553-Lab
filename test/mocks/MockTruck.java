package test.mocks;

import java.awt.Color;

import src.vehicles.trucks.Truck;
import src.vehicles.trucks.beds.TruckBed;

public class MockTruck extends Truck<TruckBed> {

    public MockTruck(int nrDoors, Color color, double enginePower, String modelName, TruckBed bed, int weight,
            int length, int width) {
        super(nrDoors, color, enginePower, modelName, bed, length, width, weight);
    }
}
