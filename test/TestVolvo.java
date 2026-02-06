package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.cars.Volvo240;

public class TestVolvo {
    private Volvo240 car;

    @BeforeEach
    public void setup() {
        car = new Volvo240();
    }

    @Test
    void testConstructor() {
        assertEquals(4, car.getNrDoors());
        assertEquals(Color.BLACK, car.getColor());
        assertEquals(100, car.getEnginePower());
        assertEquals("Volvo240", car.getModelName());
    }

    @Test
    void testTrim() {
        double speed = car.getCurrentSpeed();
        car.gas(1);

        assertEquals(speed + 1.25, car.getCurrentSpeed());
    }
}
