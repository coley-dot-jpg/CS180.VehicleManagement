/**
 * Project 3 - Passenger.java
 *
 * This program simulates a passenger wanting to book a trip on either a plane or bus. This program stores their
 * 	booking status, name, route, and methods to access these features.
 *
 * @author Emelie Coleman, sec. L17
 *
 * @version March 22, 2019
 *
 */

public class Passenger {
	
	public static final String CANCELED = "Canceled";
	public static final String WAITLIST = "Waitlist";
	public static final String CONFIRMED = "Confirmed";

	private String passengerName;	// The name of the passenger
	private String bookingStatus;	// Status of the passenger's booking
	private Route route; 			// The route the passenger chooses to travel

	// Constructor
	public Passenger(String name, Route route) {
		this.passengerName = name;
		this.route = route;
		this.bookingStatus = WAITLIST;
	}

	// Methods
	public String getPassengerName() {
		return this.passengerName;
	}
	public Route getRoute() {
		return this.route;
	}
	public String getBookingStatus() {
		return this.bookingStatus;
	}
	public void confirm() {
		if (this.bookingStatus.equals(WAITLIST)) {
			this.bookingStatus = CONFIRMED;
		}
	}
	public void cancel() {
		if (this.bookingStatus == WAITLIST) {
			this.bookingStatus = CANCELED;
		}
	}
}
