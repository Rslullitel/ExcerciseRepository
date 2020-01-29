package com.prokarma.ejercitacion.ej14;

import com.prokarma.ejercitacion.ej14.exceptions.CuentaBloqueadaException;
import com.prokarma.ejercitacion.ej14.exceptions.SinSaldoException;

public interface OperacionesBancarias {

	public static final int MAX_TRY = 3;
	
	public static final String MSG_ERR_3 = "No tiene suficiente saldo en la cuenta";
	public static final String MSG_ERR_2 = "Su cuenta esta bloqueada, intente activarla y luego retirar dinero";
	public static final String MSG_ERR_1 = "Su cuenta se a quedado sin saldo";
	
	
	public double retirarDinero(double cantRetirar) throws SinSaldoException, CuentaBloqueadaException;
	
	public void depositarDinero(double cantDeposit) throws CuentaBloqueadaException;
	
	public void desbloquear();
	
	public abstract void activar();
	
	public abstract void sinSaldo();
	
	public abstract void bloquear();
	
}
