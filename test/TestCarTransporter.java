package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.cars.Volvo240;
import src.trucks.CarTransport;
import src.trucks.beds.CarBed;

class TestCarTransport {
    private CarTransport truck;
    private CarBed bed;
    private Volvo240 volvo;

    @BeforeEach
    public void setup() {
        bed = new CarBed();
        truck = new CarTransport(bed);
        volvo = new Volvo240();
    }

    @Test
    void testLowerRamp() {
        truck.lowerRamp();
        assertFalse(bed.inDrivingPosition());
    }

    @Test
    void testRaiseRamp() {
        truck.lowerRamp();
        truck.raiseRamp();
        assertTrue(bed.inDrivingPosition());
    }

    @Test
    void testOnlyLowerAtStandStill() {
        truck.startEngine();
        truck.lowerRamp();
        assertTrue(bed.inDrivingPosition());
    }

    @Test
    void testLoad() {
        truck.lowerRamp();
        truck.loadCar(volvo);
        assertEquals(truck.getLoad().get(0), volvo);
    }

    @Test
    void testUnload() {
        truck.lowerRamp();
        assertTrue(!bed.inDrivingPosition());

        truck.loadCar(volvo);

        Volvo240 unloaded = (Volvo240) truck.unloadCar();
        assertEquals(unloaded, volvo);
    }

    @Test
    void testLoadNotInRadius() {
        truck.lowerRamp();
        volvo.setLocation(30, 0);
        truck.loadCar(volvo);
        assertEquals(truck.getLoad().size(), 0);
    }

    @Test
    void testLocationUpdates() {
        truck.lowerRamp();
        truck.loadCar(volvo);
        truck.raiseRamp();
        truck.startEngine();
        truck.gas(1);
        truck.move();
        assertArrayEquals(volvo.getLocation(), truck.getLocation());
    }
}