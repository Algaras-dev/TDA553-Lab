package src.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class WorldPanel extends JPanel {
    private int X;
    private int Y;
    
    public WorldPanel(int X, int Y) {
        this.X = X;
        this.Y = Y;

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(X, Y));
        this.setBackground(Color.green);
    }
}
