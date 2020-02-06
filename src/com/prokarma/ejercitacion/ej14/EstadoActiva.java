package com.prokarma.ejercitacion.ej14;

import com.prokarma.ejercitacion.ej14.exceptions.CuentaBloqueadaException;
import com.prokarma.ejercitacion.ej14.exceptions.SinSaldoException;

public class EstadoActiva implements Estado{
	
	@Override
	public double retirarDinero(double saldo, double cantRetirar) throws SinSaldoException, CuentaBloqueadaException {
		double dineroRetirado = 0;
		
		if(cantRetirar <= saldo && cantRetirar != 0) {
			 dineroRetirado = saldo - cantRetirar; 
		}
	return dineroRetirado;	
	}

	@Override
	public double depositarDinero(double saldo, double cantDeposit) throws CuentaBloqueadaException {
		return saldo += cantDeposit;
	}

	@Override
	public String mostrarEstado() {
		return "Activa";
	}
	
}
