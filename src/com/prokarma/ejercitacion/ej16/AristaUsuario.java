package com.prokarma.ejercitacion.ej16;

public class AristaUsuario {

	private int id;
	private int idNext;
	
	public AristaUsuario(int id, int idNext) {
		this.id = id;
		this.idNext = idNext;
	}
	
	public int getIdNext() {
		return this.idNext;
	}
	
	public String toString() {
		return  "Id: " + this.id + 
				" IdNext: " + this.idNext;
	}
}
