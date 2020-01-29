package com.prokarma.ejercitacion.ej14;

import com.prokarma.ejercitacion.ej14.exceptions.CuentaBloqueadaException;
import com.prokarma.ejercitacion.ej14.exceptions.SinSaldoException;

public class CuentaBancaria implements OperacionesBancarias{
	
	private double saldo;
	private Estado estado;
	private double cantIntentos;
	
	public CuentaBancaria(double saldo) {
		this.saldo = saldo;
		if(saldo > 0) {
			this.estado = Estado.ACTIVA;
		}else {
			this.estado = Estado.SIN_SALDO;
		}
	}
	
	
	public double retirarDinero(double cantRetirar) throws SinSaldoException, CuentaBloqueadaException {
		double dineroRetirado = 0;
		
		if(cantIntentos != MAX_TRY) {
			if(this.estado.equals(Estado.ACTIVA)) {
				if(cantRetirar <= this.saldo && cantRetirar != 0) {
					this.saldo -= cantRetirar;
					dineroRetirado = cantRetirar;
				}else if(this.saldo == 0) {
					this.sinSaldo();
						throw new SinSaldoException(MSG_ERR_1);
				}else {
					cantIntentos++;
						System.out.println(MSG_ERR_3);
				}
			}else if(this.estado.equals(Estado.BLOQUEADA)) {
				throw new CuentaBloqueadaException(MSG_ERR_2);
			}
		}else {
			this.bloquear();
			cantIntentos = 0;
		}
		return dineroRetirado;
	}
	
	public void depositarDinero(double cantDeposit) throws CuentaBloqueadaException{
		
		if(this.estado.equals(Estado.BLOQUEADA)) {
			throw new CuentaBloqueadaException(MSG_ERR_2);
		}else {
			this.saldo += cantDeposit;
		}
		this.mostrarSaldo();
	}
	
	public void desbloquear() {
		this.activar();
	}
	
	@Override
	public void activar() {
		this.estado = Estado.ACTIVA;
	}

	@Override
	public void sinSaldo() {
		this.estado = Estado.SIN_SALDO;
	}

	@Override
	public void bloquear() {
		this.estado = Estado.BLOQUEADA;

	}
	

	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	public String mostrarSaldo() {
		return "Estado de cuenta: " + this.estado + 
			   ", Saldo de la cuenta: " + this.saldo;
	}
	
}
