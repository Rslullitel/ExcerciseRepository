package com.prokarma.ejercitacion.ej14;

import com.prokarma.ejercitacion.ej14.exceptions.CuentaBloqueadaException;
import com.prokarma.ejercitacion.ej14.exceptions.SinSaldoException;

public class EstadoActiva implements Estado{
	
	@Override
	public double retirarDinero() throws SinSaldoException, CuentaBloqueadaException {
		return 0;
	}

	@Override
	public void depositarDinero() throws CuentaBloqueadaException {
	}

	@Override
	public String mostrarEstado() {
		return "Activa";
	}
	
}
