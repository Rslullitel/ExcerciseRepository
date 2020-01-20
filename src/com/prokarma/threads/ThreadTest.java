package com.prokarma.threads;

public class ThreadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//extends Thread
		Proceso1 hilo1 = new Proceso1();
		
		//implements Runnable
		Thread hilo2 = new Thread(new Proceso2());
		
		hilo2.start();
		hilo1.start();
				
	
		
	}

}
