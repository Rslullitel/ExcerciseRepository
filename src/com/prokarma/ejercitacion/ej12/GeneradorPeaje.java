package com.prokarma.ejercitacion.ej12;

import java.util.concurrent.BlockingQueue;

public class GeneradorPeaje implements Runnable{

	protected BlockingQueue<Vehiculo> vehiculos;
	
	public GeneradorPeaje(BlockingQueue<Vehiculo> queue) {
		this.vehiculos = queue;
	}
	
	@Override 
	public void run() {
		Vehiculo vehiculo;
			
		while(!vehiculos.isEmpty()) {
			vehiculo = vehiculos.poll();
				System.out.println("");	
				System.out.println(vehiculo.toString() + " debe pagar: " + vehiculo.getTarifa());
			Test.gananciaTotal += vehiculo.getTarifa();		
			}
	}
	
}
