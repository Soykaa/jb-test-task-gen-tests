package org.jetbrains.car;

import org.jetbrains.location.Location;
import org.jetbrains.util.Constants;

public abstract class Car {
    protected Location location;
    private final Energy energy;
    private final double energyUsageRate;
    protected double energyThreshold;

    public Car(Location location, int energyUsageRate) {
        this.location = location;

        if (energyUsageRate <= Constants.MINIMUM_ENERGY) {
            throw new IllegalArgumentException(Constants.TOO_lOW_ENERGY_USAGE_RATE_MSG
                    + Constants.MINIMUM_ENERGY + ".");
        }
        if (energyUsageRate >= Constants.MAXIMUM_ENERGY) {
            throw new IllegalArgumentException(Constants.TOO_HIGH_ENERGY_USAGE_RATE_MSG
                    + Constants.MAXIMUM_ENERGY + ".");
        }
        this.energyUsageRate = energyUsageRate;
        energy = new Energy();
    }

    public boolean needsEnergy(Location destination) {
        double distance = this.location.countDistanceTo(destination);
        double estimatedUsage = distance * energyUsageRate;
        return (this.energy.getEnergy() - estimatedUsage <= this.energyThreshold);
    }

    public void driveTo(Location destination) {
        double distance = this.location.countDistanceTo(destination);
        this.energy.reduceEnergy(distance * energyUsageRate);
        this.location = destination;
    }

    public void refuel() {
        System.out.println(Constants.REFUELING_STATUS);
        this.energy.recharge();
    }

    public Location getLocation() {
        return location;
    }

    public double getEnergyValue() {
        return (this.energy.getEnergy());
    }

    protected static class Energy {
        private double energy;

        public Energy() {
            energy = Constants.MAXIMUM_ENERGY;
        }

        public void reduceEnergy(double value) {
            energy -= value;
        }

        public double getEnergy() {
            return energy;
        }

        public void recharge() {
            energy = Constants.MAXIMUM_ENERGY;
        }
    }
}
