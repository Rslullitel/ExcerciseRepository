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
		int idArista = this.idLastArista;
		
		while(idDestino != this.nodos.get(i).getId() && i < this.nodos.size()) {
			i++;
		}
		if(i < this.nodos.size()) {
			Nodo nodo = this.nodos.get(i);
			Arista arista = new Arista(idArista++, nodo.getId(), idOrigen);
			this.idLastArista = idArista;
			this.nodos.get(idOrigen).addArista(arista);
		}
				System.out.println(this.nodos.get(idOrigen).toString());
	}


}
