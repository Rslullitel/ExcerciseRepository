package com.prokarma.ejercitacion.ej12;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int minutos;
		int segundos;
		int segun2;
		
		Peaje peaje = Peaje.getSingletonInstance();
		GeneradorVehiculos gv = new GeneradorVehiculos();
		GeneradorPeaje gp = new GeneradorPeaje();
		for(minutos = 0; minutos < 1; minutos++) {
			for(segundos = 0; segundos < 60; segundos++) {
				for(segun2 = 0; segun2 < 2; segun2++) {
					gv.run();
				}
				gp.run();
				temporizador();
			}
		}
		System.out.println("\nla ganacia total es: " + peaje.getGananciaTotal());
	}
	
	public static void temporizador() {
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
		}
	}

}
