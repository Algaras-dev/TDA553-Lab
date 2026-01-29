import java.awt.Color;

public abstract class Car implements Movable {

    // Car specs
    public String modelName;
    private Color color;
    private int nrDoors;
    private double enginePower;

    // Movement
    private double currentSpeed;
    private double x;
    private double y;
    private Direction direction = Direction.NORTH;

    public Car(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        stopEngine();
    }

    public int getNrDoors() {
        return nrDoors;
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

    // TODO fix this method according to lab pm
    public void gas(double amount) {
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        decrementSpeed(amount);
    }

    public void move() {

        double speed = getCurrentSpeed();

        // Fancy switch to update coordinates
        switch (direction) {
            case NORTH -> y += speed;
            case EAST -> x += speed;
            case SOUTH -> y -= speed;
            case WEST -> x -= speed;
        }
    }

    public void turnRight() {
        direction = direction.rotateRight();
    }

    public void turnLeft() {
        direction = direction.rotateLeft();
    }
}
