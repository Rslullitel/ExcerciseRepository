package com.prokarma.ejercitacion.ej19;

import java.util.concurrent.BlockingQueue;

public abstract class Employee extends Thread{

	protected static final String OPCION_1 = "Jamon Crudo y Danbo";
	protected static final String OPCION_2 = "Jamon Cocido y Danbo";
	protected static final String OPCION_3 = "Jamon Crudo y Cheddar";
	protected static final String OPCION_4 = "Jamon Cocido y Cheddar";
	protected static final String OPCION_5 = "Salami y Danbo";
	
	protected static final int PRECIO_1 = 150;
	protected static final int PRECIO_2 = 120;
	protected static final int PRECIO_3 = 200;
	protected static final int PRECIO_4 = 170;
	protected static final int PRECIO_5 = 100;
	
	
	private BlockingQueue<Ticket> tickets;
	private BlockingQueue<Client> waitClients;
	
	public Employee(BlockingQueue<Ticket> tickets, BlockingQueue<Client> waitClients ) {
		this.tickets = tickets;
		this.waitClients = waitClients;
	}

	public void addTickets(Ticket ticket) {
		this.tickets.add(ticket);
	}
	
	public Ticket pollTicket() {
		return this.tickets.poll();
	}
	
	public void addClientForWait(Client client) {
		this.waitClients.add(client);
	}
	
	public BlockingQueue<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(BlockingQueue<Ticket> tickets) {
		this.tickets = tickets;
	}
	public BlockingQueue<Client> getWaitClients() {
		return waitClients;
	}
	public void setWaitClients(BlockingQueue<Client> waitClients) {
		this.waitClients = waitClients;
	}
	
	
}
