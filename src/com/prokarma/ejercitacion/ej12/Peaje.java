package com.prokarma.ejercitacion.ej12;

import java.util.LinkedList;
import java.util.Queue;


public class Peaje {

	private static Peaje peaje;
	private static int gananciaTotal;
	private Queue<Vehiculo> vehiculos;
	
	
	private Peaje() {
		this.vehiculos = new LinkedList<Vehiculo>();
	}
	
	public static Peaje getSingletonInstance() {
		if(peaje == null) {
			peaje = new Peaje();
		}else {
				System.out.println("No se pueden crear dos instancias del mismo objeto");
		}
		return peaje;
	}


	public static int getGananciaTotal() {
		return gananciaTotal;
	}
	public static void setGananciaTotal(int gananciaTotal) {
		Peaje.gananciaTotal = gananciaTotal;
	}
	public Queue<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(Queue<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
	
	public void generarColaVehiculos(Vehiculo vehiculo){
			this.vehiculos.add(vehiculo);
	}
	
	public void simularPeaje() {
		Vehiculo vehiculo;
		
		while(!this.vehiculos.isEmpty()) {
			vehiculo = this.vehiculos.remove();
			if(vehiculo instanceof VehiculoEmergencia) {
					System.out.println("\nHa ingresado un " + vehiculo.toString() + "\nPor lo tanto se vaciara la cola de vehiculos");
				vaciar();
			}else {
				System.out.println("");	
					System.out.println(vehiculo.toString());
					System.out.println("Debe pagar: " + vehiculo.getTarifa());
					gananciaTotal += vehiculo.getTarifa();
			}		
				if(!this.vehiculos.isEmpty()) {
					break;
				}	
		}
	}

	private void vaciar() {	
		while(!this.vehiculos.isEmpty()) {
			vehiculos.poll();
		}
	}
	
}
	
