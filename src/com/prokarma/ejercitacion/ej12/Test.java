package com.prokarma.ejercitacion.ej12;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {

	static int gananciaTotal;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int minutos;
		int segundos;
		
		BlockingQueue<Vehiculo> queue = new ArrayBlockingQueue<Vehiculo>(1024);
		
		GeneradorVehiculos gv = new GeneradorVehiculos(queue);
		GeneradorPeaje gp = new GeneradorPeaje(queue);
		for(minutos = 0; minutos < 1; minutos++) {
			for(segundos = 0; segundos < 60; segundos++) {
				gv.run();
				gp.run();
				temporizador();
			}
		}
		System.out.println(queue);
		System.out.println("\nla ganacia total es: " + Test.gananciaTotal);
	}
	
	public static void temporizador() {
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
		}
	}

}
