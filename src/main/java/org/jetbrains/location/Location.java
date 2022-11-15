package org.jetbrains.location;

public class Location {
    private final double x;
    private final double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double countDistanceTo(Location destination) {
        return Math.sqrt((x - destination.x) * (x - destination.x) + (y - destination.y) * (y - destination.y));
    }

    public String to_str() {
        return "(" + x + ", " + y + ")";
    }
}
