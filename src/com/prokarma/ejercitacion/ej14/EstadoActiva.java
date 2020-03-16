package com.prokarma.ejercitacion.ej14;

import com.prokarma.ejercitacion.ej14.exceptions.CuentaBloqueadaException;
import com.prokarma.ejercitacion.ej14.exceptions.SinSaldoException;

public class EstadoActiva extends Estado{
	
	
	public double retirarDinero(double saldo, double cantRetirar) throws SinSaldoException, CuentaBloqueadaException {
		double dineroRetirado = 0;
		
		if(cantRetirar <= saldo && cantRetirar != 0) {
			 dineroRetirado = saldo - cantRetirar; 
		}
	return dineroRetirado;	
	}

	
	public double depositarDinero(double saldo, double cantDeposit) throws CuentaBloqueadaException {
		return saldo += cantDeposit;
	}

	
	public String mostrarEstado() {
		return "Activa";
	}
	
}
