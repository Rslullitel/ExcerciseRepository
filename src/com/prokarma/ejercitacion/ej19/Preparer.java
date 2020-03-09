package com.prokarma.ejercitacion.ej19;

import java.util.concurrent.BlockingQueue;

public class Preparer extends Employee{

	private Window window;
	
	public Preparer(BlockingQueue<Ticket> tickets, BlockingQueue<Client> waitClients) {
		super(tickets,  waitClients);
		window = new Window();
	}

	@Override
	public void run() {
		Ticket ticket;
		String sandwich;
		Order order;
		
		for(int i = 0; i < 50; i++) {
			while(this.getTickets().isEmpty()) {
			}
			ticket = this.pollTicket();
			order = new Order(ticket);
			for(int j = 0; j < ticket.getSandwiches().size(); j++) {
				sandwich = ticket.getSandwiches().get(j);
				order.addSandwich(prepareSandwich(sandwich));
				//entregar orden a cliente
			}
			
		}
	}
	
	public Sandwich prepareSandwich(String sandwich) {
		/*Sandwich preparedSandwich = new Sandwich();
		
		switch(sandwich) {
		
		case OPCION_1:
			restar la cantidad de productos dependiendo del sandwich
			cambiar estado del sandwich a listo. 
			una vez que todos esten listos cambiar estado de la orden a listo y entregar 
		}*/
		return null;
	}
	
}










