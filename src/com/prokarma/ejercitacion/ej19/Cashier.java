package com.prokarma.ejercitacion.ej19;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.BlockingQueue;

import com.prokarma.ejercitacion.ej19.dao.DAOFactory;
import com.prokarma.ejercitacion.ej19.dao.MySqlOrderDAO;
import com.prokarma.ejercitacion.ej19.dao.MySqlSandwichDAO;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public class Cashier extends Thread {
	
	private BlockingQueue<Order> orders;
	private BlockingQueue<Client> clients;
	private CashBox cashBox;
	private List<Sandwich> sandwiches;
	private ExecutionContext executionContext;
	private MySqlSandwichDAO sandwichDAO;
	private MySqlOrderDAO orderDAO;

	public Cashier(ExecutionContext executionContext, BlockingQueue<Order> orders, BlockingQueue<Client> clients, List<Sandwich> sandwiches, DAOFactory mySql) {
		this.orders = orders;
		this.clients = clients;
		this.cashBox = new CashBox(mySql.getTicketDAO());
		this.sandwiches = sandwiches;
		this.executionContext = executionContext;
		this.sandwichDAO = mySql.getSandwichDAO();
		this.orderDAO = mySql.getOrderDAO();
	}

	@Override
	public void run() {
		List<Sandwich> mySandwiches;
		Map<Integer, Integer> mapStocks;
		Client client;
		Sandwich sandwich;
		boolean existStock = false;
		int num;

		while (!this.executionContext.isStopped()) {
			int totalAmount = 0;
			if (!this.clients.isEmpty()) {
				showMenu();
				mySandwiches = new ArrayList<Sandwich>();
				mapStocks = new TreeMap<Integer, Integer>();
				client = this.clients.poll();
				System.out.println("How many sandwich do yo want?");
				num = client.intRandom();
				System.out.println("Select the sandwich that you want");
				if (!this.thereAllStock()) {// get all stock
					System.out.println("You are out of stock");
					this.executionContext.stopExecution();
				} else {
					for (int i = 0; i < num; i++) {//en esta parte hay que crear un Map<Integer, integer> 
												   //para asi guardar toda la cantidad de sandwiches de un mismo tipo
												   //y descontarlas del stock y si no hay se tira excepcion y se rechaza la orden
						do {
							sandwich = selectSandwich(client.sandwichRandom());
							if (sandwich == null) {
								existStock = false;
							} else {
								existStock = true;
								totalAmount += sandwich.getPrice();
								mySandwiches.add(sandwich);
							}
						} while (!existStock);
					}
					mapStocks = this.stockCounter(mySandwiches);
					
					decreaseStock(mapStocks);
				}
				System.out.println("The total amount is $" + totalAmount);
				this.sendOrder(new Order(mySandwiches, charge(client.pay(totalAmount), client.showPay())), mapStocks);
			} else {
				waitForClient();
			}
		}
	}

	public Map<Integer, Integer> stockCounter(List<Sandwich> sandwiches) {
		Map<Integer, Integer> stocks = new TreeMap<Integer, Integer>();
		int index;
		for (int i = 0; i < sandwiches.size(); i++) {
			int stockQuantity = 0;
			index = sandwiches.get(i).getIdSandwich();
			if (!stocks.containsKey(index)) {
				for (int j = 0; j < sandwiches.size(); j++) {
					if (sandwiches.get(j).getIdSandwich() == index) {
						stockQuantity += 1;
					}
				}
				stocks.put(index, stockQuantity);
			}
		}
		return stocks;
	}

	public void waitForClient() {
		try {
			sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void decreaseStock(Map<Integer, Integer> stocks) {
		try {
			this.sandwichDAO.decreaseStock(stocks);
		} catch (DataBaseException e) {
			System.out.println(e.getMessage());
		}
	}

	private void sendOrder(Order order, Map<Integer, Integer> stocks) {
		try {
			this.orderDAO.insert(order, stocks);
		} catch (DataBaseException e) {
			System.out.println(e.getMessage());
		}
		this.orders.add(order);
	}

	private Ticket charge(int totalAmount, String typePay) {
		return this.cashBox.generateTicket(totalAmount, typePay);
	}

	private Sandwich selectSandwich(int id) {//1 . 2 . 4 . 1 --- stock 1 = 1 
		Sandwich sandwich = null;

		if (!thereSandwichStock(id)) {
			System.out.println("No more stock of the sandwich number " + id);
		} else {
			sandwich = this.sandwiches.get(id-1);
			System.out.println("You choose sandwich number " + sandwich.getIdSandwich());
		}
		return sandwich;
	}

	private boolean thereSandwichStock(int id) {
		boolean resp = false;
		try {
			resp = this.sandwichDAO.getSandwichStock(id);
		} catch (DataBaseException e) {
			System.out.println(e.getMessage());
		}
		return resp;
	}

	private boolean thereAllStock() {
		boolean resp = false;
		try {
			resp = this.sandwichDAO.getAllSandwichStock() != 0;
		} catch (DataBaseException e) {
			System.out.println(e.getMessage());
		}
		return resp;
	}

	private void showMenu() {
		for (Sandwich s : this.sandwiches) {
			System.out.println(s.toString());
		}
	}
}
