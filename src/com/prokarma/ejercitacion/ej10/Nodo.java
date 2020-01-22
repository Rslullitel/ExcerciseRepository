package com.prokarma.ejercitacion.ej10;

import java.util.ArrayList;

public class Nodo {

	private int id;
	private ArrayList<Arista> aristas;
	
	public Nodo(int id) {
		this.id = id;
		aristas = new ArrayList<Arista>();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Arista> getAristas() {
		return aristas;
	}
	public void setAristas(ArrayList<Arista> aristas) {
		this.aristas = aristas;
	}
	
	
	
}
