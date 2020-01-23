package com.prokarma.ejercitacion.ej10;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//WORK IN PROGRESS
		Map<Integer, Nodo> mapa = new HashMap<Integer, Nodo>();
		
		Nodo n1 = new Nodo(1);
		Nodo n2 = new Nodo(2);
		Nodo n3 = new Nodo(3);
		Nodo n4 = new Nodo(4);
		Nodo n5 = new Nodo(5);
		
		Arista a1 = new Arista(1, 2);
		Arista a2 = new Arista(2, 3);
		Arista a3 = new Arista(3, 3);
		Arista a4 = new Arista(4, 4);
		Arista a5 = new Arista(5, 4);
		Arista a6 = new Arista(6, 5);
		Arista a7 = new Arista(7, 5);
		
		n1.getAristas().add(a1);
		n1.getAristas().add(a2);
		n2.getAristas().add(a3);
		n2.getAristas().add(a4);
		n3.getAristas().add(a5);
		n3.getAristas().add(a6);
		n4.getAristas().add(a7);
	
		mapa.put(1, n1);
		mapa.put(2, n2);
		mapa.put(3, n3);
		mapa.put(4, n4);
		mapa.put(5, n5);
		
		
		for(Map.Entry<Integer, Nodo> variable : mapa.entrySet()) {
			
			Integer clave = variable.getKey();
			Nodo valor = variable.getValue();
			
			System.out.println("Clave: " + clave + ", Valor: " + valor);
			
		}
		
		
	}

}
