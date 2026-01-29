package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.Saab95;

public class TestSaab {
    private Saab95 car;

    @BeforeEach
    public void setup() {
        car = new Saab95();
    }

    @Test
    void testConstructor() {
        assertEquals(2, car.getNrDoors());
        assertEquals(Color.RED, car.getColor());
        assertEquals(125, car.getEnginePower());
        assertEquals("Saab95", car.getModelName());
    }

    @Test
    void testTurboOn() {
        car.setTurboOn();
        car.gas(1);

        assertEquals(1.625, car.getCurrentSpeed());
    }

    @Test
    void testTurboOff() {
        car.setTurboOff();
        car.gas(1);

        assertEquals(1.25, car.getCurrentSpeed());
    }
}
