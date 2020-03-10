package com.prokarma.ejercitacion.ej19;

public class Ingredient {

	private String name;
	private int quantity;
	
	public Ingredient(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return quantity;
	}
	public void setWeight(int quantity) {
		this.quantity -= quantity;
	}
	
	
	
}
