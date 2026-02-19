package test.mocks;

import java.awt.Color;

import src.vehicles.Vehicle;

public class MockVehicle extends Vehicle {

    public MockVehicle(int nrDoors, Color color, double enginePower, String modelName, int weight, int length, int width) {
        super(nrDoors, color, enginePower, modelName, weight, length, width);
    }

}
