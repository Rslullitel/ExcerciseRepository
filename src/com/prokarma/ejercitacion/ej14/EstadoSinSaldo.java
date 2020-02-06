package com.prokarma.ejercitacion.ej14;

import com.prokarma.ejercitacion.ej14.exceptions.CuentaBloqueadaException;
import com.prokarma.ejercitacion.ej14.exceptions.SinSaldoException;

public class EstadoSinSaldo implements Estado{


	@Override
	public double retirarDinero(double saldo, double cant) throws SinSaldoException, CuentaBloqueadaException {
		throw new SinSaldoException("Su cuenta no tiene saldo");
	}

	@Override
	public double depositarDinero(double saldo, double cantDeposit) throws CuentaBloqueadaException {
		return saldo += cantDeposit;
	}

	@Override
	public String mostrarEstado() {
		return "Sin Saldo";
	}
	
}
