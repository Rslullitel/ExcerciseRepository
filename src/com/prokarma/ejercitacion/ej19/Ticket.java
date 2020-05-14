package com.prokarma.ejercitacion.ej19;

import java.sql.Timestamp;

public class Ticket {

	private int number;
	private int amount;
	private String typePay;
	private Timestamp date;

	public Ticket(int amount, String typePay) {
		this.amount = amount;
		this.typePay = typePay;
		this.date = new Timestamp(System.currentTimeMillis());
	}
	
	

	public String getTypePay() {
		return typePay;
	}



	public void setTypePay(String typePay) {
		this.typePay = typePay;
	}



	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
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





}
