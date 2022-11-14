package org.jetbrains.car;

import org.jetbrains.location.Location;

public abstract class Car {
    protected Location location;
    private final Energy energy;
    private final double energyUsageRate;
    protected int energyThreshold;

    public Car(Location location, double energyUsageRate) {
        this.location = location;

        if (energyUsageRate <= 0) {
            throw new IllegalArgumentException("energy usage rate should be higher than 0.");
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
        System.out.println("Refueling");
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
            energy = 100;
        }

        public void reduceEnergy(double value) {
            energy -= value;
        }

        public double getEnergy() {
            return energy;
        }

        public void recharge() {
            energy = 100;
        }
    }
}
