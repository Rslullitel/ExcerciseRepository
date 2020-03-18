package com.prokarma.ejercitacion.ej19;

public class Client {

	    private int availableAmount;
	    private Payment payment;

	    public Client(int availableAmount) {
	        this.availableAmount = availableAmount;
	    }
	   
	    public int pay(int amount) {
	    	int pay; 
	    	if(this.availableAmount > amount) {
	    		this.payment = new Cash();
	    		this.availableAmount -= amount;
	    		pay = payment.pay(amount);
	        }else {
	            this.payment = new CreditCard();
	            pay = this.payment.pay(amount);
	        }
	    	return pay;
	    }

	    public int intRandom(){
	        int num;
	        num = (int)(Math.random()*(5-1+1)+1);
	        System.out.println("i want " + num + " sandwich");
	        return num;
	    }
	    
	    public String showPay() {
	    	return this.payment.toString();
	    }

}
