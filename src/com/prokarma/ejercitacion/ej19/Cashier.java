package com.prokarma.ejercitacion.ej19;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class Cashier extends Thread{
	
	  private BlockingQueue<Order> orders;
	    private BlockingQueue<Client> clients;
	    private CashBox cashBox;
	    private Map<Integer, Stock> stocks;
	    private Map<Integer, Sandwich> sandwiches;
	    private int cantClients;

	    public Cashier(BlockingQueue<Order> orders, BlockingQueue<Client> clients, Map<Integer, Stock> stocks, Map<Integer, Sandwich> sandwiches, int cantClients) {
	        this.orders = orders;
	        this.clients = clients;
	        this.cashBox = new CashBox();
	        this.stocks = stocks;
	        this.sandwiches = sandwiches;
	        this.cantClients = cantClients;
	    }

	    @Override
	    public void run() {
	        List<Sandwich> mySandwiches;
	        Client client;
	        Sandwich sandwich;
	        String typePay;
	        boolean paymentOk;
	        boolean existStock = false;
	        int num;
	        int j = 0;
	        
	        while(j < cantClients && !this.stocks.isEmpty()){
	            int totalAmount = 0;
	            while(this.clients.isEmpty()){
	            }
	            mySandwiches = new ArrayList<Sandwich>();
	            client = this.clients.poll();
	            System.out.println("How many sandwich do yo want?");
	            num = client.intRandom();
	            System.out.println("Select the sandwich that you want");
	            showMenu();
	            for(int i = 0; i < num; i++){
	            	do {
		            	try {
		            		sandwich = selectSandwich(sandwichRandom());
		            		decreaseStock(sandwich);
		            		totalAmount += sandwich.getPrice();
		            		mySandwiches.add(sandwich);
		            		existStock = true;
		            	} catch (NoMoreStockException e) {
		            		System.out.println(e.getMessage());
		            		Test.stop = false;
		            	}catch (NoSandwichStockException e) {
		            		System.out.println(e.getMessage());
		            		existStock = false;
		            	} 		      
	            	}while(!existStock);
		        }  
	            do{
		            System.out.println("How do you want to pay?");
		            typePay = client.typePayRandom();
		            try {
		                this.sendOrder(new Order(mySandwiches, charge(typePay, client.pay(typePay, totalAmount))));
		                paymentOk = true;
		            } catch (NotEnoughCashException e) {
		                System.out.println(e.getMessage());
		                paymentOk = false;
		            }
	            }while(!paymentOk);
	            j++;
	        }
	        System.out.println("The cashbox have: " + this.cashBox + " pesos");
	    }

	    private void decreaseStock(Sandwich sandwich) {
	        Stock stock;
	        
	        stock = this.stocks.get(sandwich.getIdSandwich());
	        stock.decreaseQuantity();  
	        if(stock.getStockQuantity() == 0) {
	        	this.stocks.remove(stock.getIdSandwich());
	        }
	    }

	    private void sendOrder(Order order){
	        this.orders.add(order);
	    }

	    
	    private Ticket charge(String typePay, int totalAmount){
	       return this.cashBox.generateTicket(totalAmount, typePay);
	    }
	    

	    private Sandwich selectSandwich(int id) throws NoMoreStockException, NoSandwichStockException{
	        Sandwich sandwich;
	        
	        if(this.stocks.isEmpty()) {
	    		throw new NoMoreStockException("You are out of stock");	
	        }else if(!thereStock(id)) {
	        	throw new NoSandwichStockException("No more stock of the sandwich number " + id);
	        }else {
	        	sandwich = this.sandwiches.get(id);
	 	            System.out.println("You choose sandwich number " + sandwich);
	 	     return sandwich;
	        }
	    }
	    
	    private boolean thereStock(int id) throws NoMoreStockException {
	    	boolean ans;

	    	if(this.stocks.containsKey(id)) {
			    ans = true;
	    	}else {
	    		ans = false;
	    	}
		    return ans;
	    }

	    private void showMenu(){
	        for(Map.Entry<Integer, Sandwich> s : this.sandwiches.entrySet()){
	            System.out.println(s.toString());
	        }
	    }
	    
	    public int sandwichRandom() {
	    	return (int)(Math.random()*(5-1+1)+1);
	    }
    
}
