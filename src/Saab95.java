package src;
import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn = false;

    public Saab95() {
        super(2, Color.RED, 125, "Saab95");
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    protected double speedMultiplier() {
        return turboOn ? 1.3 : 1.0;
    }

}
