package com.prokarma.ejercitacion.ej19;

public class Cheese extends Ingredient{

	private CheeseType cheeseType;
	
	public Cheese(String name, double weight) {
		super(name, weight);
	}

	
	public CheeseType getCheeseType() {
		return cheeseType;
	}
	public void setCheeseType(CheeseType cheeseType) {
		this.cheeseType = cheeseType;
	}
	
	
	
}
