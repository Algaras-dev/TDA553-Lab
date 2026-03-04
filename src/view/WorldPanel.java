package src.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import src.model.Drawable;
import src.utils.ImageMapper;

public class WorldPanel extends JPanel {
    List<Drawable> drawableObjects = new ArrayList<>();

    public WorldPanel(int X, int Y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(X, Y));
        this.setBackground(Color.green);
    }

    public void updateObjects(List<Drawable> updated) {
        this.drawableObjects = updated;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Drawable object : drawableObjects) {
            int x = (int) Math.round(object.getLocation().x);
            int y = (int) Math.round(object.getLocation().y);

            g.drawImage(ImageMapper.getImage(object.getName()), x, y, null);
        }
    }
}
