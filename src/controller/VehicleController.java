package src.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.model.WorldModel;
import src.view.VehicleControls;

public class VehicleController {
    private VehicleControls widget;
    private WorldModel model;

    public VehicleController(WorldModel model, VehicleControls widget) {
        this.model = model;
        this.widget = widget;
        bindListeners();
    }

    /**
     * Bind all buttons to actionlisteners
     */
    private void bindListeners() {
        widget.addGasListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.vehicleManager.gas(widget.getGasAmount());
            }
        });

        widget.addBrakeListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.vehicleManager.brake(widget.getGasAmount());
            }
        });

        widget.addStartListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.vehicleManager.startAll();
            }
        });

        widget.addStopListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.vehicleManager.stopAll();
            }
        });

        widget.addTurboOnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.vehicleManager.turboOn();
            }
        });

        widget.addTurboOffListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.vehicleManager.turboOff();
            }
        });

        widget.addLiftBedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.vehicleManager.liftBed();
            }
        });

        widget.addLowerBedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.vehicleManager.lowerBed();
            }
        });

    }
}
