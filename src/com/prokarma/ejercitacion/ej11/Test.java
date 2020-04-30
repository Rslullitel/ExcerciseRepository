package com.prokarma.ejercitacion.ej11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

import com.prokarma.ejercitacion.ej19.Sandwich;

public class Test {

public static final String ABRE_PAR = "(";
public static final String CIERRA_PAR = ")";
public static final String MSG_OK = "Los simbolos se encuentran equilibrados";
public static final String MSG_ERR = "Los simbolos no se encuentran equilibrados";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Stack<String> pilaAbrePar = new Stack<String>();
		
		String cadena = "((5+5)*(5+5))";

		if(verificarSimbolos(cadena, pilaAbrePar)) {
			System.out.println(MSG_OK);
		}else {
			System.out.println(MSG_ERR);
		}
	
		System.out.println("queres que busque la comida?");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("chupame la verga");
		
	}
	
	public static boolean verificarSimbolos(String cadena, Stack<String> pilaAbrePar) {
		boolean cadenaCorrecta = false;
		int contParAbre = 0;
		int contParCierra = 0;
		int i = 0;
		int j = 1;
		
		for(; i < cadena.length() && j < cadena.length()+1; i++, j++) {
			String caracter = cadena.substring(i,j);
			if(caracter.equals(ABRE_PAR)) {
				pilaAbrePar.push(caracter);
				contParAbre++;
					System.out.println("La pila tiene: " + pilaAbrePar.toString());
			} else if(caracter.equals(CIERRA_PAR)) {
				if(!pilaAbrePar.isEmpty()) {
					pilaAbrePar.pop();
					contParCierra++;
						System.out.println("La pila tiene: " + pilaAbrePar.toString());
				} else {
					break;
				}
			}
		}
		System.out.println(contParAbre);
		System.out.println(contParCierra);
		if(i == cadena.length()) {
			if(pilaAbrePar.isEmpty()) {
				cadenaCorrecta = true;
			}
		}
		
		return cadenaCorrecta;	
	}

}
