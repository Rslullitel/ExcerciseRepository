package com.prokarma.ejercitacion.ej19;

public abstract class Ingredient {

	private String name;
	private double quantity;
	
	public Ingredient(String name, double quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getWeight() {
		return quantity;
	}
	public void setWeight(double quantity) {
		this.quantity = quantity;
	}
	
	
	
}
