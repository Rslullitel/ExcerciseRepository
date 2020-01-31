package com.prokarma.ejercitacion.ej14;

import java.util.Scanner;

import com.prokarma.ejercitacion.ej14.exceptions.CuentaBloqueadaException;
import com.prokarma.ejercitacion.ej14.exceptions.SinSaldoException;

public class Test {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean masDeposito = false;
		boolean masRetiro = false;
		boolean otraOperacion = false; 
		char opcion2;
		char opcion3;
		char opcion4;
		char opcion5;
		int codigo = 0;
		CuentaBancaria miCuenta = new CuentaBancaria(100, 1234);
		
		do {
				input.nextLine();
				System.out.println("¿Desea retirar o depositar dinero?");
			String opcion = input.nextLine();	
			switch(opcion) {
			
			case "retirar":
				do {
					input.nextLine();
					System.out.println("¿Cuanto dinero desea retirar?");
				double cantRetirar = input.nextInt();
						try {
							miCuenta.retirarDinero(cantRetirar);
						} catch (SinSaldoException e) {
									System.out.println("Cuenta sin saldo, intente ingresar el monto a retirar nuevamente");
						} catch(CuentaBloqueadaException e){
									System.out.println("Cuenta Bloquiada. ¿Desea desbloquearla? (s/n)");
								opcion2 = input.next().charAt(0);	
								switch(opcion2) {
								
								case 's':
										System.out.println("Ingrese codigo de desbloqueo");
									codigo = input.nextInt();	
									if(miCuenta.desbloquear(codigo)) {
										System.out.println("Cuenta Desbloqueada y activada con exito");
									}else {
										System.out.println("Codigo incorrecto, vuelva a intentarlo mas tarde");
										System.exit(codigo);
									}
								case 'n':
									break;
								}
						}finally {
							System.out.println(miCuenta.mostrarEstado());
						}
					System.out.println("¿Desea retirar mas dinero?");
					opcion5 = input.next().charAt(0);
					if(opcion5 == 's') {
						masRetiro = true;
					}else {
						masRetiro = false;
					}
				}while(masRetiro);	
				break;
			
			case "depositar":
				do {	
						System.out.println("¿Cuanto dinero desea depositar?");
					double cantDepositar = input.nextInt();
						try {
							miCuenta.depositarDinero(cantDepositar);
						} catch (CuentaBloqueadaException e) {
								System.out.println("Su cuenta se encuentra bloquiada, activela y luego deposite el dinero");
						}finally {
								System.out.println(miCuenta.mostrarEstado());
								
						}
						System.out.println("¿Desea depositar mas dinero?");
						opcion3 = input.next().charAt(0);
						if(opcion3 == 's') {
							masDeposito = true;
						}else {
							masDeposito = false;
						}
				}while(masDeposito);
				break;
			}
				input.nextLine();
				System.out.println("¿Desea realizar otra operacion?");
			opcion4 = input.next().charAt(0);
			if(opcion4 == 's') {
				otraOperacion = true;
			}else {
				otraOperacion = false;
			}
		}while(otraOperacion);	
		System.out.println("Su estado final de cuenta es: " + miCuenta.mostrarEstado());
	}

}
