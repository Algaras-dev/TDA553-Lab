package src.utils;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class ImageMapper {
    private static Map<String, BufferedImage> imageMap = new HashMap<>();
    private static Map<String, Dimension> imageSizeMap = new HashMap<>();

    static {
        try {
            File[] files = new File("pics").listFiles();
            if (files != null) {
                for (File file : files) {

                    // Assuming all vehicle images have their model name as image file name
                    String name = file.getName().substring(0, file.getName().lastIndexOf('.'));
                    BufferedImage image = ImageIO.read(file);

                    imageMap.put(name, image);
                    imageSizeMap.put(name, new Dimension(image.getWidth(), image.getHeight()));
                }

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static BufferedImage getImage(String name) {
        return imageMap.get(name);
    }

    public static Dimension getImageSize(String name) {
        return imageSizeMap.get(name);
    }
}
