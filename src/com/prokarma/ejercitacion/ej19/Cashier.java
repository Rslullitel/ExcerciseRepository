package com.prokarma.ejercitacion.ej19;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.BlockingQueue;

import com.prokarma.ejercitacion.ej19.dao.inter.DAOFactory;
import com.prokarma.ejercitacion.ej19.dao.inter.OrderDAO;
import com.prokarma.ejercitacion.ej19.dao.inter.SandwichDAO;
import com.prokarma.ejercitacion.ej19.exception.UpdateDataException;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public class Cashier extends Thread {
	
	private BlockingQueue<Order> orders;
	private BlockingQueue<Client> clients;
	private CashBox cashBox;
	private List<Sandwich> sandwiches;
	private ExecutionContext executionContext;
	private SandwichDAO sandwichDAO;
	private OrderDAO orderDAO;
	private DAOFactory mySql;
	

	public Cashier(ExecutionContext executionContext, BlockingQueue<Order> orders, BlockingQueue<Client> clients, List<Sandwich> sandwiches) throws DataBaseException {
		this.orders = orders;
		this.clients = clients;
		this.mySql = getMySqlDAOFactory();
		this.cashBox = new CashBox(mySql.getTicketDAO());
		this.sandwiches = sandwiches;
		this.executionContext = executionContext;
		this.sandwichDAO = mySql.getSandwichDAO();
		this.orderDAO = mySql.getOrderDAO();
	}
	
	public DAOFactory getMySqlDAOFactory() throws DataBaseException {
		DAOFactory daoFactory = null;
		return daoFactory.getDAOFactory(1);
	}

	@Override
	public void run() {
		Map<Integer, Integer> mapStocks;
		Client client;
		Sandwich sandwich;
		int num;

		while (!this.executionContext.isStopped()) {
			int totalAmount = 0;
			if (!this.clients.isEmpty()) {
				showMenu();
				mapStocks = new TreeMap<Integer, Integer>();
				client = this.clients.poll();
				System.out.println("How many sandwich do yo want?");
				num = client.intRandom();
				System.out.println("Select the sandwich that you want");
				if (!this.haveAllSandwichStock()) {
					System.out.println("You are out of stock");
					this.executionContext.stopExecution();
				} else {
					for (int i = 0; i < num; i++) {
						sandwich = selectSandwich(client.sandwichRandom());
						totalAmount += sandwich.getPrice();
						if(!mapStocks.containsKey(sandwich.getIdSandwich())) {
							mapStocks.put(sandwich.getIdSandwich(), 1);
						}else {
							mapStocks.replace(sandwich.getIdSandwich(), mapStocks.get(sandwich.getIdSandwich())+1);
						}
					}
					if(existSandwichStock(mapStocks)) {
						System.out.println("The total amount is $" + totalAmount);
						this.sendOrder(new Order(mapStocks, charge(client.pay(totalAmount), client.showPay())));
						decreaseSandwichStock(mapStocks);
					}else {
						System.out.println("The order has been rejected because fault of stock");
					}
				}
			} else {
				waitForClient();
			}
		}
	}

	public void waitForClient() {
		try {
			sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void decreaseSandwichStock(Map<Integer, Integer> stocks) {
		try {
			this.sandwichDAO.decreaseStock(stocks);
		} catch (UpdateDataException | DataBaseException e) {
			System.out.println(e.getMessage());
		}
	}

	private void sendOrder(Order order) {
		try {
			this.orderDAO.insert(order);
		} catch (UpdateDataException | DataBaseException e) {
			System.out.println(e.getMessage());
		}
		this.orders.add(order);
	}

	private Ticket charge(int totalAmount, String typePay) {
		return this.cashBox.generateTicket(totalAmount, typePay);
	}

	private Sandwich selectSandwich(int id) {
		Sandwich sandwich = null;

		sandwich = this.sandwiches.get(id-1);
		System.out.println("You choose sandwich number " + sandwich.getIdSandwich());
		
		return sandwich;
	}

	private boolean existSandwichStock(Map<Integer, Integer> mapStocks) {
		
		boolean resp = false;
		try {
			resp = this.sandwichDAO.isAvailableStock(mapStocks);
		} catch (DataBaseException e) {
			System.out.println(e.getMessage());
		}
		return resp;
	}

	private boolean haveAllSandwichStock() {
		boolean resp = false;
		try {
			resp = this.sandwichDAO.getTotalStock() != 0;
		} catch (UpdateDataException | DataBaseException e) {
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
