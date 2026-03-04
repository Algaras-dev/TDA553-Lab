package src.utils;

import java.awt.Dimension;
import java.awt.geom.Rectangle2D;

import src.model.Drawable;

public class BoundingService {
    public static Rectangle2D.Double getBounds(Drawable object) {
        DoublePoint location = object.getLocation();
        Dimension size = ImageMapper.getImageSize(object.getName());

        return new Rectangle2D.Double(
                location.x, location.y, size.width, size.height);
    }

    public static boolean collidesWithFrameBounds(Dimension frameSize, Drawable object) {
        Rectangle2D.Double objectBounds = getBounds(object);

        return collidesWithFrameBounds(frameSize, objectBounds);
    }

    public static boolean collidesWithFrameBounds(Dimension frameSize, Rectangle2D.Double bounds) {

        if (bounds.y < 0
                || bounds.y + bounds.height > frameSize.height
                || bounds.x < 0
                || bounds.x + bounds.width > frameSize.width) {
            return true;
        }

        return false;
    }
}
