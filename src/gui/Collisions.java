package src.gui;

import java.awt.Dimension;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class Collisions {
    public static boolean valueInRange(double value, double min, double max) {
        return (min < value && value < max);
    }

    public static boolean rectangleOverlaps(Rectangle2D.Double rectA, Rectangle2D.Double rectB) {
        return rectangleOverlaps(
                rectA.x, rectA.y, rectA.width, rectA.height,
                rectB.x, rectB.y, rectB.width, rectB.height);
    }

    public static boolean rectangleOverlaps(
            double xA, double yA, double widthA, double heightA,
            double xB, double yB, double widthB, double heightB) {

        // x: [workshop.x - car.width, workshop.x + workshop.width]
        // y: [workshop.y - car.height, workshop.y + workshop.height]

        double xmin = xB - widthA;
        double xmax = xB + widthB;

        double ymin = yB - heightA;
        double ymax = yB + heightB;

        return valueInRange(xA, xmin, xmax) && valueInRange(yA, ymin, ymax);

    }

    public static boolean collidesWithEdges(JPanel drawPanel, Rectangle2D.Double bounds) {
        Dimension frameSize = drawPanel.getSize();

        if (bounds.y < 0
                || bounds.y + bounds.height > frameSize.height
                || bounds.x < 0
                || bounds.x + bounds.width > frameSize.width) {
            return true;
        }

        return false;
    }
}
