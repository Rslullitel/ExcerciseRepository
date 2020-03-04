package com.prokarma.ejercitacion.ej18;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static final int BOATS = 6;
	public static final int PLAYER_BOATS = 3;
	public static final String REGEX = "[a-h]";
	
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BlockingQueue<Position> coordinates = new ArrayBlockingQueue<Position>(1);
		BlockingQueue<Message> messages = new ArrayBlockingQueue<Message>(1);
		
		Player playerBlue = new Player(coordinates, messages, "ramiro", true); 
		Player playerRed = new Player(coordinates, messages, "ahmad", false);
		
		startGame(playerBlue, playerRed);
		
		playerBlue.start();
		playerRed.start();

	}
	
	private static void startGame(Player playerBlue, Player playerRed) {
		String letter;
		int number;
		
		for(int i = 0; i < BOATS; i++) {	
				letter = askLetter();
				number = askNumber();
				if(i < (BOATS - PLAYER_BOATS)) {
					playerBlue.putBoats(letter, number);
						System.out.println(new Date() + ": " + playerBlue.getUserName() + " put a boat in position: " + letter + " " + number);
				}else {
					playerRed.putBoats(letter, number);
						System.out.println(new Date() + ": " + playerRed.getUserName() + " put a boat in position: " + letter + " " + number);
			}
		}
	}
	
	private static String askLetter() {
		String letter;
		
		input.nextLine();
		do {
				System.out.println("Hi. Put the boat... Insert the letter. (a - h)");
			letter = input.nextLine();
		}while(!rigthLetter(letter));
	return letter;		
	}
	
	private static int askNumber() {
		int number;	
		
		do {
				System.out.println("Insert the number. (1 - 8)");
			number = input.nextInt();
		}while(number < 1 || number > 8);
	return number;	
	}
	
	private static boolean rigthLetter(String letter) {
		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(letter);
		if(!matcher.find()) {
			return false;
		}else {
			return true;
		}
	}
}
