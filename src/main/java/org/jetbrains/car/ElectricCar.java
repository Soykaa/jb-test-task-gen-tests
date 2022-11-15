package org.jetbrains.car;

import org.jetbrains.location.Location;
import org.jetbrains.util.Constants;

public class ElectricCar extends Car {
    public ElectricCar(Location location, double energyUsageRate) {
        super(location, energyUsageRate);
        energyThreshold = Constants.ELECTRIC_CAR_ENERGY_THRESHOLD;
    }
}
