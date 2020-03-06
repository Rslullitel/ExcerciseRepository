package com.prokarma.ejercitacion.ej19;

import java.util.concurrent.BlockingQueue;

public class ClientGenerator extends Thread{

	private static final int CANT_CLIENTS = 50;
	
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
		return (int)(Math.random()*(400-200+1)+100);
	}
	
	
	public BlockingQueue<Client> getClients() {
		return clients;
	}
	public void setClients(BlockingQueue<Client> clients) {
		this.clients = clients;
	}
	
	
}
