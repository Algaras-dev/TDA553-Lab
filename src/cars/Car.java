package src.cars;

import java.awt.Color;

import src.Vehicle;

public abstract class Car extends Vehicle {

    public Car(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
    }
}
