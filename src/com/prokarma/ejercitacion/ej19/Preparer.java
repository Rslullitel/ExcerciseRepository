package com.prokarma.ejercitacion.ej19;

import java.util.concurrent.BlockingQueue;

public class Preparer extends Thread{

	   private BlockingQueue<Order> orders;
	   private ExecutionContext executionContext;
	   

	    public Preparer(ExecutionContext executionContext, BlockingQueue<Order> orders){
	        this.orders = orders;
	        this.executionContext = executionContext;
	    }

	    @Override
	    public void run(){
	        while(!this.executionContext.isStopped()){
	            if(!this.orders.isEmpty()) {
	            	deliverOrder(this.orders.poll());
	            }
	        }
	    }

	    private void deliverOrder (Order order){
	        order.setReady(true);
	        System.out.println("the order has been delivered !");
	    }
}