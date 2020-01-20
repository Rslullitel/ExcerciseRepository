package com.prokarma.ejercitacion.ej12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Peaje {

	private int gananciaTotal;
	private Queue<Vehiculo> vehiculos;
	
	
	public Peaje() {
		this.vehiculos = new LinkedList<Vehiculo>();
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
	
	public void generarColaVehiculos(ArrayList<Vehiculo> l_vehiculos){
		for(Vehiculo v : l_vehiculos) {
			this.vehiculos.add(v);
		}
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
		}
	return gananciaTotal;
	}
	
}
