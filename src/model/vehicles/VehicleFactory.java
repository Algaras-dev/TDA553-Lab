package src.model.vehicles;

import src.model.vehicles.cars.Saab95;
import src.model.vehicles.cars.Volvo240;
import src.model.vehicles.trucks.CarTransport;
import src.model.vehicles.trucks.Scania;
import src.utils.DoublePoint;

public class VehicleFactory {
    public static Vehicle createVolvo240(double x, double y) {
        Vehicle v = new Volvo240();
        v.setLocation(new DoublePoint(x, y));
        return v;
    }

    public static Vehicle createSaab95(double x, double y) {
        Vehicle v = new Saab95();
        v.setLocation(new DoublePoint(x, y));
        return v;
    }

    public static Vehicle createScania(double x, double y) {
        Vehicle v = new Scania();
        v.setLocation(new DoublePoint(x, y));
        return v;
    }

    public static Vehicle createCarTransport(double x, double y) {
        Vehicle v = new CarTransport();
        v.setLocation(new DoublePoint(x, y));
        return v;
    }
}
