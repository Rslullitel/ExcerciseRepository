package com.prokarma.ejercitacion.ej14;

import com.prokarma.ejercitacion.ej14.exceptions.CuentaBloqueadaException;
import com.prokarma.ejercitacion.ej14.exceptions.SinSaldoException;

public class CuentaBancaria implements OperacionesBancarias{
	
	private double saldo;
	private Estado estado;
	private double cantIntentos;
	private int codigo;
	
	public CuentaBancaria(double saldo, int codigo) {
		this.saldo = saldo;
		this.codigo = codigo;
		this.estado = new EstadoActiva();
	}
	
	
	public double retirarDinero(double cantRetirar) throws SinSaldoException, CuentaBloqueadaException {
		double dineroRetirado = 0;
		
		if(cantIntentos != MAX_TRY) {
			if(this.estado instanceof EstadoActiva) {
				if(cantRetirar <= this.saldo && cantRetirar != 0) {
					this.saldo -= cantRetirar;
					dineroRetirado = cantRetirar;
				}else if(this.saldo == 0) {
					this.sinSaldo();
				}else {
					cantIntentos++;
						System.out.println(MSG_ERR_3);
				}
			}else if(this.estado instanceof EstadoBloqueada) {
				this.estado.retirarDinero();
			}	
		}else {
			this.bloquear();
			cantIntentos = 0;
		}
		return dineroRetirado;
	}
	
	public void depositarDinero(double cantDeposit) throws CuentaBloqueadaException{
		
		if(this.estado instanceof EstadoBloqueada) {
			estado.depositarDinero();
		}else {
			this.saldo += cantDeposit;
			this.mostrarEstado();
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
	
	@Override
	public void activar() {
		this.estado = new EstadoActiva();
	}

	@Override
	public void sinSaldo() {
		this.estado = new EstadoSinSaldo();
	}

	@Override
	public void bloquear() {
		this.estado = new EstadoBloqueada();
	}
	

	
	public double getCantIntentos() {
		return cantIntentos;
	}
	public void setCantIntentos(double cantIntentos) {
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
		return "Estado de la Cuenta: " + this.estado.mostrarEstado() + 
			   " Saldo: " + this.saldo;
	}
	
}
