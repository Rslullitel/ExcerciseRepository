package com.prokarma.ejercitacion.ej19;

import java.util.List;

public class Ticket {

	private String typePay;
	private Order order;
	private int total;
	
	public Ticket(String typePay, int total, List<Sandwich> sandwiches) {
		this.order = new Order(sandwiches);
		this.typePay = typePay;
		this.total = total;
	}

	public List<Sandwich> getSandwiches(){
		return this.order.getSandwiches();
	}
	
	public void changeStateOrder() {
		this.order.setState(true);
	}
	
	public int getNumber() {
		return this.order.getNumber();
	}
	
	public String getTypePay() {
		return typePay;
	}
	public void setTypePay(String typePay) {
		this.typePay = typePay;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	
	public String toString() {
		return this.order.toString() + 
			   "\nType pay: " + this.typePay + 
			   "\nTotal: " + this.total;
	}
	
}
