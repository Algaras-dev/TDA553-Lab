package src.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

import src.buildings.Workshop;
import src.vehicles.Vehicle;
import src.vehicles.cars.Car;
import src.vehicles.cars.Saab95;
import src.vehicles.cars.Volvo240;
import src.vehicles.trucks.Scania;

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
        cc.vehicles.getLast().setLocation(300, 0);

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
        private List<Car> toRemove = new ArrayList<>();

        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                Rectangle2D.Double vehicleBounds = getBounds(vehicle);

                if (Collisions.collidesWithEdges(frame.drawPanel, vehicleBounds)) {
                    vehicle.turnAround();
                }
                vehicle.move();

                if (vehicle instanceof Car) {
                    enterWorkshop((Car) vehicle, vehicleBounds);
                }
            }

            // Remove any cars parked in workshops
            for (Vehicle vehicle : toRemove) {
                vehicles.remove(vehicle);
                frame.drawPanel.removeObject(vehicle);
            }
            toRemove.clear();

            frame.drawPanel.repaint();
        }

        private void enterWorkshop(Car car, Rectangle2D.Double vehicleBounds) {
            for (Workshop<? extends Car> workshop : frame.drawPanel.workshops) {
                Rectangle2D.Double workshopBounds = getBounds(workshop);

                if (vehicleBounds.intersects(workshopBounds)) {
                    boolean added = workshop.tryAddCar(car);

                    if (added) { // Remove car from list of vehicles and list of objects
                        car.stopEngine();
                        toRemove.add(car);
                    }
                }
            }
        }
    }

    private Rectangle2D.Double getBounds(Drawable item) {
        Point2D.Double location = item.getLocation();
        int[] size = frame.drawPanel.getImageSize(item);
        Rectangle2D.Double workshopBounds = new Rectangle2D.Double(
                location.x, location.y, size[0], size[1]);
        return workshopBounds;
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
                ((Saab95) vehicle).setTurboOn();
            }
        }
    }

    void turboOff() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    void liftBed() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).raiseBed(70);
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
