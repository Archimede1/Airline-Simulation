package project3;

public class Arrival extends Thread {
	Queue<Airline> queue;
	int landingTime;
	int tillNext;
	boolean running = true;
	
	public Arrival(int landingTime) {
		this.landingTime = landingTime;
		this.queue = new Queue();
	}
	
	@Override
	public void run() {
		while (running) {
			tillNext = Simulation.timeTillNext(Simulation.MEAN_LANDING_TIME);
			String waitTime = "Wait Time for Next Arrival: " + tillNext / 1000 + " minutes";
			log(waitTime);
				try {
				Thread.sleep(tillNext);
				} catch (InterruptedException e) {
					log("No More Scheduled Arrivals");
			
			}
			queue.enqueue(Simulation.generateRandomAirline());
			queue.rear().setEntered(Simulation.elapsedSimulationTime());
			String flightAdded = "Flight " + queue.rear().getFlightID() + " has Entered the Arrival Queue";
			log(flightAdded);
			
		}
	}
	
	/**
	 * Use this method to log Arrival messages to the console. Do NOT change this.
	 * @param msg The message you want the arrival thread to print.
	 */
	private void log(String msg) {
		System.out.printf("Minute %3d - [Arrival]: %s%n", Simulation.elapsedSimulationTime(), msg);
	}
	
	public void stopRunning() {
		running = false;
	}

	public Queue<Airline> getQueue() {
		return queue;
	}
	
	public int getTime() {
		return landingTime;
	}
	
	public int getTillNext() {
		return tillNext;
	}
}
