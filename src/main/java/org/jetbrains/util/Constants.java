package org.jetbrains.util;

public class Constants {
    public static final double MINIMUM_ENERGY = 0;
    public static final double MAXIMUM_ENERGY = 100;
    public static final double ELECTRIC_CAR_ENERGY_THRESHOLD = 40;
    public static final double FUEL_CAR_ENERGY_THRESHOLD = 20;
    public static final int MIN_DRIVE_AGE = 18;
    public static final double MAX_DISTANCE = 100;

    public static final String REFUELING_STATUS = "Refueling";
    public static final String TOO_lOW_ENERGY_USAGE_RATE_MSG = "energy usage rate should be higher than "
            + Constants.MINIMUM_ENERGY + '.';
    public static final String TOO_HIGH_ENERGY_USAGE_RATE_MSG = "energy usage rate should be lower than "
            + Constants.MAXIMUM_ENERGY + '.';
    public static final String EMPTY_CAR_MSG = "Car is empty";
    public static final String TOO_YOUNG_MSG = "This person is too young to drive!";
    public static final String NEEDS_ENERGY_MSG = "Needs energy";
    public static final String CURRENT_LOCATION_MSG = ". Current location ";
    public static final String CURRENT_ENERGY_MSG = ". Energy ";
    public static final String CURRENT_DEST_MSG = "Drive to ";
    public static final String NOT_ENOUGH_ENERGY_MSG = "Not enough energy";
}
