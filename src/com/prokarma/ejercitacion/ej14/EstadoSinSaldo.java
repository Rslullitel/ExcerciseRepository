package com.prokarma.ejercitacion.ej14;

import com.prokarma.ejercitacion.ej14.exceptions.CuentaBloqueadaException;
import com.prokarma.ejercitacion.ej14.exceptions.SinSaldoException;

public class EstadoSinSaldo implements Estado{


	@Override
	public double retirarDinero() throws SinSaldoException, CuentaBloqueadaException {
		throw new SinSaldoException("Su cuenta no tiene saldo");
	}

	@Override
	public void depositarDinero() throws CuentaBloqueadaException {
	}

	@Override
	public String mostrarEstado() {
		return "Sin Saldo";
	}
	
}
