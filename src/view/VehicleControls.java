package src.view;

import java.awt.event.ActionListener;

import src.model.vehicles.VehicleFactory.Type;

public interface VehicleControls {
    public void addGasListener(ActionListener l);

    public void addBrakeListener(ActionListener l);

    public void addStartListener(ActionListener l);

    public void addStopListener(ActionListener l);

    public void addTurboOnListener(ActionListener l);

    public void addTurboOffListener(ActionListener l);

    public void addLiftBedListener(ActionListener l);

    public void addLowerBedListener(ActionListener l);

    public void addAddCarListener(ActionListener l);

    public void addRemoveCarListener(ActionListener l);

    public Type addVehiclePopup(Type[] options);

    public Type removeVehiclePopup(Type[] options);

    public double getGasAmount();

}
