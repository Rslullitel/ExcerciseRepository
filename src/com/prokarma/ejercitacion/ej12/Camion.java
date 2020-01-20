package com.prokarma.ejercitacion.ej12;

public class Camion extends Vehiculo{

	public static final int PAGO_PEAJE = 50;
	
	public Camion() {
		
	}

	public static int getPagoPeaje() {
		return PAGO_PEAJE;
	}

	@Override
	public String toString() {
		return "Camion";
	}
}
