package org.jetbrains.station;

import org.jetbrains.car.Car;
import org.jetbrains.car.ElectricCar;
import org.jetbrains.car.PetrolCar;
import org.jetbrains.location.Location;
import org.jetbrains.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class StationsPool {
    private static StationsPool stations;
    private final List<Station> gasStations = new ArrayList<>();
    private final List<Station> chargingStations = new ArrayList<>();

    public static StationsPool getInstance() {
        if (stations == null) {
            stations = new StationsPool();
        }
        return stations;
    }

    private StationsPool() {
        // Add gas stations
        gasStations.add(new GasStation(1, new Location(10, 15)));
        gasStations.add(new GasStation(2, new Location(25, 15)));
        gasStations.add(new GasStation(3, new Location(45, 15)));
        gasStations.add(new GasStation(4, new Location(67, 10)));
        gasStations.add(new GasStation(5, new Location(77, 10)));
        gasStations.add(new GasStation(6, new Location(89, 10)));
        gasStations.add(new GasStation(7, new Location(97, 10)));
        // Add charging stations
        chargingStations.add(new ChargingStation(8, new Location(10, 15)));
        chargingStations.add(new ChargingStation(9, new Location(10, 35)));
        chargingStations.add(new ChargingStation(10, new Location(10, 47)));
        chargingStations.add(new ChargingStation(11, new Location(10, 59)));
        chargingStations.add(new ChargingStation(12, new Location(15, 70)));
        chargingStations.add(new ChargingStation(13, new Location(15, 86)));
        chargingStations.add(new ChargingStation(14, new Location(15, 96)));
    }

    public ChargingStation getClosestChargingStation(Car car) {
        if (!(car instanceof PetrolCar)) {
            throw new IllegalArgumentException(Constants.PETROL_CARS_ONLY_MSG);
        }
        return (ChargingStation) getClosestStation(car, this.chargingStations);
    }

    public GasStation getClosestGasStation(Car car) {
        if (!(car instanceof ElectricCar)) {
            throw new IllegalArgumentException(Constants.ELECTRIC_CARS_ONLY_MSG);
        }
        return (GasStation) getClosestStation(car, this.gasStations);
    }

    private Station getClosestStation(Car car, List<Station> stations) {
        Location carLocation = car.getLocation();
        double minDistance = carLocation.countDistanceTo(
                new Location(Constants.MAX_DISTANCE, Constants.MAX_DISTANCE));
        Station closestChargingStation = null;

        for (Station chargingStation : stations) {
            double currentDistance = carLocation.countDistanceTo(chargingStation.getLocation());
            if (currentDistance < minDistance) {
                closestChargingStation = chargingStation;
                minDistance = currentDistance;
            }
        }
        return closestChargingStation;
    }
}
