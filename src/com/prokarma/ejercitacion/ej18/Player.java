package com.prokarma.ejercitacion.ej18;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

public class Player extends Thread{

	private Table table;
	private String userName;
	private String color;
	private int remainingBoats;
	private Message message;
	BlockingQueue<Integer> coordinates; // posiciones de la matriz 
	BlockingQueue<Message> messages;
	Map<String, Set<Integer>> markedPositions;
	
	
	public Player(BlockingQueue<Integer> coordinates, BlockingQueue<Message> messages, Table table, String userName, String color) {
		this.coordinates = coordinates;
		this.messages = messages;
		this.markedPositions = new HashMap<String, Set<Integer>>();
		this.table = table;
		this.userName = userName;
		this.color = color;
		this.remainingBoats = 3;
	} 

	@Override
	public void run() {
		String row; 
		int column;
		boolean existPosition = false;
		Set<Integer> columns = null;
		
		this.message = this.messages.poll();
		
		while(!this.message.equals(Message.LOSE)) {
			response();

			do {
				row = stringRandom();
				column = intRandom();
				if(this.markedPositions.containsKey(row)) {
					if(this.markedPositions.get(row).contains(column)) {	
						existPosition = true;
					}else {
						this.markedPositions.get(row).add(column);
					}
				}else {
					this.markedPositions.put(row, columns);
					this.markedPositions.get(row).add(column);
					existPosition = false;
				}
			}while(existPosition);
			
			coordinates.add(this.table.convert(row));
			coordinates.add(column);
		}
	}
	
	public void response(){
		int row = coordinates.poll();
		int column = coordinates.poll();

		if(this.table.getTable()[row][column-1] == 1) {
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
