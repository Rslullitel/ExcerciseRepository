package com.prokarma.ejercitacion.ej10;

import java.util.List;

public class Grafo {

	private List<Nodo> nodos;
		
	
	public Grafo(List<Nodo> nodos) {
		this.nodos = nodos;
	}


	public List<Nodo> getNodos() {
		return nodos;
	}
	public void setNodos(List<Nodo> nodos) {
		this.nodos = nodos;
	}
	
	public void addNodo(Nodo nodo) {
		this.nodos.add(nodo);
	}

}
