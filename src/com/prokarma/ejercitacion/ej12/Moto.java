package com.prokarma.ejercitacion.ej12;

public class Moto extends Vehiculo{
	
	public Moto() {
		this.tarifa = 10;
	}

	
	public int getTarifa() {
		return tarifa;
	}
	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}


	@Override
	public String toString() {
		return "Moto";
	}
	
}
