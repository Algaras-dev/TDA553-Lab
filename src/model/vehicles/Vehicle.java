package src.model.vehicles;

import java.awt.Color;

import src.model.Drawable;
import src.utils.DoublePoint;

public abstract class Vehicle implements Movable, Drawable {

    // Vehicle specs
    private String modelName;
    private Color color;
    private int nrDoors;
    private double enginePower;
    private int weight;
    private int length;
    private int width;

    // Movement
    private double currentSpeed;
    private DoublePoint location;
    private Direction direction = Direction.NORTH;

    public Vehicle(int nrDoors, Color color, double enginePower, String modelName, int weight, int length, int width) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.location = new DoublePoint(0, 0);
        stopEngine();
    }

    public String getModelName() {
        return modelName;
    }

    // Alternate name for complying with <<Drawable>>
    public String getName() {
        return getModelName();
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public int getWeight() {
        return weight;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setLocation(double x, double y) {
        location = new DoublePoint(x, y);
    }

    @Override
    public void setLocation(DoublePoint point) {
        location = new DoublePoint(point);
    }

    @Override
    public DoublePoint getLocation() {
        return new DoublePoint(location);
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    protected double speedMultiplier() {
        return 1.0;
    }

    private double speedFactor() {
        return getEnginePower() * 0.01 * speedMultiplier();
    }

    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower());
    }

    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    private double clampSpeed(double speed) {
        return Math.min(Math.max(0, speed), 1);
    }

    public void gas(double amount) {
        incrementSpeed(clampSpeed(amount));
    }

    public void brake(double amount) {
        decrementSpeed(clampSpeed(amount));
    }

    public void move() {

        double speed = getCurrentSpeed();

        switch (direction) {
            case NORTH -> location = location.translate(0, speed);
            case EAST -> location = location.translate(speed, 0);
            case SOUTH -> location = location.translate(0, -speed);
            case WEST -> location = location.translate(-speed, 0);
        }
    }

    public void turnRight() {
        direction = direction.rotateRight();
    }

    public void turnLeft() {
        direction = direction.rotateLeft();
    }

    public void turnAround() {
        direction = direction.opposite();
    }
}
