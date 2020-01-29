package com.prokarma.ejercitacion.ej12;

public abstract class VehiculoEmergencia extends Vehiculo{

	private static final int PAGO_PEAJE = 0;
	
	public VehiculoEmergencia() {
		
	}

	public static int getPagoPeaje() {
		return PAGO_PEAJE;
	}
	
	
	
}
