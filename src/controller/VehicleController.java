package src.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.model.WorldModel;
import src.view.VehicleControls;

public class VehicleController {
    private WorldModel model;

    public VehicleController(WorldModel model, VehicleControls controlPanel) {
        this.model = model;
        bindListeners(controlPanel);
    }

    /**
     * Bind all buttons to actionlisteners
     */
    private void bindListeners(VehicleControls controlPanel) {
        controlPanel.addGasListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.vehicleManager.gas(controlPanel.getGasAmount());
            }
        });

        controlPanel.addBrakeListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.vehicleManager.brake(controlPanel.getGasAmount());
            }
        });

        controlPanel.addStartListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.vehicleManager.startAll();
            }
        });

        controlPanel.addStopListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.vehicleManager.stopAll();
            }
        });

        controlPanel.addTurboOnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.vehicleManager.turboOn();
            }
        });

        controlPanel.addTurboOffListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.vehicleManager.turboOff();
            }
        });

        controlPanel.addLiftBedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.vehicleManager.liftBed();
            }
        });

        controlPanel.addLowerBedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.vehicleManager.lowerBed();
            }
        });

    }
}
