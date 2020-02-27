package com.prokarma.ejercitacion.ej18;

public class Table {

	private String color;
	private String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h"};
	private int[][] table;
	private int boat;
	
	public Table(String color) {
		this.table = new int[8][8];
		this.color = color;
		this.boat = 1;   
	}
	 
	
	public void putBoats(String row, int column) {
		this.table[convert(row)][column-1] = this.boat;
	}
	
	public void showTable() {
		System.out.println("Naval:");
		for(int i = 0; i < this.table.length; i++) {
			System.out.print("\n");
			for(int j = 0; j < this.table[0].length; j++) {
				System.out.print(this.table[i][j] + "  ");
			}
		}
	}
	
	public int convert(String row) {
		int i = 0;
		while(i < this.letters.length && !this.letters[i].equalsIgnoreCase(row)) {
				i++;
		}
	return i;	
	}


	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String[] getLetters() {
		return letters;
	}
	public void setLetters(String[] letters) {
		this.letters = letters;
	}
	public int[][] getTable() {
		return table;
	}
	public void setTable(int[][] table) {
		this.table = table;
	}
	public int getBoat() {
		return boat;
	}
	public void setBoat(int boat) {
		this.boat = boat;
	}
	
	
}
