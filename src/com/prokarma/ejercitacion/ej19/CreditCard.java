package com.prokarma.ejercitacion.ej19;

public class CreditCard implements Payment{

	@Override
	public int pay(int amount) {
		return amount;
	}
	
	
	public String toString() {
		return "credit card";
	}

}
