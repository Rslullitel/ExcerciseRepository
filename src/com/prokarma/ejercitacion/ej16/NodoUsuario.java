package com.prokarma.ejercitacion.ej16;

import java.util.ArrayList;
import java.util.List;

public class NodoUsuario {

	private int id;
	private Usuario usuario;
	private List<AristaUsuario> aristas;
	
	public NodoUsuario(int id, Usuario usuario) {
		this.id = id;
		this.usuario = usuario;
		this.aristas = new ArrayList<AristaUsuario>();
	}


	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<AristaUsuario> getAristas() {
		return aristas;
	}
	public void setAristas(List<AristaUsuario> aristas) {
		this.aristas = aristas;
	}
	public void addArista(AristaUsuario a) {
		this.aristas.add(a);
	}
	
	public String toString() {
		return "Nodo " + this.id + 
			   " Nombre Usuario: " + this.usuario.getNombre() + 
			   " Aristas; " + this.aristas.toString();
	}
	
}
