package com.prokarma.ejercitacion.ej19;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Cashier extends Employee{

	private BlockingQueue<Client> clients; 
	private CashBox cashBox;
	private int total;
	
	public Cashier( BlockingQueue<Client> clients, BlockingQueue<Ticket> tickets, BlockingQueue<Client> waitClients) {
		super(tickets, waitClients);
		this.cashBox = new CashBox();
		this.clients = clients;
	}

	@Override
	public void run() {
		List<String> ticks = new ArrayList<String>();
		Ticket ticket;
		Client client;
		
		for(int i = 0; i < 50; i++) {
			while(this.clients.isEmpty()) {
			}
			client = clients.poll();
			Test.askForCount();
			for(int j = 0; j < 5; j++) {//5 = numero random generado por metodo
				Test.welcome();
				ticks.add(selectSandwich(1));//1 = numero random generado por metodo 
			}
			ticket = charge(total, ticks);
			this.addTickets(ticket);
			client.setTicketNumber(ticket.getNumber());
			this.addClientForWait(client);
			this.total = 0;
		}
		
	}
	
	public String selectSandwich(int i) {
		String sandwich = null;
		
		switch(i) {
			
		case 1:
			sandwich = OPCION_1;
			this.total += 120;
		}
		return sandwich;
	}
	
	public Ticket charge(int amount, List<String> sandwiches) {//AMOUNT = PRECIO TOTAL DE TODOS LOS SANDWICHES
		return this.cashBox.generateTicket(amount, sandwiches);
	}
	
	public CashBox getCashBox() {
		return cashBox;
	}
	public void setCashBox(CashBox cashBox) {
		this.cashBox = cashBox;
	}
	public BlockingQueue<Client> getClients() {
		return clients;
	}
	public void setClients(BlockingQueue<Client> clients) {
		this.clients = clients;
	}
	
	
}
