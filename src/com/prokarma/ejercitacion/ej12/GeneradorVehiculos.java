package com.prokarma.ejercitacion.ej12;

import java.util.Random;

public class GeneradorVehiculos extends Thread{
	
	private Peaje peaje = Peaje.getSingletonInstance();
	
	@Override 
	public void run() {
		 Random rand2 = new Random();
		 double n2 = rand2.nextDouble();
		 if (n2 >= 0.2){
			 Vehiculo vehNuevo = crearVehiculo();
			 if(vehNuevo instanceof VehiculoEmergencia) {
				 	System.out.println("\nHa ingresado un " + vehNuevo.toString() + "\nPor lo tanto se vaciara la cola de vehiculos");
				 peaje.generarColaVehiculos(vehNuevo);
				 System.out.println(peaje.getVehiculos());
				 vaciar(vehNuevo);
			 }else {
		     peaje.generarColaVehiculos(vehNuevo);
			 }
		 }else {
		     System.out.println("no hay vehiculos !");
		 }
	}
	
	public Vehiculo crearVehiculo (){
	    Random rand1 = new Random();
	    Vehiculo vehiculo = null;
	    int n1 = rand1.nextInt(7);
	    switch (n1){
	        case 0 :
	            vehiculo = new Ambulancia();
	            break;
	        case 1 :
	            vehiculo = new Bombero();
	            break;
	        case 2:
	            vehiculo = new Policia();
	            break;
	        case 3:
	            vehiculo = new Moto();
	            break;
	        case 4 :
	            vehiculo = new Auto(2);
	            break;
	        case 5:
	            vehiculo = new Auto(4);
	            break;
	        case 6:
	            vehiculo = new Camion();
	            break;
	    }
	    return vehiculo;
	}
	
	private void vaciar(Vehiculo vehiculo) {	
		while(peaje.getVehiculos().peek().getId() != -1) {
			peaje.getVehiculos().poll();
		}
		peaje.getVehiculos().poll();
	}

	
}
