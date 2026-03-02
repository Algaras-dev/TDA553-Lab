package src.model;

import src.utils.DoublePoint;

public interface Drawable {
    public DoublePoint getLocation();

    public void setLocation(DoublePoint newLocation);

    public String getName();
}
