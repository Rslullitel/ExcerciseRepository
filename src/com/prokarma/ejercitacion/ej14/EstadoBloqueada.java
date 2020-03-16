package com.prokarma.ejercitacion.ej14;

import com.prokarma.ejercitacion.ej14.exceptions.CuentaBloqueadaException;
import com.prokarma.ejercitacion.ej14.exceptions.SinSaldoException;

public class EstadoBloqueada extends Estado{


	@Override
	public double retirarDinero(double saldo, double cant) throws SinSaldoException, CuentaBloqueadaException {
		throw new CuentaBloqueadaException("Su cuenta se encuentra bloqueada, activela para retirar dinero");
	}

	@Override
	public double depositarDinero(double saldo, double cant) throws CuentaBloqueadaException {
		throw new CuentaBloqueadaException("Su cuenta se encuentra bloqueada, activela para depositar dinero");	
	}

	@Override
	public String mostrarEstado() {
		return "Bloqueada";
	}
	
}
