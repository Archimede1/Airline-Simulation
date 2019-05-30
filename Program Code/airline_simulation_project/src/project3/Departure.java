package project3;

public class Departure extends Thread {
	Queue<Airline> queue;
	int takeoffTime;
	int tillNext;
	boolean running = true;

	public Departure(int takeoffTime) {
		this.takeoffTime = takeoffTime;
		this.queue = new Queue();
	}

	@Override
	public void run() {
		while (running) {
			tillNext = Simulation.timeTillNext(Simulation.MEAN_TAKEOFF_TIME);
			String waitTime = "Wait Time for Next Departure: " + tillNext / 1000 + " minutes";
			log(waitTime);
				try {
				Thread.sleep(tillNext);
				} catch (InterruptedException e) {
					log("No More Scheduled Departures");

			}
			queue.enqueue(Simulation.generateRandomAirline());
			queue.rear().setEntered(Simulation.elapsedSimulationTime());
			String flightAdded = "Flight " + queue.rear().getFlightID() + " has Entered the Departure Queue";
			log(flightAdded);
		}
	}

	/**
	 * Use this method to log Departure messages to the console. Do NOT change this.
	 * @param msg The message you want the arrival thread to print.
	 */
	private void log(String msg) {
		System.out.printf("Minute %3d - [Departure]: %s%n", Simulation.elapsedSimulationTime(), msg);
	}

	public Queue<Airline> getQueue() {
		return queue;
	}

	public int getTime() {
		return takeoffTime;
	}
	
	public int getTillNext() {
		return tillNext;
	}

	public void stopRunning() {
		running = false;
	}

	@Override
	public String toString() {
		// TODO: implement
		return "";
	}


}
