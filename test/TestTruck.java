package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.trucks.Truck;
import src.trucks.beds.CargoBed;
import test.mocks.MockTruck;

public class TestTruck {
    private CargoBed bed;
    private Truck truck;

    @BeforeEach
    public void setup() {
        bed = new CargoBed(50);
        truck = new MockTruck(2, Color.WHITE, 240, "Mock Truck", bed, 5200, 5400, 2300);
    }

    @Test
    void testEngineStart() {
        bed.raise(1);
        assertTrue(!bed.inDrivingPosition());

        truck.startEngine();
        assertEquals(truck.getCurrentSpeed(), 0.0);
    }

    @Test
    void testGas() {
        bed.raise(1);
        assertTrue(!bed.inDrivingPosition());

        truck.gas(1);
        assertEquals(truck.getCurrentSpeed(), 0.0);
    }
}
