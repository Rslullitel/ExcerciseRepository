package com.prokarma.ejercitacion.ej12;

public class Moto extends Vehiculo{

	private static final int PAGO_PEAJE = 10;

	
	public Moto() {
		
	}

	
	public static int getPagoPeaje() {
		return PAGO_PEAJE;
	}
	
	@Override
	public String toString() {
		return "Moto";
	}
	
}
