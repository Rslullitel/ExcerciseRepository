package com.prokarma.ejercitacion.ej12;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int minutos;
		int segundos;
		
		GeneradorVehiculos gv = new GeneradorVehiculos();
		GeneradorPeaje gp = new GeneradorPeaje();
		for(minutos = 0; minutos < 5; minutos++) {
			for(segundos = 0; segundos < 60; segundos++) {
				gv.run();
				gp.run();
				temporizador();
			}
		}
		System.out.println("\nla ganacia total es: " + Peaje.getGananciaTotal());
	}
	
	public static void temporizador() {
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			
		}
	}

}
