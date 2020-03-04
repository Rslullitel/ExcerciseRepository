package com.prokarma.ejercitacion.ej18;

public class Table {
	
	private static final int WATER = 0;
	private static final int BOAT = 1;
	private static final int MARKED = -1;

	private String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h"};
	private int[][] table;
	
	public Table() {
		this.table = new int[8][8]; 
	}
	 	
	public void putBoats(String row, int column) {
		this.table[convert(row)][column-1] = BOAT;
	}
	
	public Position getPosition(String row, int column) {
		return new Position(convert(row), column);
	}
	
	public int getMarkedPosition(int row, int column) {
		if(this.table[row][column] == MARKED) {
			return MARKED;
		}else {
			this.table[row][column] = MARKED;
			return WATER;
		}
	}
	
	public int convert(String row) {
		int i = 0;
		while(i < this.letters.length && !this.letters[i].equalsIgnoreCase(row)) {
				i++;
		}
	return i;	
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
	public static int isBoat() {
		return BOAT;
	}
	

	
	
}
