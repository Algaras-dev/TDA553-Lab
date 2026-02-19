package src.gui;

import java.awt.Dimension;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class Collisions {
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
