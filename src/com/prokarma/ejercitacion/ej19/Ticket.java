package com.prokarma.ejercitacion.ej19;

import java.sql.Date;

public class Ticket {

	private int number;
	private int amount;
	private String typePay;
	private Date date;

	public Ticket(int number, int amount, String typePay) {
		this.number = number;
		this.amount = amount;
		this.typePay = typePay;
		this.date = new Date(0);
	}
	
	

	public String getTypePay() {
		return typePay;
	}



	public void setTypePay(String typePay) {
		this.typePay = typePay;
	}



	public void setNumber(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String toString() {
		return "Ticket number: " + this.number + "\nType pay: " + this.typePay + "\nTotal: " + this.amount;
	}



	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
