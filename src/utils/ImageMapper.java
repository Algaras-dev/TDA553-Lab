package src.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class ImageMapper {
    /**
     * Create map of images to names
     */
    public static Map map() {
        Map<String, BufferedImage> map = new HashMap<>();
        try {
            File[] files = new File("pics").listFiles();
            if (files != null) {
                for (File file : files) {

                    // Assuming all vehicle images have their model name as image file name
                    String name = file.getName().substring(0, file.getName().lastIndexOf('.'));
                    BufferedImage image = ImageIO.read(file);

                    map.put(name, image);
                }

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return map;
    }
}