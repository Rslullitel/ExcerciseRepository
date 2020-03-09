package com.prokarma.ejercitacion.ej19;

import java.util.List;

public class Ticket {

	//private String typePay;
	//private Order order;
	private int number;
	private List<String> sandwiches;
	
	public Ticket(List<String> sandwiches) {
		this.number++;
		this.sandwiches = sandwiches;
	}

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public List<String> getSandwiches() {
		return sandwiches;
	}
	public void setSandwiches(List<String> sandwiches) {
		this.sandwiches = sandwiches;
	}
	
	
	
}
