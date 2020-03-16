package com.prokarma.ejercitacion.ej19;

public class Client {
	
	  private static final int CASH = 1;
	    private static final String PAY_1 = "cash";
	    private static final String PAY_2 = "credit card";

	    private int availableAmount;
	    private Payment payment;

	    public Client(int availableAmount) {
	        this.availableAmount = availableAmount;
	    }

	    public int pay(String typePay, int amount) throws NotEnoughCashException {
	        if(typePay.equalsIgnoreCase(PAY_1)) {
	            this.payment = new Cash();
	            if(this.availableAmount < amount) {
	                throw new NotEnoughCashException("You do not have enough money to pay");
	            }else {
	                this.availableAmount -= amount;
	                return payment.pay(amount);
	            }
	        }else {
	            this.payment = new CreditCard();
	            return this.payment.pay(amount);
	        }
	    }

	    public int intRandom(){
	        int num;
	        num = (int)(Math.random()*(5-1+1)+1);
	        System.out.println("i want " + num + " sandwich");
	        return num;
	    }

	    public String typePayRandom(){
	        if((int)(Math.random()*(2-1+1)+1) == CASH){
	                System.out.println("I want to pay " + PAY_1);
	            return "cash";
	        }else{
	                System.out.println("I want to pay " + PAY_2);
	            return "credit card";
	        }

	    }
}
