package com.prokarma.ejercitacion.ej12;

import java.util.Timer;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GeneradorVehiculos gv = new GeneradorVehiculos();
		GeneradorPeaje gp = new GeneradorPeaje();
		Timer timer = new Timer();
		CountTimer tiempo = new CountTimer();
		timer.schedule(tiempo, 0, 1000);
		gv.start();
		gp.start();
		
		  //while(time < 5 min){
		 	if(numRandom() > 8){
		 		//vehiculo emergencia
		 	}else if(numRandom() > 6){
		 		//llego un camion
		 	}else if(numRandom() > 3) {
		 		//llego una moto 
		 	}else if(numRandom() > 0) {
		 		//llego un auto
		 	}

	}
	
	public static int numRandom() {
		int numero = (int)(Math.random()*10+1);
		return numero;
	}

}
