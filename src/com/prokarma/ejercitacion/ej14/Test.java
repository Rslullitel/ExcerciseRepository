package com.prokarma.ejercitacion.ej14;

import java.util.Scanner;

import com.prokarma.ejercitacion.ej14.exceptions.CuentaBloqueadaException;
import com.prokarma.ejercitacion.ej14.exceptions.SinSaldoException;

public class Test {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean hayExcepcion = false;
		
		CuentaBancaria miCuenta = new CuentaBancaria(10000);
		
			System.out.println("¿Desea retirar o depositar dinero?");
		String opcion = input.nextLine();	
		switch(opcion) {
		
		case "retirar":
			do {
				System.out.println("¿Cuanto dinero desea retirar?");
			double cantRetirar = input.nextInt();
				try {
					miCuenta.retirarDinero(cantRetirar);
				} catch (SinSaldoException | CuentaBloqueadaException e) {
					hayExcepcion = true;
						System.out.println("Intente ingresar el monto a retirar nuevamente");
				}finally {
					System.out.println(miCuenta.toString());
				}
			}while(hayExcepcion == true);
			break;
		
		case "depositar":
				System.out.println("¿Cuanto dinero desea depositar?");
			double cantDepositar = input.nextInt();
				try {
					miCuenta.depositarDinero(cantDepositar);
				} catch (CuentaBloqueadaException e) {
					hayExcepcion = true;
						System.out.println("Su cuenta se encuentra bloquiada, activela y luego deposite el dinero");
				}finally {
					System.out.println(miCuenta.mostrarSaldo());
				}
			break;
		}
	}

}
