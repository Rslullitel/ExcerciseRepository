package com.prokarma.ejercitacion.ej12;

public class Tuberia {

	private boolean hayEmergencia;
	
	public synchronized void setEmergencia(boolean emer) {
		this.hayEmergencia = emer;
	}
	
	public boolean getEmergencia() {
		return this.hayEmergencia;
	}

	
}
