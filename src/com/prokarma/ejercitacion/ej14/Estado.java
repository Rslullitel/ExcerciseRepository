package com.prokarma.ejercitacion.ej14;

import com.prokarma.ejercitacion.ej14.exceptions.CuentaBloqueadaException;
import com.prokarma.ejercitacion.ej14.exceptions.SinSaldoException;

public abstract class Estado {

	
	
	public abstract double retirarDinero(double saldo, double cantRetirar) throws SinSaldoException, CuentaBloqueadaException;
	
	public abstract double depositarDinero(double saldo, double cantIngresar) throws CuentaBloqueadaException;
	
	public abstract String mostrarEstado();
}
