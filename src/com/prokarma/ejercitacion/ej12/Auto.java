package com.prokarma.ejercitacion.ej12;

public class Auto extends Vehiculo{

	private int pagoPeaje;
	private int cantPuertas;
	
	public Auto(int cantPuertas) {
		this.cantPuertas = cantPuertas;
		if(cantPuertas == 2) {
			this.pagoPeaje = 20;
		}else if(cantPuertas == 4 ) {
			this.pagoPeaje = 50;
		}
	}

	public int getPagoPeaje() {
		return pagoPeaje;
	}
	public void setPagoPeaje(int pagoPeaje) {
		this.pagoPeaje = pagoPeaje;
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
