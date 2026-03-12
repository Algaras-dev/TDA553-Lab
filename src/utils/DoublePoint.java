package src.utils;

// Immutable point using doubles
public class DoublePoint {
    public final double x;
    public final double y;

    public DoublePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public DoublePoint(DoublePoint point) {
        this.x = point.x;
        this.y = point.y;
    }

    /**
     * Translate point relatively
     * 
     * @return moved point
     */
    public DoublePoint translate(double x, double y) {
        return new DoublePoint(this.x + x, this.y + y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        DoublePoint other = (DoublePoint) obj;

        return Double.compare(other.x, x) == 0 &&
                Double.compare(other.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(x, y);
    }
}
