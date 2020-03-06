package com.prokarma.ejercitacion.ej19;

import java.util.concurrent.BlockingQueue;

public class Preparer extends Employee{

	
	public Preparer(BlockingQueue<Ticket> tickets, BlockingQueue<Client> waitClients) {
		super(tickets,  waitClients);
		
	}

	@Override
	public void run() {
		Ticket ticket;
		String sandwich;
		Order order;
		
		for(int i = 0; i < 50; i++) {
			while(this.getTickets().isEmpty()) {
			}
			ticket = this.removeTicket();
			order = new Order(ticket);
			for(int j = 0; j < ticket.getSandwiches().size(); j++) {
				sandwich = ticket.getSandwiches().get(j);
				order.getSandwiches().add(readTicket(sandwich));
			}
			
		}
	}
	
	public Sandwich readTicket(String s) {
		
		switch(s) {
		
		case OPCION_1:
			
		}
		return null;
	}
	
}










