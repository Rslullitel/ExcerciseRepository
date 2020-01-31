package com.prokarma.ejercitacion.ej10;

import java.util.HashSet;
import java.util.Set;

public class Nodo {

	private int id;
	private Set<Arista> aristas;
	
	public Nodo(int id) {
		this.id = id;
		this.aristas = new HashSet<Arista>();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<Arista> getAristas() {
		return aristas;
	}
	public void setAristas(Set<Arista> aristas) {
		this.aristas = aristas;
	}
	
	public void addArista(Arista a) {
		this.aristas.add(a);
	}
	
	public String toString() {
		return "IdNodo: " + this.id + 
			   ", Aristas: " + this.aristas.toString();
	}
	
}
