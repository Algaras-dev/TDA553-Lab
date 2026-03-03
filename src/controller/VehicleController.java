package src.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.model.WorldModel;

public class VehicleController {
    private VehicleControlWidget widget;
    private WorldModel model;

    public VehicleController(WorldModel model, VehicleControlWidget widget) {
        this.model = model;
        this.widget = widget;
        bindListeners();
    }

    /**
     * Bind all buttons to actionlisteners
     */
    private void bindListeners() {
        widget.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.vehicleManager.gas(widget.getGasAmount());
            }
        });

        widget.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.vehicleManager.brake(widget.getGasAmount());
            }
        });

        widget.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.vehicleManager.startAll();
            }
        });

        widget.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.vehicleManager.stopAll();
            }
        });

        widget.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.vehicleManager.turboOn();
            }
        });

        widget.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.vehicleManager.turboOff();
            }
        });

        widget.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.vehicleManager.liftBed();
            }
        });

        widget.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.vehicleManager.lowerBed();
            }
        });

    }
}
