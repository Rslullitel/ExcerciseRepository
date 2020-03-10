package com.prokarma.ejercitacion.ej19;

public class Window {

	private Ingredient salami;
	private Ingredient cookedHam;
	private Ingredient rawHam;
	private Ingredient danbo;
	private Ingredient cheddar;
	
	public Window() {
		salami = new Ingredient("salami", 100);
		rawHam = new Ingredient("rawHam", 300);
		cookedHam = new Ingredient("cookedHam", 300);
		danbo = new Ingredient("danbo", 300);
		cheddar = new Ingredient("cheddar", 300);
	}

	public void lessDanbo(int less) {
		this.danbo.setWeight(less);
	}
	
	public void lessCheddar(int less) {
		this.cheddar.setWeight(less);
	}
	
	public void lessRawHam(int less) {
		this.rawHam.setWeight(less);
	}
	
	public void lessCookedHam(int less) {
		this.cookedHam.setWeight(less);
	}
	
	public void lessSalami(int less) {
		this.salami.setWeight(less);
	}
	
	public Ingredient getSalami() {
		return salami;
	}
	public void setSalami(Ingredient salami) {
		this.salami = salami;
	}
	public Ingredient getCookedHam() {
		return cookedHam;
	}
	public void setCookedHam(Ingredient cookedHam) {
		this.cookedHam = cookedHam;
	}
	public Ingredient getRawHam() {
		return rawHam;
	}
	public void setRawHam(Ingredient rawHam) {
		this.rawHam = rawHam;
	}
	public Ingredient getDanbo() {
		return danbo;
	}
	public void setDanbo(Ingredient danbo) {
		this.danbo = danbo;
	}
	public Ingredient getCheddar() {
		return cheddar;
	}
	public void setCheddar(Ingredient cheddar) {
		this.cheddar = cheddar;
	}

	
	
	
}
