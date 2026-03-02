package src.model.vehicles.cars;

import java.awt.Color;

import src.model.vehicles.Vehicle;

public abstract class Car extends Vehicle {

    public Car(int nrDoors, Color color, double enginePower, String modelName, int weight, int length, int width) {
        super(nrDoors, color, enginePower, modelName, weight, length, width);
    }
}
