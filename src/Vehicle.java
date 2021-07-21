/**
 * Project 3 - Vehicle.java
 *
 * This program is an interface that is implemented by Bus and Airplane. It contains common ground for methods used
 *  across vehicles in the software.
 *
 * @author Emelie Coleman, sec. L17
 *
 * @version March 22, 2019
 *
 */

public interface Vehicle {

    public int getCapacity();                               // Returns capacity of vehicle

    public Route getRoute();                                // Returns route of vehicle

    public int getCount();                                  // Returns number of bookings on vehicle

    public Passenger[] getPassengers();                     // Returns an array of Passengers associated with vehicle

    public boolean addPassenger(Passenger person, boolean waitingList);

    public boolean addPassenger(Passenger person);          // <^Adds passenger, returns successfulness

    public Vehicle upgrade(int newCapacity);                // Returns new upgraded vehicle
}
