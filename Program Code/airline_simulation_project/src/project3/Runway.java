package project3;

public class Runway extends Thread {
	Arrival arrivals;
	Departure departures;
	boolean running = true;
	
	public Runway(Arrival arrivals, Departure departures) {
		this.arrivals = arrivals;
		this.departures = departures;
	}
	
	@Override
	public void run() {
		log("Runway is open.");
		
		
		while (running) {
			while(!arrivals.getQueue().isEmpty()) {
				String entered = "" + arrivals.getQueue().front().getEntered();
				arrivals.queue.front().setExited(Simulation.elapsedSimulationTime());
				String arriving = "Flight " + arrivals.getQueue().dequeue().getFlightID() + " has been cleared for Landing!  -" + "Entered Arrival Queue at " + entered + " minutes -  waited for " + arrivals.getTillNext() / 1000;
				log(arriving);
					try {
						Thread.sleep(arrivals.getTime());
					} catch (InterruptedException e) {
					
						
					}
			}
			while(arrivals.getQueue().isEmpty() && !departures.getQueue().isEmpty()) {
				String departed = "" + departures.getQueue().front().getEntered();
				departures.queue.front().setExited(Simulation.elapsedSimulationTime());
				String departing = "Flight " + departures.getQueue().dequeue().getFlightID() + " has been cleared for Take-off!  -" + "Entered Arrival Queue at " + departed + " minutes -  waited for " + departures.getTillNext() / 1000;
				log(departing);
					try {
						Thread.sleep(departures.getTime());
					} catch (InterruptedException e) {
						
					
						
					}
			}
		}
		
		log("Runway is now closed");
	}
	
	/**
	 * Use this method to log Runway messages to the console. Do NOT change this.
	 * @param msg The message you want the arrival thread to print.
	 */
	private void log(String msg) {
		System.out.printf("Minute %3d - [Runway]: %s%n", Simulation.elapsedSimulationTime(), msg);
	}
	
	public void stopRunning() {
		running = false;
	}


}
