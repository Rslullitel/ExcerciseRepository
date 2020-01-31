package com.prokarma.ejercitacion.ej10;

import java.util.List;

public class Grafo {

	private List<Nodo> nodos;
	private int idLastArista;
		
	
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


	public int getIdLastArista() {
		return idLastArista;
	}


	public void setIdLastArista(int idLastArista) {
		this.idLastArista = idLastArista;
	}
	
	
	public void createArista(int idOrigen, int idDestino) {
		int i = 0;
		int j = 0;
		int idArista = this.idLastArista;
		
		while(idOrigen != this.nodos.get(i).getId() && i < this.nodos.size()) {
			i++;
		}
		if(i < this.nodos.size()) {
			while(idDestino != this.nodos.get(j).getId() && j < this.nodos.size()) {
				j++;
			}
		}
		if(i < this.nodos.size() || j < this.nodos.size()) {
			Arista arista = new Arista(idArista++, idOrigen);
			Arista arista1 = new Arista(idArista++, idDestino);
			this.idLastArista = idArista;
			Nodo nodo = this.nodos.get(i);
			Nodo nodo1 = this.nodos.get(j);
			nodo.addArista(arista1);
			nodo1.addArista(arista);
		}
	}

}
