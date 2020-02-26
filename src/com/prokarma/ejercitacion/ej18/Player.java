package com.prokarma.ejercitacion.ej18;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Player extends Thread{

	private Table table;
	private String userName;
	private String color;
	private int remainingBoats;
	private Message message;
	BlockingQueue<int[][]> coordinates; // posiciones de la matriz 
	BlockingQueue<Message> messages;
	
	
	public Player(BlockingQueue<int[][]> coordinates, BlockingQueue<Message> messages, Table table, String userName, String color) {
		this.coordinates = coordinates;
		this.messages = messages;
		this.table = table;
		this.userName = userName;
		this.color = color;
		this.remainingBoats = 3;
	} 

	@Override
	public void run() {
		while(!this.messages.peek().equals(Message.LOSE)) {
			counterStrike(stringRandom(), intRandom());
		}
	}
	
	public void counterStrike(String row, int column){
		int i = 0;
		
		while(i < this.table.getLetters().length && !this.table.getLetters()[i].equalsIgnoreCase(row)) {
			if(!this.table.getLetters()[i].equalsIgnoreCase(row)) {
				i++;
			}
		}
		if(this.table.getTable()[i][column-1] == 1) {
			this.remainingBoats -= 1;
			if(this.remainingBoats == 0) {
				this.messages.add(Message.LOSE);
			}else {
				this.messages.add(Message.SUNKEN);
			}
		}else {
			this.messages.add(Message.WATER);
		}

	}
	
	
	private String stringRandom() {
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 104; // letter 'h'
	    int targetStringLength = 1;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    int randomLimitedInt = leftLimit + (int) 
	    (random.nextFloat() * (rightLimit - leftLimit + 1));
	    buffer.append((char) randomLimitedInt);
	    String letRand = buffer.toString();
	return letRand; 
	}
	
	private int intRandom() {
		 Random rand1 = new Random();
		 int numRand = rand1.nextInt(7);		 
	return numRand;	 
	}
	
	public void putBoats(String row, int column) {
		this.table.putBoats(row, column);
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getColor() {
		return color;
	}	
	public Message getMessage() {
		return message;
	}

	public String toString() {
		return "Player: " + this.userName +
			   "\nTeam color: " + this.color;
	}
	
}
