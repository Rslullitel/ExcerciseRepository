package com.prokarma.ejercitacion.ej19;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class Cashier extends Thread{
	
	  private BlockingQueue<Order> orders;
	    private BlockingQueue<Client> clients;
	    private CashBox cashBox;
	    private List<Sandwich> sandwiches;
	    private ExecutionContext executionContext;

	    public Cashier(ExecutionContext executionContext, BlockingQueue<Order> orders, BlockingQueue<Client> clients, List<Sandwich> sandwiches) {
	        this.orders = orders;
	        this.clients = clients;
	        this.cashBox = new CashBox();
	        this.sandwiches = sandwiches;
	        this.executionContext = executionContext;
	    }

	    @Override
	    public void run() {
	        List<Sandwich> mySandwiches;
	        Client client;
	        Sandwich sandwich;
	        boolean existStock = false;
	        int num;
	        
	        while(!this.executionContext.isStopped()){
	            int totalAmount = 0;
	            if(!this.clients.isEmpty()){
	            	showMenu();
		            mySandwiches = new ArrayList<Sandwich>();
		            client = this.clients.poll();
		            System.out.println("How many sandwich do yo want?");
		            num = client.intRandom();
		            System.out.println("Select the sandwich that you want");
		            if(this.stocks.isEmpty()) {//get all stock
			        	System.out.println("You are out of stock");
	            		this.executionContext.stopExecution();
			        }else {
			        	for(int i = 0; i < num; i++){
			            	do {
				            	sandwich = selectSandwich(client.sandwichRandom());
				           		if(sandwich == null) {
				           			existStock = false;
				           		}else {
				           			existStock = true;
				           			decreaseStock(sandwich);
				           			totalAmount += sandwich.getPrice();
				           			mySandwiches.add(sandwich);
				           		}
			            	}while(!existStock);
				        }  
			        }
			            System.out.println("The total amount is $" + totalAmount);
			        this.sendOrder(new Order(mySandwiches, charge(client.pay(totalAmount), client.showPay())));
		        }else {
		        	waitForClient();
		        }
	        }
	        System.out.println("The cashbox have: " + this.cashBox + " pesos");
	    }
	    
	    public void waitForClient() {
	    	try {
				sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }

	    
	    private void decreaseStock(Sandwich sandwich) {// update sandwich
	    	//completar
	    }

	    private void sendOrder(Order order){//insert order
	        this.orders.add(order);
	    }

	    
	    private Ticket charge(int totalAmount, String typePay){
	       return this.cashBox.generateTicket(totalAmount, typePay);
	    }
	    

	    private Sandwich selectSandwich(int id) {
	        Sandwich sandwich = null;

	        	if(!thereStock(id)) {
		        	System.out.println("No more stock of the sandwich number " + id);
		        }else {
		        	sandwich = this.sandwiches.get(id);
		 	            System.out.println("You choose sandwich number " + sandwich.getIdSandwich());
		        }
	        return sandwich;
	    }
	    
	    private boolean thereStock(int id) {//get stock SandwichDAO
	    	return false;
	    }

	    private void showMenu(){
	        for(Sandwich s : this.sandwiches){
	            System.out.println(s.toString());
	        }
	    }
}
