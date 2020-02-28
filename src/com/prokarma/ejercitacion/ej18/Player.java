package com.prokarma.ejercitacion.ej18;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Player extends Thread{

	private static final int WATER = 0;
	private static final int BOAT = 1;
	private static final int MARKED = -1;
	
	private Table table;
	private Table oponentTable;
	private String userName;
	private int remainingBoats;
	private Message message;
	BlockingQueue<Position> coordinates;
	BlockingQueue<Message> messages;
	
	
	public Player(BlockingQueue<Position> coordinates, BlockingQueue<Message> messages, Table table, String userName) {
		this.coordinates = coordinates;
		this.messages = messages;
		this.table = table;
		this.userName = userName;
		this.remainingBoats = 3;
		this.oponentTable = new Table();
	} 

	@Override
	public void run() {
		int row; 
		int column;
		Position position;
		
		this.message = this.messages.poll();
		
		if(!this.message.equals(Message.LOSE)) {
			response();

			boolean existPosition = true;
			do {
				position = this.oponentTable.getPosition(stringRandom(), intRandom());
				row = position.getRow();
				column = position.getColumn();			
				if(this.oponentTable.getTable()[row][column] != MARKED) {
					existPosition = false;
					this.oponentTable.getTable()[row][column] = MARKED;
				}
			}while(existPosition);
			
			coordinates.add(position);
		}
	}
	
	public void response(){
		Position position = coordinates.poll();
		int row = position.getRow();
		int column = position.getColumn();

		if(this.table.getTable()[row][column] == BOAT) {
			this.remainingBoats -= 1;
			this.table.getTable()[row][column] = WATER;
			if(this.remainingBoats == 0) {
				this.messages.add(Message.LOSE);
			}else {
				this.messages.add(Message.SUNKEN);
			}
		}else {
			this.messages.add(Message.WATER);
			this.table.getTable()[row][column] = MARKED;
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
	
	public Message getMessage() {
		return message;
	}

	public String toString() {
		return "Player: " + this.userName;
	}
	
}
