package com.prokarma.ejercitacion.ej19;

import java.util.concurrent.BlockingQueue;

public class ClientGenerator extends Thread{

    private BlockingQueue<Client> clients;
    private int cantClients;

    public ClientGenerator(BlockingQueue<Client> clients, int cantClients) {
        this.clients = clients;
        this.cantClients = cantClients;
    }

    @Override
    public void run() {
    	int i = 0;
    	
        while(i < cantClients && Test.stop) {
            this.clients.add(new Client(cashRandom()));
            i++;
            time();
        }
    }
    //demora 2000ms
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

    public BlockingQueue<Client> getClients() {
        return clients;
    }

    public void setClients(BlockingQueue<Client> clients) {
        this.clients = clients;
    }
	
	
}
