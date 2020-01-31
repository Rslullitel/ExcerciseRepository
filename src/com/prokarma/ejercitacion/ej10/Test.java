package com.prokarma.ejercitacion.ej10;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//WORK IN PROGRESS
		Grafo g = new Grafo(new ArrayList<Nodo>());
		
		Nodo n1 = new Nodo(1);
		Nodo n2 = new Nodo(2);
		Nodo n3 = new Nodo(3);
		Nodo n4 = new Nodo(4);
		Nodo n5 = new Nodo(5);
		
		g.addNodo(n1);
		g.addNodo(n2);
		g.addNodo(n3);
		g.addNodo(n4);
		g.addNodo(n5);
		
		g.createArista(n1.getId(), n3.getId());
		g.createArista(n1.getId(), n2.getId());
		g.createArista(n2.getId(), n3.getId());
		g.createArista(n3.getId(), n4.getId());
		g.createArista(n4.getId(), n5.getId());
		
		for(Nodo n : g.getNodos()) {
			System.out.println(n.toString());
		}
	}

}


/*	
	mapa.put(1, n1);
	mapa.put(2, n2);
	mapa.put(3, n3);
	mapa.put(4, n4);
	mapa.put(5, n5);
	
	
	for(Map.Entry<Integer, Nodo> variable : mapa.entrySet()) {
		
		Integer clave = variable.getKey();
		Nodo valor = variable.getValue();
		
		System.out.println("Clave: " + clave + ", Valor: " + valor);
		
	}	*/
		
