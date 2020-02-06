package com.prokarma.ejercitacion.ej12;

public class Auto extends Vehiculo{

	private int cantPuertas;
	
	public Auto(int cantPuertas) {
		this.cantPuertas = cantPuertas;
		if(cantPuertas == 2) {
			this.tarifa = 20;
		}else if(cantPuertas == 4 ) {
			this.tarifa = 50;
		}
	}

	
	public int getCantPuertas() {
		return cantPuertas;
	}
	public void setCantPuertas(int cantPuertas) {
		this.cantPuertas = cantPuertas;
	}
	
	@Override
	public String toString() {
		return "Auto de " + this.cantPuertas + " puertas";
	}
}
