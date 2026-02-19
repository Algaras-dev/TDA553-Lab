package src.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import src.buildings.Workshop;
import src.vehicles.Vehicle;
import src.vehicles.cars.Volvo240;

// This panel represents the animated part of the view with the car images.
public class DrawPanel extends JPanel {
    private ArrayList<Drawable> objects = new ArrayList<>();
    private Map<String, BufferedImage> imageMap = new HashMap<>();
    List<Workshop<?>> workshops = new ArrayList<>();

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<? extends Vehicle> vehicles) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);

        // Create map of images to names
        try {
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

        // Create workshop(s)
        workshops.add(new Workshop<>(10, 300, 300, Volvo240.class));

        // Add all drawable objects
        objects.addAll(vehicles);
        objects.addAll(workshops);

    }

    /*
     * Width and height of image (in that order)
     */
    public int[] getImageSize(Drawable item) {
        BufferedImage image = imageMap.get(item.getName());

        if (image != null) {
            return new int[] { image.getWidth(), image.getHeight() };
        }
        return new int[] { 0, 0 };
    }

    public void removeObject(Drawable object) {
        objects.remove(object);
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
