package src;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

import src.controller.VehicleControlWidget;
import src.view.WorldPanel;

public class MainFrame extends JFrame {
    private static final int X = 800;
    private static final int Y = 800;

    VehicleControlWidget controlWidget = new VehicleControlWidget(X, 240);
    WorldPanel worldPanel = new WorldPanel(X, Y - 240);

    public MainFrame(String frameName) {
        this.setTitle(frameName);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(worldPanel);
        this.add(controlWidget);

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public VehicleControlWidget getControlWidget() {
        return controlWidget;
    }
}