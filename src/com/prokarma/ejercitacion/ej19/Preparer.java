package com.prokarma.ejercitacion.ej19;

import java.util.concurrent.BlockingQueue;

public class Preparer extends Thread{

	   private BlockingQueue<Order> orders;
	    private int cantClients;

	    public Preparer(BlockingQueue<Order> orders, int cantClients){
	        this.orders = orders;
	        this.cantClients = cantClients;
	    }

	    @Override
	    public void run(){
	        for(int i = 0; i < cantClients; i++){
	            while (this.orders.isEmpty()) {
	            }
	            deliverOrder(this.orders.poll());
	        }

	    }

	    private void deliverOrder (Order order){
	        for (Sandwich s: order.getSandwiches()){
	            s.setReady(true);
	        }
	        order.setReady(true);
	        System.out.println("the order has been delivered !");
	    }
}



/*public Preparer(BlockingQueue<Ticket> tickets) {
	super(tickets);
	window = new Window();
}

@Override
public void run() {
	Ticket ticket;
	
	for(int i = 0; i < 20; i++) {
		while(this.getTickets().isEmpty()) {
		}
		ticket = this.pollTicket();
		for(int j = 0; j < ticket.getSandwiches().size(); j++) {
			finalizeOrder(ticket.getSandwiches().get(j));
		}
		ticket.changeStateOrder();
			System.out.println(ticket.toString());
			System.out.println("Bye, have a nice day");
		time();	
	}
}*/










