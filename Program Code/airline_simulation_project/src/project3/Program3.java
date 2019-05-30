package project3;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class Program3 {
	Arrival arrivals;
	Departure departures;
	Runway runway;
	static long startTime;
	static int time;
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Airline Simulator!");
		System.out.println("How Long Would You Like This Simulation to Run?");
		Scanner timeIn = new Scanner(System.in);
		time = timeIn.nextInt();
		Program3 sim = new Program3();
		sim.startSimulation(time);
		JOptionPane.showMessageDialog(null, "Simulation over.");
	}
	
	public Program3() {
		this.arrivals = new Arrival(Simulation.LANDING_TIME);
		this.departures = new Departure(Simulation.TAKEOFF_TIME);
		this.runway = new Runway(this.arrivals, this.departures);
	}		
	
	/**
	 * Starts the Airport simulation and runs it for the specified amount of time.
	 * @param timeInMinsToRunSimulation how long to run the simulation (minutes)
	 */
	public void startSimulation(int timeInMinsToRunSimulation) {
		startTime = System.currentTimeMillis();
		long simulationTimeInMillis = Simulation.timeInMilisecs((long) time);
		Thread arrive = this.arrivals;
		Thread depart = this.departures;
		Thread theRunway = this.runway;
		arrive.start();
		depart.start();
		theRunway.start();
		
		while(System.currentTimeMillis() < startTime + simulationTimeInMillis) {
			
		}
			
			arrive.interrupt();		
			depart.interrupt();
			theRunway.interrupt();
			((Arrival) arrive).stopRunning();
			((Departure) depart).stopRunning();
			((Runway) theRunway).stopRunning();
	}

}
