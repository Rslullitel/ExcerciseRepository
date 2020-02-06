package com.prokarma.ejercitacion.ej12;

public class Camion extends Vehiculo{

	
	private int tarifa;
	
	public Camion() {
		this.tarifa = 100;
	}
	
	
	
	public int getTarifa() {
		return tarifa;
	}
	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}



	@Override
	public String toString() {
		return "Camion";
	}
}
