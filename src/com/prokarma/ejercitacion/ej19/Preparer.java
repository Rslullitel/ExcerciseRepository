package com.prokarma.ejercitacion.ej19;

import java.util.concurrent.BlockingQueue;

public class Preparer extends Employee{

	private static final int LESS_INGREDIENT = 10;
	
	private Window window;
	
	public Preparer(BlockingQueue<Ticket> tickets, BlockingQueue<Client> waitClients) {
		super(tickets,  waitClients);
		window = new Window();
	}

	@Override
	public void run() {
		Ticket ticket;
		Client client;
		
		for(int i = 0; i < 50; i++) {
			while(this.getTickets().isEmpty()) {
			}
			ticket = this.pollTicket();
			for(int j = 0; j < ticket.getSandwiches().size(); j++) {
				finalizeOrder(ticket.getSandwiches().get(j));
			}
			ticket.changeStateOrder();
			client = this.getWaitClients().poll();
				System.out.println(ticket.toString());
			client.addOrder(ticket.getOrder());
				System.out.println("Bye, have a nice day");
			time();	
		}
	}
	
	private void finalizeOrder(Sandwich sandwich) {
		sandwich.setState(true);
		
		switch(sandwich.getType()) {
		
		case OPCION_1: 
			this.window.lessDanbo(LESS_INGREDIENT);
			this.window.lessRawHam(LESS_INGREDIENT);
		break;
		
		case OPCION_2:
			this.window.lessDanbo(LESS_INGREDIENT);
			this.window.lessCookedHam(LESS_INGREDIENT);
		break;
		
		case OPCION_3:
			this.window.lessRawHam(LESS_INGREDIENT);
			this.window.lessCheddar(LESS_INGREDIENT);
		break;
		
		case OPCION_4:
			this.window.lessCheddar(LESS_INGREDIENT);
			this.window.lessCookedHam(LESS_INGREDIENT);
		break;
		
		case OPCION_5:
			this.window.lessDanbo(LESS_INGREDIENT);
			this.window.lessSalami(LESS_INGREDIENT);
		}
	}
	
	public void time() {
		try {
			sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}










