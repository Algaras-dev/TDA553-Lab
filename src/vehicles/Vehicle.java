package src.vehicles;

import java.awt.Color;
import java.awt.geom.Point2D;

import src.gui.Drawable;

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
    private Point2D.Double location;
    private Direction direction = Direction.NORTH;

    public Vehicle(int nrDoors, Color color, double enginePower, String modelName, int weight, int length, int width) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.location = new Point2D.Double(0, 0);
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

    public void setLocation(double newX, double newY) {
        location.x = newX;
        location.y = newY;
    }

    public Point2D.Double getLocation() {
        return new Point2D.Double(location.x, location.y);
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
            case NORTH -> location.y += speed;
            case EAST -> location.x += speed;
            case SOUTH -> location.y -= speed;
            case WEST -> location.x -= speed;
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
