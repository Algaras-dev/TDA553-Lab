package src.gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;

import src.Drawable;
import src.Vehicle;
import src.Workshop;
import src.cars.Car;
import src.cars.Volvo240;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {
    ArrayList<Drawable> objects;
    Map<String, BufferedImage> imageMap = new HashMap<>();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Vehicle> vehicles) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        try {
            // Create map of images to names
            File[] files = new File("pics").listFiles();
            if (files != null) {
                for (File file : files) {

                    // Assuming all vehicle images have their model name as image file name
                    String name = file.getName().substring(0, file.getName().lastIndexOf('.'));
                    BufferedImage image = ImageIO.read(file);

                    imageMap.put(name, image);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Add all cars as objects
        objects = new ArrayList<>(vehicles);

        // Add additional items
        Workshop<Volvo240> volvoWorkshop = new Workshop<>(10, 300, 300, "VolvoWorkshop");
        objects.add(volvoWorkshop);

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Drawable object : objects) {
            int x = (int) Math.round(object.getLocation().x);
            int y = (int) Math.round(object.getLocation().y);

            g.drawImage(imageMap.get(object.getName()), x, y, null);
        }
    }
}
