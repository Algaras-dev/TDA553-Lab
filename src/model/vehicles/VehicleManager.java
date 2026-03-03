package src.model.vehicles;

import java.util.List;

import src.model.vehicles.cars.Saab95;
import src.model.vehicles.trucks.Scania;

import java.util.ArrayList;

public class VehicleManager {
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public List<Vehicle> getVehicles() {
        return new ArrayList<>(vehicles);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public void gas(double amount) {
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(amount);
        }
    }

    public void brake(double amount) {
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(amount);
        }
    }

    public void startAll() {
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }

    public void stopAll() {
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }

    public void turboOn() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    public void turboOff() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    public void liftBed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).raiseBed(70);
            }
        }
    }

    public void lowerBed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).lowerBed(70);
            }
        }
    }
}
