package com.prokarma.ejercitacion.ej10;

import java.util.ArrayList;
import java.util.List;

public class Nodo {

	private int id;
	private List<Arista> aristas;
	
	public Nodo(int id) {
		this.id = id;
		this.aristas = new ArrayList<Arista>();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Arista> getAristas() {
		return aristas;
	}
	public void setAristas(ArrayList<Arista> aristas) {
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
