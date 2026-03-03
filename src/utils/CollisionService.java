package src.utils;

import java.awt.Dimension;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class CollisionService {
    public static boolean collidesWithEdges(Dimension frameSize, Rectangle2D.Double bounds) {

        if (bounds.y < 0
                || bounds.y + bounds.height > frameSize.height
                || bounds.x < 0
                || bounds.x + bounds.width > frameSize.width) {
            return true;
        }

        return false;
    }
}
