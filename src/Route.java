/**
 * Project 3 - Route.java
 *
 * This program simulates a route to be traveled by a passenger on either a plane or bus. This program stores the
 * 	to and from destinations and methods to access these features.
 *
 * @author Emelie Coleman, sec. L17
 *
 * @version March 22, 2019
 *
 */

public class Route {

    // Instance variables
    private String from;    // The starting point of the route
    private String to;      // The destination of the route

    // Constructor
    public Route(String from, String to) {
        this.from = from;
        this.to = to;
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof Route) {
            boolean equals;
            if (this.from == null) {
                equals = ((Route) obj).from == null;
            } else {
                equals = this.from.equalsIgnoreCase(((Route) obj).from);
            }
            if (this.to == null) {
                equals &= ((Route) obj).to == null;
            } else {
                equals &= this.to.equalsIgnoreCase(((Route) obj).to);
            }
            return equals;
        }
        return false;
    }
    public String toString() {
        return String.format("Route: From %s to %s\n", this.from, this.to);
    }
}
