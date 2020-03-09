package com.prokarma.ejercitacion.ej19;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Cashier extends Employee{

	private BlockingQueue<Client> clients; 
	private CashBox cashBox;
	private int total;
	
	public Cashier(BlockingQueue<Client> clients, BlockingQueue<Ticket> tickets, BlockingQueue<Client> waitClients) {
		super(tickets, waitClients);
		this.cashBox = new CashBox();
		this.clients = clients;
	}

	@Override
	public void run() {
		List<String> myTickets = new ArrayList<String>();
		Ticket ticket;
		Client client;
		boolean paymentOk = false;
		
		for(int i = 0; i < 50; i++) {
			while(this.clients.isEmpty()) {
			}
			client = clients.poll();
			Test.askForCount();
			for(int j = 0; j < intRandom(); j++) {//5 = numero random generado por metodo
				Test.welcome();
				//preguntar qeu tipo de pan quiere y agregarlo al sandwich
				//sandwich = selectSandwich(intRandom();
				//sandwich.getPan = pan seleccionado por metodo 
				myTickets.add(selectSandwich(intRandom()));//1 = numero random generado por metodo 
			}
			do {
				Test.typePay();
				try {
					ticket = charge(client.pay(payRandom(), total), myTickets);
					client.assignOrderNumber(ticket.getNumber());
					this.addTickets(ticket);
					this.addClientForWait(client);
					this.total = 0;
					paymentOk = true;
				} catch (NotEnoughCashException e) {//si catchea excepcion pregunta de nuevo metodo de pago
					e.printStackTrace();
				}
			}while(!paymentOk);
		}
	}
	
	public String selectSandwich(int i) {
		String sandwich = null;
		
		switch(i) {
			
		case 1:
			sandwich = OPCION_1;//instasnciar objeto sandwich y pasarle por parametro 
			this.total += PRECIO_1;// por ejemplo new Sandwich(OPCION_1, PRECIO_1);
		break;
		
		case 2:
			sandwich = OPCION_2;
			this.total += PRECIO_2;
		break;
		
		case 3:
			sandwich = OPCION_3;
			this.total += PRECIO_3;
		break;
		
		case 4:
			sandwich = OPCION_4;
			this.total += PRECIO_4;
		break;
		
		case 5:
			sandwich = OPCION_5;
			this.total = PRECIO_5;
		break;
		
		default:
			System.out.println("No sandwich selected");
		break;	
		}
	return sandwich;
	}
	
	public int payRandom() {
		return (int)(Math.random()*(2-1+1)+1);
	}
	
	public int intRandom() {
		return (int)(Math.random()*(5-1+1)+1);
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
