package com.prokarma.ejercitacion.ej12;

import java.util.LinkedList;
import java.util.Queue;


public class Peaje {

	private static Peaje peaje;
	private int gananciaTotal;
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



	public int getGananciaTotal() {
		return gananciaTotal;
	}
	public void setGananciaTotal(int gananciaTotal) {
		this.gananciaTotal = gananciaTotal;
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
	
	public int simularPeaje() {
		Vehiculo vehiculo;
		int gananciaTotal = 0;
		
		while(!this.vehiculos.isEmpty()) {
			vehiculo = this.vehiculos.remove();
				System.out.println("");
			if(vehiculo instanceof VehiculoEmergencia) {		
					System.out.println(vehiculo.toString());
					System.out.println("Debe pagar: " + 0);
				}else if(vehiculo instanceof Moto) {
						System.out.println(vehiculo.toString());
						System.out.println("Debe pagar: " + Moto.getPagoPeaje());
					gananciaTotal += Moto.getPagoPeaje();
				}else if(vehiculo instanceof Auto) {						
						System.out.println(vehiculo.toString());
						System.out.println("Debe pagar: " + ((Auto) vehiculo).getPagoPeaje());
					gananciaTotal += ((Auto) vehiculo).getPagoPeaje();
				}else if(vehiculo instanceof Camion) {
						System.out.println(vehiculo.toString());
						System.out.println("Debe pagar: " + Camion.getPagoPeaje());
					gananciaTotal += Camion.getPagoPeaje();
				}
			if(!this.vehiculos.isEmpty()) {
				break;
			}
		}
	return gananciaTotal;
	}
	
}
