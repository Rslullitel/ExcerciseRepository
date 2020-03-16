package com.prokarma.ejercitacion.ej19;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Cashier extends Thread{
	
	  private BlockingQueue<Order> orders;
	    private BlockingQueue<Client> clients;
	    private CashBox cashBox;
	    private List<Stock> stocks;
	    private List<Sandwich> sandwiches;
	    private int cantClients;

	    public Cashier(BlockingQueue<Order> orders, BlockingQueue<Client> clients, List<Stock> stocks, List<Sandwich> sandwiches, int cantClients) {
	        this.orders = orders;
	        this.clients = clients;
	        this.cashBox = new CashBox();
	        this.stocks = stocks;
	        this.sandwiches = sandwiches;
	        this.cantClients = cantClients;
	    }

	    @Override
	    public void run(){
	        List<Sandwich> mySandwiches;
	        Client client;
	        Sandwich sandwich;
	        String typePay;
	        boolean paymentOk;
	        boolean existStock;
	        int num;
	        //i < cantClients && thereTotalStock != 0
	        for(int j = 0; j < cantClients; j++){
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
	        }
	        System.out.println("The cashbox have: " + this.cashBox + " pesos");
	    }

	    private void decreaseStock(Sandwich sandwich) {
	        int i = 0;
	        int quantity;
	        while(i < this.stocks.size() && sandwich.getIdSandwich() != this.stocks.get(i).getIdSandwich()){
	            i++;
	        }
	        quantity = this.stocks.get(i).getStockQuantity();
	        this.stocks.get(i).setStockQuantity(quantity-1);
	        //this.totalStock -= 1;
	    }

	    private void sendOrder(Order order){
	        this.orders.add(order);
	    }

	    private Ticket charge(String typePay, int totalAmount){
	       return this.cashBox.generateTicket(totalAmount, typePay);
	    }

	    private Sandwich selectSandwich(int id) throws NoMoreStockException{
	        int i = 0;
	        Sandwich sandwich;
	        if(!thereStock(id)) {
	        	throw new NoMoreStockException("No more stock of the sandwich number " + id);
	        }else {
	        	while (i < this.sandwiches.size() && this.sandwiches.get(i).getIdSandwich() != id){
	 	           i++;
	 	        }
	 	        sandwich = this.sandwiches.get(i);
	 	            System.out.println("You choose sandwich number " + sandwich);

	 	        return sandwich;
	        }
	    }
	    
	    private boolean thereStock(int id) {
	    	int i = 0;
	    	Stock stock;
	    	boolean ans = false;
	    	while (i < this.stocks.size() && this.stocks.get(i).getIdSandwich() != id){
		           i++;
		        }
	    	stock = this.stocks.get(i);
	    	if(stock.getStockQuantity() != 0) {
	    		ans = true;
	    	}
	    	return ans;
	    }
	    
	 /*   private int thereTotalStock() {
	    	int totalQuantity = 0; 
	    	
	    	for(Stock s : this.stocks) {
	    		totalQuantity += s.getStockQuantity();
	    	}
	    	return totalQuantity;
	    }*/

	    private void showMenu(){
	        for(Sandwich s : this.sandwiches){
	            System.out.println(s.toString());
	        }
	    }
	    
	    public int sandwichRandom() {
	    	return (int)(Math.random()*(5-1+1)+1);
	    }
    
}

/*private BlockingQueue<Client> clients; 
private CashBox cashBox;
private int total;

public Cashier(BlockingQueue<Client> clients, BlockingQueue<Ticket> tickets) {
	super(tickets);
	this.cashBox = new CashBox();
	this.clients = clients;
}

@Override
public void run() {
	List<Sandwich> myTicket;
	Sandwich sandwichSelected;
	Ticket ticket;
	Client client;
	String typePay;
	boolean paymentOk;
	int type;
	int rand;
	
	for(int i = 0; i < 20; i++) {
		while(this.clients.isEmpty()) {
		}
		myTicket = new ArrayList<Sandwich>();
		client = clients.poll();
			System.out.println("Client " + i);
		Test.askForCount();
		rand = intRandom();
			System.out.println(rand);
		Test.askForSandwich();
		for(int j = 0; j < rand; j++) {//5 = numero random generado por metodo			
			sandwichSelected = selectSandwich(intRandom());
			summary(sandwichSelected.getPrice());
			Test.askForBread();
			sandwichSelected.addBread(selectBread(numRandom()));
			myTicket.add(sandwichSelected);
		}
		do {
			Test.typePay();
			type = numRandom();
			typePay = client.selectTypePay(type);
				System.out.println(typePay);
			try {
				ticket = charge(typePay, client.pay(type, total), myTicket);
				this.addTickets(ticket);
				this.total = 0;
				paymentOk = true;
			} catch (NotEnoughCashException e) {//si catchea excepcion pregunta de nuevo metodo de pago
					System.out.println(e.getMessage());
					System.out.println("Try paying with credit card");
				paymentOk = false;	
			}
		}while(!paymentOk);
		time();
	}
	System.out.println("The cashbox have: " + this.cashBox.toString() + " pesos");
}

public Ticket charge(String typePay, int amount, List<Sandwich> myTickets) {//AMOUNT = PRECIO TOTAL DE TODOS LOS SANDWICHES
	return this.cashBox.generateTicket(typePay, amount, myTickets);
}

private Sandwich selectSandwich(int index) {
	return Sandwich.selectSandwich(index);
}

private Bread selectBread(int index) {
	return Bread.selectBread(index);
}

private void summary(int precio) {
	this.total += precio;
}

public void time() {
	try {
		sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}

public int numRandom() {
	return (int)(Math.random()*(2-1+1)+1);
}



public CashBox getCashBox() {
	return cashBox;
}
public void setCashBox(CashBox cashBox) {
	this.cashBox = cashBox;
}
public BlockingQueue<Client> getClients() {
	return clients;
}
public void setClients(BlockingQueue<Client> clients) {
	this.clients = clients;
}*/