package src.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VehicleControlPanel extends JPanel implements VehicleControls {
    private final int X;
    private final int Y;

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    double gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton addCarButton = new JButton("Add Car");
    JButton removeCarButton = new JButton("Remove Car");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    public VehicleControlPanel(int X, int Y) {
        this.X = X;
        this.Y = Y;

        initComponents();
    }

    private void initComponents() {

        SpinnerModel spinnerModel = new SpinnerNumberModel(0, // initial value
                0, // min
                100, // max
                1);// step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (double) ((int) ((JSpinner) e.getSource()).getValue()) / 100;
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2, 4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(addCarButton, 3);
        controlPanel.add(brakeButton, 4);
        controlPanel.add(turboOffButton, 5);
        controlPanel.add(lowerBedButton, 6);
        controlPanel.add(removeCarButton, 7);

        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, Y - 40));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);

        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X / 5 - 15, Y - 40));
        this.add(startButton);

        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X / 5 - 15, Y - 40));
        this.add(stopButton);

    }

    @Override
    public void addGasListener(ActionListener l) {
        gasButton.addActionListener(l);
    }

    @Override
    public void addBrakeListener(ActionListener l) {
        brakeButton.addActionListener(l);
    }

    @Override
    public void addStartListener(ActionListener l) {
        startButton.addActionListener(l);
    }

    @Override
    public void addStopListener(ActionListener l) {
        stopButton.addActionListener(l);
    }

    @Override
    public void addTurboOnListener(ActionListener l) {
        turboOnButton.addActionListener(l);
    }

    @Override
    public void addTurboOffListener(ActionListener l) {
        turboOffButton.addActionListener(l);
    }

    @Override
    public void addLiftBedListener(ActionListener l) {
        liftBedButton.addActionListener(l);
    }

    @Override
    public void addLowerBedListener(ActionListener l) {
        lowerBedButton.addActionListener(l);
    }

    @Override
    public void addAddCarListener(ActionListener l) {
        addCarButton.addActionListener(l);
    }

    @Override
    public void addRemoveCarListener(ActionListener l) {
        removeCarButton.addActionListener(l);
    }

    @Override
    public double getGasAmount() {
        return gasAmount;
    }
}