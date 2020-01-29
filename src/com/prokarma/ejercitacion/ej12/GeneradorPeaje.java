package com.prokarma.ejercitacion.ej12;

public class GeneradorPeaje extends Thread{

	Peaje peaje = Peaje.getSingletonInstance();
	
	@Override 
	public void run() {
		peaje.simularPeaje();
	}
	
}
