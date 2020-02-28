package com.prokarma.ejercitacion.ej18;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {

	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BlockingQueue<Position> coordinates = new ArrayBlockingQueue<Position>(1);
		BlockingQueue<Message> messages = new ArrayBlockingQueue<Message>(1);
		
		Table blueTable = new Table();
		Table redTable = new Table();
		Player playerBlue = new Player(coordinates, messages, blueTable, "ramon", true); 
		Player playerRed = new Player(coordinates, messages, redTable, "mario", false);
		
		String letter = null;
		int number = 0;	
		startGame(letter, number, playerBlue, playerRed, blueTable, redTable);

		playerBlue.run();
		playerRed.run();	
		
		showTables(playerBlue, playerRed, blueTable, redTable);
	}
	
	
	public static void startGame(String letter, int number, Player playerBlue, Player playerRed, Table blueTable, Table redTable) {
		
		
		for(int i = 0; i < 3; i++) {
			input.nextLine();
				System.out.println("Hi. Put the boat... Insert the letter");
			letter = input.nextLine();
				System.out.println("Insert the number");
			number = input.nextInt();
			playerBlue.putBoats(letter, number);
				System.out.println(new Date() + ": " + playerBlue.getUserName() + " put a boat in position: " + letter + " " + number);
		}
		for(int i = 0; i < 3; i++) {
			input.nextLine();
				System.out.println("Hi. Put the boat... Insert the letter");
			letter = input.nextLine();
				System.out.println("Insert the number");
			number = input.nextInt();
			playerRed.putBoats(letter, number);
				System.out.println(new Date() + ": " + playerRed.getUserName() + " put a boat in position: " + letter + " " + number);
		}
	}
	
	public static void showTables(Player playerBlue, Player playerRed, Table blueTable, Table redTable) {
		System.out.println(playerBlue.toString());
		blueTable.showTable();
		System.out.println("\n");
		System.out.println(playerRed.toString());
		redTable.showTable();
	}

}
