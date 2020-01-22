package com.prokarma.ejercitacion.ej10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//WORK IN PROGRESS
		
		Grafo grafo = new Grafo();
		Map<Nodo, Arista> mapa = new HashMap<Nodo, Arista>();
		
		Nodo n1 = new Nodo(1);
		Nodo n2 = new Nodo(2);
		Nodo n3 = new Nodo(3);
		Nodo n4 = new Nodo(4);
		Nodo n5 = new Nodo(5);
		
		Arista a1 = new Arista(1, 2);
		Arista a2 = new Arista(1, 3);
		Arista a3 = new Arista(2, 3);
		Arista a4 = new Arista(2, 4);
		Arista a5 = new Arista(3, 4);
		Arista a6 = new Arista(3, 5);
		Arista a7 = new Arista(4, 5);
		
		n1.getAristas().add(a1);
		n1.getAristas().add(a2);
		n2.getAristas().add(a3);
		n2.getAristas().add(a4);
		n3.getAristas().add(a5);
		n3.getAristas().add(a6);
		n4.getAristas().add(a7);
	
		Iterator it = mapa.keySet().iterator();
		while(it.hasNext()){
		  Integer key = (Integer) it.next();
		  System.out.println("Nodo: " + key + " -> Arista: " + mapa.get(key));
		}
		
		
	}

}
