package com.prokarma.ejercitacion.ej12;

import java.util.concurrent.BlockingQueue;

public class GeneradorPeaje extends Thread{

	protected BlockingQueue<Vehiculo> vehiculos;
	private Tuberia tuberia;
	int i;
	boolean repetir = true;
	
	public GeneradorPeaje(BlockingQueue<Vehiculo> queue, Tuberia tuberia) {
		this.vehiculos = queue;
		this.tuberia = tuberia;
	}
	
	@Override 
	public void run() {
		while(repetir) {	
			Vehiculo vehiculo;
			if(!tuberia.getEmergencia()) {
				vehiculo = vehiculos.poll();
				if(vehiculo != null) {
					System.out.println("\n" + vehiculo.toString() + " debe pagar: " + vehiculo.getTarifa());
				Test.gananciaTotal += vehiculo.getTarifa();
				}
			}else {
					System.out.println("Se abre la barrera para dejar pasar al vehiculo de emergencia");
				vaciar();
				tuberia.setEmergencia(false);
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	private void vaciar() {	
		System.out.println("---");
		while(this.vehiculos.peek().getId() != -1) {	
			System.out.println(this.vehiculos.poll());
		}
		System.out.println("---");
		this.vehiculos.poll();
	}
	
	public void setRepetir(boolean repetir) {
		this.repetir = repetir;
	}
	
}
