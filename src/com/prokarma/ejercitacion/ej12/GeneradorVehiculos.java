package com.prokarma.ejercitacion.ej12;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class GeneradorVehiculos extends Thread{
	
	protected BlockingQueue<Vehiculo> vehiculos;
	private Tuberia tuberia;
	int i;
	boolean repetir = true;
	
	public GeneradorVehiculos(BlockingQueue<Vehiculo> queue, Tuberia tuberia) {
		this.vehiculos = queue;
		this.tuberia = tuberia;
	}
	
	@Override 
	public void run() {
		while(repetir) {	 
			Random rand2 = new Random();
			 double n2 = rand2.nextDouble();
			 if (n2 >= 0.2){
					 Vehiculo vehNuevo = crearVehiculo(); 
					 if(vehNuevo instanceof VehiculoEmergencia) {
						 	System.out.println("\nHa ingresado un " + vehNuevo.toString() + "\nPor lo tanto se vaciara la cola de vehiculos");
						 this.vehiculos.add(vehNuevo);
						 tuberia.setEmergencia(true);
					 }else {
						 	System.out.println("\nHa ingresado un " + vehNuevo.toString());
						 this.vehiculos.add(vehNuevo);
					 }
			 }else {
			     System.out.println("no hay vehiculos !");
			 }
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	 
	}
	
	public Vehiculo crearVehiculo (){
	    Random rand1 = new Random();
	    Vehiculo vehiculo = null;
	    int n1 = rand1.nextInt(7);
	    switch (n1){
	        case 0 :
	            vehiculo = new Moto();
	            break;
	        case 1 :
	            vehiculo = new Auto(4);
	            break;
	        case 2:
	            vehiculo = new Ambulancia();
	            break;
	        case 3:
	        	vehiculo = new Policia();
	            break;
	        case 4 :
	            vehiculo = new Auto(2);
	            break;
	        case 5:
	            vehiculo = new Bombero();
	            break;
	        case 6:
	            vehiculo = new Camion();
	            break;
	    }
	    return vehiculo;
	}
	
	public void setRepetir(boolean repetir) {
		this.repetir = repetir;
	}

	
}
