package com.prokarma.ejercitacion.ej14;

import com.prokarma.ejercitacion.ej14.exceptions.CuentaBloqueadaException;
import com.prokarma.ejercitacion.ej14.exceptions.SinSaldoException;

public interface Estado {


	public double retirarDinero(double saldo, double cantRetirar) throws SinSaldoException, CuentaBloqueadaException;
	
	public double depositarDinero(double saldo, double cantIngresar) throws CuentaBloqueadaException;
	
	public String mostrarEstado();
}
