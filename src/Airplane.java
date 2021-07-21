/**
 * Project 3 - Airplane.java
 *
 * This program implements the vehicle interface to create an Airplane object with a particular route, capacity,
 *  and passengers.
 *
 * @author Emelie Coleman, sec. L17
 *
 * @version March 22, 2019
 *
 */

public class Airplane implements Vehicle {

    private int capacity;               // The maximum number of passengers this vehicle can hold
    private Passenger[] passengers;     // The array of Passengers that have booked a trip on this vehicle
    private int count;                  // The number of passengers currently assigned to this vehicle
    private Route route;                // The route on which this Vehicle will travel

    public Airplane(Route route, int capacity) {
        this.route = route;
        this.capacity = capacity;
        this.count = 0;
        this.passengers = new Passenger[this.count];
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }
    @Override
    public Route getRoute() {
        return this.route;
    }
    @Override
    public int getCount() {
        return this.count;
    }
    @Override
    public Passenger[] getPassengers() {
        return this.passengers;
    }
    @Override
    public Vehicle upgrade(int newCapacity) {
        return null;
    }
    @Override
    public boolean addPassenger(Passenger person, boolean waitingList) {
        if (person.getRoute().equals(this.route) && waitingList) {
            Passenger[] newPassenger = new Passenger[this.count + 1];
            for (int i = 0; i < this.count; i++) {
                newPassenger[i] = passengers[i];
            }
            newPassenger[this.count] = person;
            this.count += 1;
            passengers = newPassenger;
            if (this.count <= this.capacity) {
                person.confirm();
            }
            return true;
        } else {
            person.cancel();
            return false;
        }
    }
    @Override
    public boolean addPassenger(Passenger person) {
        if (person.getRoute().equals(this.route) && this.count + 1 <= this.capacity) {
            Passenger[] newPassenger = new Passenger[this.count + 1];
            for (int i = 0; i < this.count; i++) {
                newPassenger[i] = passengers[i];
            }
            newPassenger[this.count] = person;
            this.count += 1;
            passengers = newPassenger;
            person.confirm();
            return true;
        } else {
            person.cancel();
            return false;
        }
    }
}
