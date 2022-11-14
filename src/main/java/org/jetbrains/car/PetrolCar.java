package org.jetbrains.car;

import org.jetbrains.location.Location;

public class PetrolCar extends Car {
    public PetrolCar(Location location, double energyUsageRate) {
        super(location, energyUsageRate);
        energyThreshold = 20;
    }
}
