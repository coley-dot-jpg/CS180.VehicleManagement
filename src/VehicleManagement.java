/**
 * Project 3 - Passenger.java
 *
 * This program is the root class for the other programs and organizes passengers onto vehicles that match their route
 *  and the demand for that route. This program also keeps track of available buses and planes to be booked.
 *
 * @author Emelie Coleman, sec. L17
 *
 * @version March 22, 2019
 *
 */

public class VehicleManagement {

    private Vehicle[] vehicles;	    // The array of Vehicles that have been assigned a Route
    private int count;		        // The number of vehicles in the 'vehicles' array (and therefore assigned to a Route)
    private int bus;                // The number of buses that are available (not assigned to a Route)
    private int plane;              // The number of airplanes that available (not assigned to a Route)

    public VehicleManagement(int bus, int plane) {
        this.count = 0;
        this.vehicles = new Vehicle[this.count];
        this.bus = bus;
        this.plane = plane;
    }
    public boolean createRoute(Route route, int capacity) {
        if (this.bus > 0) {
            Vehicle[] newVehicles = new Vehicle[this.count + 1];
            for (int i = 0; i < this.vehicles.length; i++) {
                this.vehicles[i] = newVehicles[i];
                if (this.vehicles[i].getRoute().equals(route)) {
                    return false;
                }
            }
            Bus newBus = new Bus(route, capacity);
            newVehicles[this.count] = newBus;
            this.count += 1;
            this.bus -= 1;
            this.vehicles = newVehicles;
            return true;
        } else {
            return false;
        }
    }
    public boolean addPassengerToVehicle(Passenger person) {
        for (int i = 0; i < this.vehicles.length; i++) {
            if (this.vehicles[i].getRoute().equals(person.getRoute())) {
                return this.vehicles[i].addPassenger(person);
            } else if (this.vehicles[i].getRoute().equals(person.getRoute()) &&
                    this.vehicles[i].getCount() >= 2 * this.vehicles[i].getCapacity() && this.plane > 0) {
                Vehicle newAirplane = vehicles[i].upgrade(3 * vehicles[i].getCapacity());
                if (vehicles[i] instanceof Bus) {
                    this.bus -= 1;
                    this.plane += 1;
                }
                vehicles[i] = newAirplane;
                return true;
            }
        }
        person.cancel();
        return false;
    }
    public Vehicle[] getVehicles() {
        //Returns an array of Vehicles that contains the Vehicles registered so far.
        //The array returned has to be populated within the index 0 to getCount() - 1 and of size getCount().
        return this.vehicles;
    }
    public int getCount() {
        //Return the number of Vehicle/Route registered.
        return this.count;
    }
    public int lookupVehicle(Route route) {
        for (int i = 0; i < this.vehicles.length; i++) {
            if (this.vehicles[i].getRoute() == route) {
                return i;
            }
        }
        return -1;
    }
    public int getAvailableBus() {
        //Returns the number of buses still available.
        return this.bus;
    }
    public int getAvailablePlane() {
        //Returns the number of planes still available.
        return this.plane;
    }
}