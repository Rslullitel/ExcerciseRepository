package com.prokarma.ejercitacion.ej14;

import com.prokarma.ejercitacion.ej14.exceptions.CuentaBloqueadaException;
import com.prokarma.ejercitacion.ej14.exceptions.SinSaldoException;

public interface Estado {


	public double retirarDinero() throws SinSaldoException, CuentaBloqueadaException;
	
	public void depositarDinero() throws CuentaBloqueadaException;
	
	public String mostrarEstado();
}
