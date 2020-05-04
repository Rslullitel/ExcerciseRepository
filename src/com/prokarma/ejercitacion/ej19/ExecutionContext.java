package com.prokarma.ejercitacion.ej19;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.prokarma.ejercitacion.ej19.dao.DAOFactory;

public class ExecutionContext {

	private volatile boolean stop;
	
        private int cantClients = clientsRandom();
        private BlockingQueue<Order> orders;
        private BlockingQueue<Client> clients;
        private ClientGenerator generator;
        private Cashier cashier;
        private Preparer preparer;
        private DAOFactory factory;
        
        public ExecutionContext(List<Sandwich> sandwiches) {
        	this.orders = new ArrayBlockingQueue<Order>(1024);
        	this.clients = new ArrayBlockingQueue<Client>(1024);
        	factory = DAOFactory.getDAOFactory(1);
        	this.generator = new ClientGenerator(this, clients, cantClients);
        	this.cashier = new Cashier(this, orders, clients, sandwiches, factory);
        	this.preparer  = new Preparer(this, orders);
        }
        
    public void stopExecution() {
    	stop = true;
    }

        
    public void startExecution() {
    	stop = false;
    	generator.start();
    	cashier.start();
    	preparer.start();
    }
    
    public boolean isStopped() {
    	return stop;
    }

    private static int clientsRandom() {
        return (int)(Math.random()*(70-1+20)+1);
    }


}
