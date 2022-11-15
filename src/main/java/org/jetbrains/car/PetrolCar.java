package org.jetbrains.car;

import org.jetbrains.location.Location;
import org.jetbrains.util.Constants;

public class PetrolCar extends Car {
    public PetrolCar(Location location, double energyUsageRate) {
        super(location, energyUsageRate);
        energyThreshold = Constants.FUEL_CAR_ENERGY_THRESHOLD;
    }
}
