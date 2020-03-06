package com.prokarma.ejercitacion.ej19;

import java.util.List;

public class Order {

	private Ticket ticket;
	private List<Sandwich> sandwiches;
	
	public Order(Ticket ticket) {
		this.ticket = ticket;
	}

	
	//metodo para agregar a esta lista todos los sandwiches
	
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
