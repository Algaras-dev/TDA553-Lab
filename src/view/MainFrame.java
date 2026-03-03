package src.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
    private int X;
    private int Y;

    public MainFrame(int X, int Y, String frameName) {
        this.X = X;
        this.Y = Y;

        this.setTitle(frameName);

        this.setPreferredSize(new Dimension(X, Y));
    }

    public void display() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Center the frame
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);

        // Make the frame visible
        this.setVisible(true);

        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
