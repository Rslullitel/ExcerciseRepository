package com.prokarma.ejercitacion.ej19;

public class Window {

	private Salami salami;
	private Ham raw;
	private Ham cooked;
	private Cheese danbo;
	private Cheese cheddar;
	
	public Window() {
		salami = new Salami("salami", 100);
		raw = new Ham("raw", 100);
		cooked = new Ham("cooked", 100);
		danbo = new Cheese("danbo", 100);
		cheddar = new Cheese("cheddar", 100);
	}

	
	public Salami getSalami() {
		return salami;
	}
	public void setSalami(Salami salami) {
		this.salami = salami;
	}
	public Ham getRaw() {
		return raw;
	}
	public void setRaw(Ham raw) {
		this.raw = raw;
	}
	public Ham getCooked() {
		return cooked;
	}
	public void setCooked(Ham cooked) {
		this.cooked = cooked;
	}
	public Cheese getDanbo() {
		return danbo;
	}
	public void setDanbo(Cheese danbo) {
		this.danbo = danbo;
	}
	public Cheese getCheddar() {
		return cheddar;
	}
	public void setCheddar(Cheese cheddar) {
		this.cheddar = cheddar;
	}
	
	
}
