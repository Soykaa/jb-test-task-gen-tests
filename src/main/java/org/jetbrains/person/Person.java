package org.jetbrains.person;

import org.jetbrains.car.Car;
import org.jetbrains.car.ElectricCar;
import org.jetbrains.location.Location;
import org.jetbrains.station.ChargingStation;
import org.jetbrains.station.GasStation;
import org.jetbrains.station.StationsPool;

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
            throw new IllegalArgumentException("Car is empty");
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
        if (this.age < 18) {
            System.out.println("This person is too young to drive!");
            return;
        }
        if (car.needsEnergy(destinationLocation)) {
            System.out.println("Needs energy");
            addEnergy();
        }
        System.out.println("Drive to " + destinationLocation + ". Current location " + car.getLocation() + ". Energy " + car.getEnergyValue());
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
        System.out.println("Drive to " + destination + ". Current location " + car.getLocation() + ". Energy " + car.getEnergyValue());
        car.driveTo(destination);
        car.refuel();
    }

    public void changeCar(Car car) {
        this.car = car;
    }
}
