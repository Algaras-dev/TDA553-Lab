package test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.Color;
import java.awt.geom.Point2D;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.vehicles.Direction;
import test.mocks.MockVehicle;

public class TestVehicle {

    private MockVehicle car;

    @BeforeEach
    public void setup() {
        car = new MockVehicle(4, Color.BLACK, 60, "Testing Vehicle", 1000, 4600, 1800);
    }

    // Testing get/set methods
    @Test
    void testGetNrDoors() {
        assertEquals(4, car.getNrDoors());
    }

    @Test
    void testGetModelName() {
        assertEquals("Testing Vehicle", car.getModelName());
    }

    @Test
    void testGetColor() {
        assertEquals(Color.BLACK, car.getColor());
    }

    @Test
    void testSetColor() {
        car.setColor(Color.BLUE);
        assertEquals(Color.BLUE, car.getColor());
    }

    @Test
    void testGetEnginePower() {
        assertEquals(60, car.getEnginePower());
    }

    @Test
    void testGetCurrentSpeed() {
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    void testGetDirection() {
        assertEquals(Direction.NORTH, car.getDirection());
    }

    @Test
    void testGetLocation() {
        assertEquals(new Point2D.Double(0, 0), car.getLocation());
    }

    // Testing control methods
    @Test
    void testStartEngine() {
        car.startEngine();
        assertEquals(0.1, car.getCurrentSpeed());
    }

    @Test
    void testStopEngine() {
        car.stopEngine();
        assertEquals(0, car.getCurrentSpeed());
    }

    @Test
    void testGas() {
        car.startEngine();
        car.gas(1);
        assertTrue(car.getCurrentSpeed() > 0.1);
    }

    @Test
    void testBrake() {
        car.startEngine();
        car.brake(1);
        assertTrue(car.getCurrentSpeed() < 0.1 && car.getCurrentSpeed() >= 0);
    }

    @Test
    void testGasOnlyIncreases() {
        car.gas(1);

        double speed = car.getCurrentSpeed();
        car.gas(-1);
        assertTrue(car.getCurrentSpeed() >= speed);
    }

    @Test
    void testBrakeOnlyDecreases() {
        car.gas(1);
        car.gas(1);

        double speed = car.getCurrentSpeed();
        car.brake(-1);
        assertTrue(car.getCurrentSpeed() <= speed);
    }

    @Test
    void testSpeedDoesNotExceedEnginePower() {
        car.startEngine();
        for (int i = 0; i < 100; i++) {
            car.gas(1);
        }
        assertTrue(car.getCurrentSpeed() <= car.getEnginePower());
    }

    @Test
    void testTurnRight() {
        car.turnRight();
        assertEquals(Direction.EAST, car.getDirection());
        car.turnRight();
        assertEquals(Direction.SOUTH, car.getDirection());
        car.turnRight();
        assertEquals(Direction.WEST, car.getDirection());
        car.turnRight();
        assertEquals(Direction.NORTH, car.getDirection());
    }

    @Test
    void testTurnLeft() {
        car.turnLeft();
        assertEquals(Direction.WEST, car.getDirection());
        car.turnLeft();
        assertEquals(Direction.SOUTH, car.getDirection());
        car.turnLeft();
        assertEquals(Direction.EAST, car.getDirection());
        car.turnLeft();
        assertEquals(Direction.NORTH, car.getDirection());
    }

    @Test
    void testMove() {
        car.startEngine();
        car.move();
        assertEquals(new Point2D.Double(0, car.getCurrentSpeed()), car.getLocation());

        car.turnRight();
        car.move();
        assertEquals(new Point2D.Double(car.getCurrentSpeed(), car.getCurrentSpeed()), car.getLocation());

        car.turnRight();
        car.move();
        assertEquals(new Point2D.Double(car.getCurrentSpeed(), 0), car.getLocation());

        car.turnRight();
        car.move();
        assertEquals(new Point2D.Double(0, 0), car.getLocation());

    }
}
