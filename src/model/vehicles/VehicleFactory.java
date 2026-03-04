package src.model.vehicles;

import java.util.Random;
import java.util.function.Supplier;

import src.model.vehicles.cars.Saab95;
import src.model.vehicles.cars.Volvo240;
import src.model.vehicles.trucks.CarTransport;
import src.model.vehicles.trucks.Scania;
import src.utils.DoublePoint;

public class VehicleFactory {

    /**
     * Types of vehicles the factory can make
     */
    public enum Type {
        SAAB95("Saab 95", Saab95::new),
        VOLVO240("Volvo 240", Volvo240::new),
        SCANIA("Scania", Scania::new),
        CARTRANSPORT("Car Transport", CarTransport::new),

        //* Random has to be the last one
        RANDOM("Random Vehicle", () -> {
            final int idx = new Random().nextInt(Type.values().length - 1);

            return Type.values()[idx].createInstance();
        });

        private final String label;
        private final Supplier<Vehicle> constructor;

        Type(String label, Supplier<Vehicle> constructor) {
            this.label = label;
            this.constructor = constructor;
        }

        public Vehicle createInstance() {
            return constructor.get();
        }

        public Class<? extends Vehicle> getInstanceClass() {
            return createInstance().getClass();
        }

        @Override
        public String toString() {
            return label;
        }
    }

    public static Type[] getTypes() {
        return Type.values();
    }

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
