package com.prokarma.ejercitacion.ej10;

public class Arista {

	private int id;
	private int idNext;
	private int idPrevious;
	
	public Arista(int id, int idNext, int idPrevious) {
		this.id = id;
		this.idNext = idNext;
		this.idPrevious = idPrevious;
	}

	public int getIdPrevious() {
		return idPrevious;
	}

	public void setIdPrevious(int idPrevious) {
		this.idPrevious = idPrevious;
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
		return " IdArista: " + this.id + 
			   ", IdPreviousNodo: " + this.idPrevious +
			   ", IdNextNodo: " + this.idNext;
	}
	
}
