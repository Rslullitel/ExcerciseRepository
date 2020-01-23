package com.prokarma.ejercitacion.ej11;

import java.util.Stack;

public class Test {

public static final String ABRE_PAR = "(";
public static final String CIERRA_PAR = ")";
public static final String MSG_OK = "Los simbolos se encuentran equilibrados";
public static final String MSG_ERR = "Los simbolos no se encuentran equilibrados";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<String> pilaAbrePar = new Stack<String>();
		
		String cadena = "((5+5)+(5+5))";

		if(verificarSimbolos(cadena, pilaAbrePar)) {
			System.out.println(MSG_OK);
		}else {
			System.out.println(MSG_ERR);
		}
		
	}
	
	public static boolean verificarSimbolos(String cadena, Stack<String> pilaAbrePar) {
		boolean cadenaCorrecta = false;
		int i = 0;
		int j = 1;
		
		for(; i < cadena.length() && j < cadena.length()+1; i++, j++) {
			String caracter = cadena.substring(i,j);
			if(caracter.equals(ABRE_PAR)) {
				pilaAbrePar.push(caracter);
					System.out.println("La pila tiene: " + pilaAbrePar.toString());
			} else if(caracter.equals(CIERRA_PAR)) {
				if(!pilaAbrePar.isEmpty()) {
					pilaAbrePar.pop();
						System.out.println("La pila tiene: " + pilaAbrePar.toString());
				} else {
					break;
				}
			}
		}
		
		if(i == cadena.length()) {
			if(pilaAbrePar.isEmpty()) {
				cadenaCorrecta = true;
			}
		}
		
		return cadenaCorrecta;	
	}

}
