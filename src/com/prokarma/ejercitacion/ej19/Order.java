package com.prokarma.ejercitacion.ej19;

import java.util.List;

public class Order {

	private boolean state;
	private int number;
	private List<Sandwich> sandwiches;
	
	public Order(List<Sandwich> sandwiches) {
		this.state = false;
		this.number++;
		this.sandwiches = sandwiches;
	}
	
	
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public List<Sandwich> getSandwiches() {
		return sandwiches;
	}
	public void setSandwiches(List<Sandwich> sandwiches) {
		this.sandwiches = sandwiches;
	}
	
	
	public String toString() {
		return "Order number: " + this.number + 
			   "\nSandwiches: " + this.sandwiches.toString();
	}
}
