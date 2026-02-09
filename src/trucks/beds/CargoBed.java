package src.trucks.beds;

public class CargoBed implements TruckBed {
    private int angle;
    private int maxAngle;

    public CargoBed(int maxAngle) {
        this.maxAngle = maxAngle;
    }

    public int getAngle() {
        return angle;
    }

    public boolean inDrivingPosition() {
        return getAngle() == 0;
    }

    public void raise(int degrees) {
        angle = Math.min(getAngle() + degrees, maxAngle);
    }

    public void lower(int degrees) {
        angle = Math.max(getAngle() - degrees, 0);
    }

}
