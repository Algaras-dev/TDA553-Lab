package src.gui;

import javax.swing.*;

import src.Vehicle;
import src.cars.Car;
import src.cars.Saab95;
import src.cars.Volvo240;
import src.trucks.Scania;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // * Member fields
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    // * Methods
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.vehicles.add(new Volvo240());

        cc.vehicles.add(new Saab95());
        cc.vehicles.getLast().setLocation(0, 100);

        cc.vehicles.add(new Scania());
        cc.vehicles.getLast().setLocation(0, 200);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /*
     * Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {

                Dimension frameSize = frame.drawPanel.getSize();
                Point2D.Double location = vehicle.getLocation();
                int vehicle_height = frame.drawPanel.imageMap.get(vehicle.getName()).getHeight();
                int vehicle_width = frame.drawPanel.imageMap.get(vehicle.getName()).getWidth();

                // * Bounce car on wall
                // North
                if (location.y < 0) {
                    vehicle.turnAround();
                }
                // South
                if (location.y + vehicle_height > frameSize.height) {
                    vehicle.turnAround();
                }
                // West
                if (location.x < 0) {
                    vehicle.turnAround();
                }
                // East
                if (location.x + vehicle_width > frameSize.width) {
                    vehicle.turnAround();
                }

                vehicle.move();
            }
            frame.drawPanel.repaint();
        }
    }

    // Calls the gas method for each car once
    void gas(double amount) {
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(amount);
        }
    }

    void brake(double amount) {
        for (Vehicle vehicle : vehicles) {
            vehicle.brake(amount);
        }
    }

    void startAll() {
        for (Vehicle vehicle : vehicles) {
            vehicle.startEngine();
        }
    }

    void stopAll() {
        for (Vehicle vehicle : vehicles) {
            vehicle.stopEngine();
        }
    }

    void turboOn() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95)vehicle).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95)vehicle).setTurboOff();
            }
        }
    }

    void liftBed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Scania)vehicle).raiseBed(70);
            }
        }
    }

    void lowerBed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).lowerBed(70);
            }
        }
    }
}
