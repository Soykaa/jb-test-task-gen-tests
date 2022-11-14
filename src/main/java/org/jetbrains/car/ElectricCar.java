package org.jetbrains.car;

import org.jetbrains.location.Location;

public class ElectricCar extends Car {
    public ElectricCar(Location location, double energyUsageRate) {
        super(location, energyUsageRate);
        energyThreshold = 40;
    }
}
