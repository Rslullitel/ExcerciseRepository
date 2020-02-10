package com.prokarma.ejercitacion.ej10;

import java.util.ArrayList;
import java.util.List;

public class Nodo {

	private int id;
	private String pagina;
	private List<Arista> aristas;
	
	public Nodo(int id, String pagina) {
		this.id = id;
		this.pagina = pagina;
		this.aristas = new ArrayList<Arista>();
	}


	
	public String getPagina() {
		return pagina;
	}
	public void setPagina(String pagina) {
		this.pagina = pagina;
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
	public void setAristas(List<Arista> aristas) {
		this.aristas = aristas;
	}
	
	public void addArista(Arista a) {
		this.aristas.add(a);
	}
	
	@Override 
	public String toString() {
		return "IdNodo: " + this.id +
			   " --> Pagina: " + this.pagina +
			   " --> Aristas: " + this.aristas.toString();
	}
	
}
