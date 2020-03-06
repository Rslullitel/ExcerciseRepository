package com.prokarma.ejercitacion.ej19;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BlockingQueue<Ticket> tickets = new ArrayBlockingQueue<Ticket>(1024);
		BlockingQueue<Client> clients = new ArrayBlockingQueue<Client>(1024);
		BlockingQueue<Client> waitClients = new ArrayBlockingQueue<Client>(1024);
		
		Employee cashier = new Cashier(clients, tickets, waitClients);
		Employee preparer = new Preparer(tickets, waitClients);
		
		
	}

	public static void askForCount() {//metodo int para devovler numero random
		System.out.println("Hi, welcome to restaurant, how many sandwich do you want");
	}
	
	public static void welcome() {
		System.out.println("Alright, this is our sandwich menú:");
		System.out.println("1)Jamon crudo y danbo. $120\n 2)Jamon crudo y cheddar. $150 3) 4)");
	}
	
}
