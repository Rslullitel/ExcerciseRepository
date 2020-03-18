package com.prokarma.ejercitacion.ej19;

import java.util.List;

public class Sandwich {
	
	 private List<Ingredient> ingredients;
	    private Boolean isReady;
	    private int price ;
	    private int idSandwich;

	    public Sandwich(int id, int price, List<Ingredient> ingredients){
	        this.idSandwich = id;
	        this.ingredients = ingredients;
	        this.price = price;
	        this.isReady = false;
	    }

	    public void addIngredients(Ingredient ingredient){
	        this.ingredients.add(ingredient);
	    }


	    public List<Ingredient> getIngredients() {
	        return ingredients;
	    }

	    public void setIngredients(List<Ingredient> ingredients) {
	        this.ingredients = ingredients;
	    }

	    public Boolean getReady() {
	        return isReady;
	    }

	    public void setReady(Boolean ready) {
	        isReady = ready;
	    }

	    public int getPrice() {
	        return price;
	    }

	    public void setPrice(int price) {
	        this.price = price;
	    }

	    public int getIdSandwich() {
	        return idSandwich;
	    }

	    public void setIdSandwich(int idSandwich) {
	        this.idSandwich = idSandwich;
	    }

	    public String toString(){
	        return 	" $" + this.price +
	                " which has " + this.ingredients.toString();
	    }

	
	
	
}
