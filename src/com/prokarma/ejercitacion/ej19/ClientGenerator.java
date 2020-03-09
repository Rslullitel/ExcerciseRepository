package com.prokarma.ejercitacion.ej19;

import java.util.concurrent.BlockingQueue;

public class ClientGenerator extends Thread{

	private static final int CANT_CLIENTS = clientsRandom();
	
	private BlockingQueue<Client> clients;
	
	public ClientGenerator(BlockingQueue<Client> clients) {
		this.clients = clients;
	}

	@Override
	public void run() {
		for(int i = 0; i < CANT_CLIENTS; i++) {
			this.clients.add(new Client(cashRandom()));
			time();
		}
	}
	
	public void time() {
		try {
			sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private int cashRandom() {
		return (int)(Math.random()*(600-400+1)+400);
	}
	
	private static int clientsRandom() {
		return (int)(Math.random()*(40-1+1)+1);
	}
	
	
	public BlockingQueue<Client> getClients() {
		return clients;
	}
	public void setClients(BlockingQueue<Client> clients) {
		this.clients = clients;
	}
	
	
}
