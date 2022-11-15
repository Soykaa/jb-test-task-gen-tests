package org.jetbrains.station;

import org.jetbrains.location.Location;

public abstract class Station {
    private final Location location;

    public Station(int id, Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
