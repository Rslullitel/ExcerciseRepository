package com.prokarma.ejercitacion.ej19;

public class Client {
	
	private static final int CASH = 1;
	
	private int ticketNumber;
	private Order order;
	private int cash;
	private Payment payment;
	
	public Client(int cash) {
		this.cash = cash;
	}

	public int pay(int typePay, int amount) {
		if(typePay == CASH) {
			this.payment = new Cash();
			return payment.pay(amount);
		}else {
			this.payment = new CreditCard();
			return this.payment.pay(amount);
		}
	}
	
	
	public int getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
	
}
