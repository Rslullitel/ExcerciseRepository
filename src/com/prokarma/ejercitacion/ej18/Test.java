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
		
		startGame(playerBlue, playerRed, blueTable, redTable);
		
		
	}
	
	
	public static void startGame(Player playerBlue, Player playerRed, Table blueTable, Table redTable) {
		String letter;
		int number;
		
		for(int i = 0; i < 3; i++) {
			input.nextLine();
				System.out.println("Hi. Put the boat... Insert the letter");
			letter = input.nextLine();
				System.out.println("Insert the number");
			number = input.nextInt();
			playerBlue.putBoats(letter, number);
			System.out.println(playerBlue.getUserName() + " put a boat in position: " + letter + " " + number);//logguear
		}
		for(int i = 0; i < 3; i++) {
			input.nextLine();
				System.out.println("Hi. Put the boat... Insert the letter");
			letter = input.nextLine();
				System.out.println("Insert the number");
			number = input.nextInt();
			playerRed.putBoats(letter, number);
			System.out.println(playerBlue.getUserName() + " put a boat in position: " + letter + " " + number);
		}
		System.out.println(playerBlue.toString());
		blueTable.showTable();
		System.out.println("\n");
		System.out.println(playerRed.toString());
		redTable.showTable();
	}

}
