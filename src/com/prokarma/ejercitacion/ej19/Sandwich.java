package com.prokarma.ejercitacion.ej19;

public class Sandwich {
	
	private String type;
	private int price;
	private boolean state;
	private Bread bread;
	
	public Sandwich(String type, int price) {
		this.type = type;
		this.price = price;
		this.state = false;//por preparar
	}
	

	public void addBread(Bread bread) {
		this.setBread(bread);
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrecio() {
		return price;
	}
	public void setPrecio(int precio) {
		this.price = precio;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public Bread getBread() {
		return bread;
	}
	public void setBread(Bread bread) {
		this.bread = bread;
	}
	
	
	public String toString() {
		return "Sandwich: " + this.type;
	}
	
}
