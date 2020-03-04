package com.prokarma.ejercitacion.ej18;

import java.util.Date;
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
	private boolean isMyTurn;
	private boolean gameNotOver;
	private Message message;
	BlockingQueue<Position> coordinates;
	BlockingQueue<Message> messages;
	
	public Player(BlockingQueue<Position> coordinates, BlockingQueue<Message> messages, String userName, boolean isMyTurn) {
		this.coordinates = coordinates;
		this.messages = messages;
		this.table = new Table();
		this.oponentTable = new Table();
		this.userName = userName;
		this.remainingBoats = 3;
		this.isMyTurn = isMyTurn;
		this.gameNotOver = true;
	} 

	@Override
	public void run() {
		while(this.gameNotOver) {	
			 try {
				play();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private synchronized void play() throws InterruptedException {
		int row; 
		int column;
		String rowToShow;
		Position position;
		boolean existPosition;
		
		if(isMyTurn) {	
			do {
				rowToShow = stringRandom();
				position = this.table.getPosition(rowToShow, intRandom());
				row = position.getRow();
				column = position.getColumn();			
				if(this.oponentTable.getMarkedPosition(row, column) != MARKED) { 
					existPosition = false;
				}else {
					existPosition = true;
				}
			}while(existPosition);
					System.out.println(new Date() + ": " + this.userName + " attack in " + rowToShow + " " + (column+1));
				coordinates.add(position);
				isMyTurn = false;
				sleep(1500);
		}else {
			if(!this.messages.isEmpty()) {
				if(this.messages.poll().equals(Message.LOSE)){
					this.gameNotOver = false;
						System.out.println(new Date() + ": " + this.userName + " won the game");
				}
			}
			if(this.gameNotOver) {
				while(this.coordinates.isEmpty()) {
				}
				response();
				isMyTurn = true;
				sleep(1000);
			}	
			
		}
	}
	
	public void response() {
		Position position = coordinates.poll();
		int row = position.getRow();
		int column = position.getColumn();

		if(this.table.getTable()[row][column] == BOAT) {
			this.remainingBoats -= 1;
			this.table.getTable()[row][column] = WATER;
			if(this.remainingBoats == 0) {
				this.messages.add(Message.LOSE);
				this.gameNotOver = false;
					System.out.println(new Date() + ": "+ this.userName + " say: i lose");
			}else {
				this.messages.add(Message.SUNKEN_BOAT);
					System.out.println(new Date() + ": "+ this.userName + " say: sunken boat");
			}
		}else {
			this.messages.add(Message.WATER);
			this.table.getTable()[row][column] = MARKED;
				System.out.println(new Date() + ": "+ this.userName + " say: water");
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
	
	public int getRemainingBoats() {
		return this.remainingBoats;
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
