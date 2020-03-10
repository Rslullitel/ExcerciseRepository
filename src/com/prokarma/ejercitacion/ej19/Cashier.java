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
		List<Sandwich> myTicket;
		Sandwich sandwichSelected;
		Ticket ticket;
		Client client;
		boolean paymentOk = false;
		int typePay;
		int rand;
		
		for(int i = 0; i < 50; i++) {
			while(this.clients.isEmpty()) {
			}
			myTicket = new ArrayList<Sandwich>();
			client = clients.poll();
				System.out.println("Client " + i);
			Test.askForCount();
			rand = intRandom();
				System.out.println(rand);
			Test.askForSandwich();
			for(int j = 0; j < rand; j++) {//5 = numero random generado por metodo			
				sandwichSelected = selectSandwich(intRandom());
					System.out.println("You choose: " + sandwichSelected);
				Test.askForBread();
				sandwichSelected.addBread(selectBread(numRandom()));
				myTicket.add(sandwichSelected);
			}
			do {
				Test.typePay();
				typePay = numRandom();
					System.out.println(selectTypePay(typePay));
				try {
					ticket = charge(selectTypePay(typePay), client.pay(typePay, total), myTicket);
					client.assignOrderNumber(ticket.getNumber()); 
					this.addTickets(ticket);
					this.addClientForWait(client);
					this.total = 0;
					paymentOk = true;
				} catch (NotEnoughCashException e) {//si catchea excepcion pregunta de nuevo metodo de pago
						System.out.println("Not enough money, try paying with credit card");
					paymentOk = false;	
				}
			}while(!paymentOk);
			time();
		}
	}
	
	public String selectTypePay(int type) {
		if(type == 1) {
			return "cash";
		}else {
			return "credit card";
		}
	}
	
	public Bread selectBread(int i) {
		Bread bread = null;
		
		switch(i) {
		
		case 1: 
			bread = new Bread("arabic");
		break;
		
		case 2:
			bread = new Bread("french");
		break;
		
		default:
			System.out.println("No bread selected");
		break;	
		}
	return bread;	
	}
	
	public Sandwich selectSandwich(int i) {
		Sandwich sandwich = null;
		
		switch(i) {
			
		case 1:
			sandwich = initializateSandwich(OPCION_1, PRECIO_1);
			
		break;
		
		case 2:
			sandwich = initializateSandwich(OPCION_2, PRECIO_2);
		break;
		
		case 3:
			sandwich = initializateSandwich(OPCION_3, PRECIO_3);
		break;
		
		case 4:
			sandwich = initializateSandwich(OPCION_4, PRECIO_4);
		break;
		
		case 5:
			sandwich = initializateSandwich(OPCION_4, PRECIO_4);
		break;
		
		default:
			System.out.println("No sandwich selected");
		break;	
		}
	return sandwich;
	}
	
	public void time() {
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private Sandwich initializateSandwich(String tipo, int precio) {
		this.total += precio;
		return new Sandwich(tipo, precio);
	}
	
	public int numRandom() {
		return (int)(Math.random()*(2-1+1)+1);
	}
	
	public int intRandom() {
		return (int)(Math.random()*(5-1+1)+1);
	}
	
	public Ticket charge(String typePay, int amount, List<Sandwich> myTickets) {//AMOUNT = PRECIO TOTAL DE TODOS LOS SANDWICHES
		return this.cashBox.generateTicket(typePay, amount, myTickets);
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
