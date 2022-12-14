package org.jetbrains.person;

import org.jetbrains.car.Car;
import org.jetbrains.car.ElectricCar;
import org.jetbrains.location.Location;
import org.jetbrains.station.ChargingStation;
import org.jetbrains.station.GasStation;
import org.jetbrains.station.StationsPool;
import org.jetbrains.util.Constants;

public class Person {
    private final int age;
    private final Location homeLocation;
    private final Location workLocation;
    private Car car;

    public Person(int age, Location homeLocation, Location workLocation, Car car) {
        this.age = age;
        this.homeLocation = homeLocation;
        this.workLocation = workLocation;
        if (car == null) {
            throw new IllegalArgumentException(Constants.EMPTY_CAR_MSG);
        }
        this.car = car;
    }

    public void goToWork() {
        drive(workLocation);
    }

    public void goToHome() {
        drive(homeLocation);
    }

    private void drive(Location destinationLocation) {
        if (this.age < Constants.MIN_DRIVE_AGE) {
            System.out.println(Constants.TOO_YOUNG_MSG);
            return;
        }
        if (car.needsEnergy(destinationLocation)) {
            System.out.println(Constants.NEEDS_ENERGY_MSG);
            addEnergy();
        }
        System.out.println(Constants.CURRENT_DEST_MSG + destinationLocation.to_str() +
                Constants.CURRENT_LOCATION_MSG + car.getLocation().to_str() +
                Constants.CURRENT_ENERGY_MSG + car.getEnergyValue());
        car.driveTo(destinationLocation);
    }

    private void addEnergy() {
        Location destination;
        if (car instanceof ElectricCar) {
            ChargingStation chargingStation = StationsPool.getInstance().getClosestChargingStation(car);
            destination = chargingStation.getLocation();
        } else {
            GasStation gasStation = StationsPool.getInstance().getClosestGasStation(car);
            destination = gasStation.getLocation();
        }
        // I guess it wouldn't work now because of 2D coordinates (they need to be computed carefully)
//        if (car.needsEnergy(destination)) {
//            throw new IllegalArgumentException(Constants.NEEDS_ENERGY_MSG);
//        }
        System.out.println(Constants.CURRENT_DEST_MSG + destination.to_str() +
                Constants.CURRENT_LOCATION_MSG + car.getLocation().to_str() +
                Constants.CURRENT_ENERGY_MSG + car.getEnergyValue());
        car.refuel();
        car.driveTo(destination);
    }

    public void changeCar(Car car) {
        this.car = car;
    }
}
