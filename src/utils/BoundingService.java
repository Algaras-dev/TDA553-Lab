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
}

// Old:
/*
 * private Rectangle2D.Double getBounds(Drawable item) {
 * 
 * }
 */
