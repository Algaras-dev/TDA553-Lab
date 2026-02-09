package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.trucks.Scania;
import src.trucks.beds.CargoBed;

class TestScania {
    private Scania truck;
    private CargoBed bed;

    @BeforeEach
    public void setup() {
        bed = new CargoBed(70);
        truck = new Scania(bed);
    }

    @Test
    void testRaiseBed() {
        truck.raiseBed(45);
        assertEquals(bed.getAngle(), 45);
    }

    @Test
    void testLowerBed() {
        truck.raiseBed(70);
        truck.lowerBed(30);
        assertEquals(bed.getAngle(), 40);
    }

    @Test
    void testOnlyRaiseAtStandStill() {
        truck.startEngine();
        truck.raiseBed(45);
        assertEquals(bed.getAngle(), 0);
    }
}
