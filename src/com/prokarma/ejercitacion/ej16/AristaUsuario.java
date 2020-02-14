package com.prokarma.ejercitacion.ej16;

public class AristaUsuario {

	private int id;
	private int idNext;
	
	public AristaUsuario(int id, int idNext) {
		this.id = id;
		this.idNext = idNext;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdNext() {
		return idNext;
	}
	public void setIdNext(int idNext) {
		this.idNext = idNext;
	}
	
	public String toString() {
		return " IdNext: " + this.idNext;
	}
}
