package org.jetbrains.station;

import org.jetbrains.location.Location;

public abstract class Station {
    private final int id;
    private final Location location;

    public Station(int id, Location location) {
        this.id = id;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }
}
