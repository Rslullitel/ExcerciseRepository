package com.prokarma.ejercitacion.ej19;

public class Ham extends Ingredient{

	private HamType hamType;
	
	public Ham(String name, double weight) {
		super(name, weight);
	}

	
	public HamType getHamType() {
		return hamType;
	}
	public void setHamType(HamType hamType) {
		this.hamType = hamType;
	}
	
	
	
}
