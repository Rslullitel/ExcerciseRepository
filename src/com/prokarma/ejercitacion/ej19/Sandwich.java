package com.prokarma.ejercitacion.ej19;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
	
	//private String tipo;
	//private int precio;
	private List<Ingredient> ingredients;
	private boolean state;
	
	public Sandwich() {
		this.ingredients = new ArrayList<Ingredient>();
		this.state = false;//por preparar
	}

	public void addIngredients(Ingredient ingredient) {
		this.ingredients.add(ingredient);
	}
	
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	
	
	
}
