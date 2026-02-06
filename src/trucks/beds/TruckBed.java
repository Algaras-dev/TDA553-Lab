package src.trucks.beds;

public abstract class TruckBed {
    private int angle;
    private int maxAngle;

    public TruckBed() {
        maxAngle = 45;
    }

    public TruckBed(int maxAngle) {
        this.maxAngle = maxAngle;
    }

    public int getAngle() {
        return angle;
    }

    public boolean inDrivingPosition() {
        return getAngle() == 0;
    }

    public void raise() {
        angle = maxAngle;
    }

    public void raise(int degrees) {
        angle = Math.min(getAngle() + degrees, maxAngle);
    }

    public void lower() {
        angle = 0;
    }

    public void lower(int degrees) {
        angle = Math.max(getAngle() - degrees, 0);
    }
}
