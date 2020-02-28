package com.prokarma.ejercitacion.ej18;

public class Table {
	
	private static final int BOAT = 1;

	private String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h"};
	private int[][] table;//hacer matriz a boolean[][]
	
	public Table() {
		this.table = new int[8][8]; 
	}
	 	
	public void putBoats(String row, int column) {
		this.table[convert(row)][column-1] = BOAT;
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
	
	public Position getPosition(String row, int column) {
		return new Position(convert(row), column);
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
