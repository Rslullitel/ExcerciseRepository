package com.prokarma.ejercitacion.ej19;

import java.util.List;

public class Order {

	//private boolean state;
	//private int number;
	private Ticket ticket;
	private List<Sandwich> sandwiches;
	
	public Order(Ticket ticket) {
		this.ticket = ticket;
		//this.state = false;
		//this.number++;
	}

	
	public void addSandwich(Sandwich sandwich) {
		this.sandwiches.add(sandwich);
	}
	
	
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public List<Sandwich> getSandwiches() {
		return sandwiches;
	}
	public void setSandwiches(List<Sandwich> sandwiches) {
		this.sandwiches = sandwiches;
	}
	
	
	
}
