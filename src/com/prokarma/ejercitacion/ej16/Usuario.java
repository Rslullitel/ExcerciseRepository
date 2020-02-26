package com.prokarma.ejercitacion.ej16;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private int id;
	private String nombre;
	private String nacionalidad;
	private int edad;
	private String trabajo;
	private String situacionSenti;
	private List<Integer> amigos;
	
	
	public Usuario(int id, String nombre, String nacionalidad, int edad, String trabajo, String situacionSenti) {
		this.id = id;
		this.nombre = nombre; 
		this.nacionalidad = nacionalidad;
		this.edad = edad;
		this.trabajo = trabajo;
		this.situacionSenti = situacionSenti;
		this.amigos = new ArrayList<Integer>();
	}


	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public List<Integer> getAmigos() {
		return amigos;
	}

	
	public String toString() {
		return "Id: " + this.id + 
			   ", Nombre: " + this.nombre + 
			   ", Nacionalidad: " + this.nacionalidad + 
			   "\nEdad: " + this.edad + 
			   ", Trabaja en: " + this.trabajo + 
			   ", Situacion Sentimenal: " + this.situacionSenti + 
			   "\nAmigos: " + this.amigos.toString();
	}
	
}
