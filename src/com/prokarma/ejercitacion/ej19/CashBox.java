package com.prokarma.ejercitacion.ej19;

import java.util.List;

public class CashBox {

	private int amount;
	
	public Ticket generateTicket(int amount, List<String> sandwiches) {
		this.amount += amount;
		return new Ticket(sandwiches);
	}
	
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	public String toString() {
		return "Amount: $" + this.amount;
	}
	
}
