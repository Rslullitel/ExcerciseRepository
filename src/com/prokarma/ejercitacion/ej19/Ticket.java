package com.prokarma.ejercitacion.ej19;

public class Ticket {

	 private int number;
	private int amount ;
	private String typePay;

	    public Ticket(int amount, String typePay){
	        this.amount = amount;
	        this.typePay = typePay;
	        this.number = number+1;
	    }

	    public int getAmount() {
	        return amount;
	    }

	    public void setAmount(int amount) {
	        this.amount = amount;
	    }
	
	public String toString() {
		return "Ticket number: " + this.number + 
			   "\nType pay: " + this.typePay + 
			   "\nTotal: " + this.amount;
	}
	
}
