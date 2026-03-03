package src.model.buildings;

import java.util.ArrayList;
import java.util.List;

import src.model.vehicles.cars.Car;

public class WorkshopManager {
    private ArrayList<Workshop<? extends Car>> workshops = new ArrayList<>();

    public List<Workshop<? extends Car>> getWorkshops() {
        return List.copyOf(workshops);
    }

    public void addWorkshop(Workshop<? extends Car> workshop) {
        workshops.add(workshop);
    }

    public void removeWorkshop(Workshop<? extends Car> workshop) {
        workshops.remove(workshop);
    }
}
