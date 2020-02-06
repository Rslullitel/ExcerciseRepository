package com.prokarma.ejercitacion.ej14;

import com.prokarma.ejercitacion.ej14.exceptions.CuentaBloqueadaException;
import com.prokarma.ejercitacion.ej14.exceptions.SinSaldoException;

public class CuentaBancaria{
	
	private double saldo;
	private Estado estado;
	private int cantIntentos;
	private int codigo;
	
	public CuentaBancaria(double saldo, int codigo) {
		this.saldo = saldo;
		this.codigo = codigo;
		this.estado = new EstadoActiva();
	}
	
	public void retirarDinero(double cantRetirar) throws SinSaldoException, CuentaBloqueadaException {
		
		if(cantIntentos != 3) {
			if(cantRetirar <= this.saldo && cantRetirar != 0) {
				this.saldo = this.estado.retirarDinero(this.saldo, cantRetirar);
			}else if(this.saldo == 0) {
				this.sinSaldo();
			}else {
				this.cantIntentos++;
			}
		}else {
			this.bloquear();
			cantIntentos = 0;
		}
	}
	
	public void depositarDinero(double cantDeposit) throws CuentaBloqueadaException {
		if(this.estado instanceof EstadoBloqueada) {
			throw new CuentaBloqueadaException("Su cuenta se encuentra bloqueada");
		}else if(this.estado instanceof EstadoSinSaldo) {
			this.activar();
			this.saldo += cantDeposit;
		}else {
			this.saldo += cantDeposit;
		}
	}
	
	public boolean desbloquear(int codigo) {
		if(codigo == this.codigo) {
			this.activar();
			return true;
		}else {
			return false;
		}
		
	}

	public void activar() {
		this.estado = new EstadoActiva();
	}

	public void sinSaldo() throws SinSaldoException{
		this.estado = new EstadoSinSaldo();
		throw new SinSaldoException("Su cuenta se ha quedado sin saldo");
	}

	public void bloquear() throws CuentaBloqueadaException{
		this.estado = new EstadoBloqueada();
		throw new CuentaBloqueadaException("Su cuenta ha sido bloqueada");
	}
	

	
	public double getCantIntentos() {
		return cantIntentos;
	}
	public void setCantIntentos(int cantIntentos) {
		this.cantIntentos = cantIntentos;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	
	public String mostrarEstado() {
		return "Cuenta: " + this.estado.mostrarEstado() + 
			   " Saldo: " + this.saldo;
	}
	
}
