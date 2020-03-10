package com.prokarma.ejercitacion.ej19;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue<Ticket> tickets = new ArrayBlockingQueue<Ticket>(1024);
		BlockingQueue<Client> clients = new ArrayBlockingQueue<Client>(1024);
		BlockingQueue<Client> waitClients = new ArrayBlockingQueue<Client>(1024);
		
		ClientGenerator clientGenerator = new ClientGenerator(clients);
		Employee cashier = new Cashier(clients, tickets, waitClients);
		Employee preparer = new Preparer(tickets, waitClients);
		
		clientGenerator.start();
		cashier.start();
		preparer.start();
		
	}

	public static void askForCount() {//metodo int para devovler numero random
		System.out.println("Hi, welcome to El Nono. ¿How many sandwich do you want?");
	}
	
	public static void askForSandwich() {
		System.out.println("Alright, this is our sandwich menú:");
		System.out.println("1)Jamon crudo y danbo = $150\n2)Jamon cocido y danbo = $120\n"
						 + "3)Jamon crudo y cheddar = $200\n4)Jamon cocido y cheddar = $170\n"
						 + "5)Salami y danbo = $100");
	}
	
	
	public static void askForBread() {
		System.out.println("¿What kind of bread do you want?\n1) Arabic\n2) French\n3) Black");
	}
	
	public static void typePay() {
		System.out.println("¿How do you want to pay?\n1)Cash\n2)Credit card");
	}
	
}
