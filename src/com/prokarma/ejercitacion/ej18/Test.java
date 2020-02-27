package com.prokarma.ejercitacion.ej18;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {

	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BlockingQueue<Integer> coordinates = new ArrayBlockingQueue<Integer>(1024);
		BlockingQueue<Message> message = new ArrayBlockingQueue<Message>(1024);
		
		Table blueTable = new Table("blue");
		Table redTable = new Table("red");
		Player playerBlue = new Player(coordinates, message, blueTable, "ramon", "blue"); //thread
		Player playerRed = new Player(coordinates, message, redTable, "mario", "red"); //thread
		
		String letter = null;
		int number = 0;
		
		startGame(letter, number, playerBlue, playerRed, blueTable, redTable);
		
			System.out.println("--- START GAME --- \nBlue turn...");		
			System.out.println("Indicate attack position, first letter");
		input.nextLine();	
		letter = input.nextLine();
			System.out.println("And number");
		number = input.nextInt();
		coordinates.add(blueTable.convert(letter));	
		coordinates.add(number);	
			
		playerRed.start();
		
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
				System.out.println(playerBlue.getUserName() + " put a boat in position: " + letter + " " + number);
		}
		for(int i = 0; i < 3; i++) {
			input.nextLine();
				System.out.println("Hi. Put the boat... Insert the letter");
			letter = input.nextLine();
				System.out.println("Insert the number");
			number = input.nextInt();
			playerRed.putBoats(letter, number);
				System.out.println(playerRed.getUserName() + " put a boat in position: " + letter + " " + number);
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
