package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.buildings.Workshop;
import src.vehicles.cars.Car;
import src.vehicles.cars.Saab95;

public class TestWorkshop {
    private Workshop<Car> carWorkshop;
    private Workshop<Saab95> saabWorkshop;

    private Saab95 saab;
    private Car car;

    @BeforeEach
    void setup() {
        carWorkshop = new Workshop<>(4, Car.class);
        saabWorkshop = new Workshop<>(2, Saab95.class);

        saab = new Saab95();
        car = new Saab95();
    }

    @Test
    void testWideWorkshop() {
        carWorkshop.addCar(saab);
        carWorkshop.addCar(car);
    }

    @Test
    void testNarrowWorkshop() {
        saabWorkshop.addCar(saab);
        // saabWorkshop.addCar(car); // Won't compile if enabled
    }

    @Test
    // Compiles, and therefore shows specific return type for specific workshop
    void testReturnType() {
        saabWorkshop.addCar(saab);

        Saab95 saab = saabWorkshop.returnCar();
    }
}
