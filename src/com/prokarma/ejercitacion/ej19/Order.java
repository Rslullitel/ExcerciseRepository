package com.prokarma.ejercitacion.ej19;

import java.util.Map;

public class Order {

	 private Map<Integer, Integer> sandwiches;
	 private Ticket ticket;
	 private boolean isReady;

	 public Order(Map<Integer, Integer> sandwiches, Ticket ticket) {
		 this.sandwiches = sandwiches;
		 this.ticket = ticket;
		 this.isReady = false;
	 }

	public void setReady(boolean ready) {
		this.isReady = ready;	
	}
	public Map<Integer, Integer> getSandwiches() {
		return sandwiches;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public boolean isReady() {
		return isReady;
	}
	public void setSandwiches(Map<Integer, Integer> sandwiches) {
		this.sandwiches = sandwiches;
	}

	public String toString() {
		return this.ticket.toString() + 
			   "\nSandwiches: " + this.sandwiches.toString();
	}
}
