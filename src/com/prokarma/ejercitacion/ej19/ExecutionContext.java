package com.prokarma.ejercitacion.ej19;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.prokarma.ejercitacion.ej19.bo.FacadeDAO;
import com.prokarma.ejercitacion.ej19.dao.DAOFactory;
import com.prokarma.ejercitacion.ej19.dao.MySqlDAOFactory;

public class ExecutionContext {

	private volatile boolean stop;
	
        private int cantClients = clientsRandom();
        private BlockingQueue<Order> orders;
        private BlockingQueue<Client> clients;
        private FacadeDAO facade;//agreagado
        private DAOFactory mySqlFactory;//agregado
        private ClientGenerator generator;
        private Cashier cashier;
        private Preparer preparer;
        
        public ExecutionContext(List<Sandwich> sandwiches) {
        	this.mySqlFactory = DAOFactory.getDAOFactory(1);
        	this.facade = new FacadeDAO(mySqlFactory);
        	this.orders = new ArrayBlockingQueue<Order>(1024);
        	this.clients = new ArrayBlockingQueue<Client>(1024);
        	this.generator = new ClientGenerator(this, clients, cantClients);
        	this.cashier = new Cashier(this, orders, clients, sandwiches, facade);
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
