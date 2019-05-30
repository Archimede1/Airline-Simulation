package project3;

public class Airline {
	private String flightID;
	private long entered;
	private long exited;
	
	// constructor
	public Airline (String flightID, long timeEntered) {
		this.flightID = flightID;
		entered = timeEntered;
	}
	
	// getters & setters
	public String getFlightID() {
		return flightID;
	}

	public long getEntered() {
		return entered;
	}

	public void setEntered(long entered) {
		this.entered = entered;
	}

	public void setExited(long exited) {
		this.exited = exited;
	}

	@Override
	public String toString() {
		// TODO: implement if you want to do some custom printing of an airplane
		return "";
	}
}
