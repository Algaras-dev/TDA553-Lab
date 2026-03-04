package src.controller;

import src.model.WorldModel;
import src.view.VehicleControls;

public class VehicleController {
    private WorldModel model;

    public VehicleController(WorldModel model, VehicleControls controlPanel) {
        this.model = model;
        bindListeners(controlPanel);
    }

    /**
     * Bind all buttons to ActionListeners
     */
    private void bindListeners(VehicleControls controlPanel) {
        controlPanel.addGasListener(_ -> model.vehicleManager.gas(controlPanel.getGasAmount()));

        controlPanel.addBrakeListener(_ -> model.vehicleManager.brake(controlPanel.getGasAmount()));

        controlPanel.addStartListener(_ -> model.vehicleManager.startAll());

        controlPanel.addStopListener(_ -> model.vehicleManager.stopAll());

        controlPanel.addTurboOnListener(_ -> model.vehicleManager.turboOn());

        controlPanel.addTurboOffListener(_ -> model.vehicleManager.turboOff());

        controlPanel.addLiftBedListener(_ -> model.vehicleManager.liftBed());

        controlPanel.addLowerBedListener(_ -> model.vehicleManager.lowerBed());
    }
}
