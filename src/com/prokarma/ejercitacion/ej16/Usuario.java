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
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getTrabajo() {
		return trabajo;
	}
	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}
	public String getSituacionSenti() {
		return situacionSenti;
	}
	public void setSituacionSenti(String situacionSenti) {
		this.situacionSenti = situacionSenti;
	}
	public List<Integer> getAmigos() {
		return amigos;
	}
	public void setAmigos(List<Integer> amigos) {
		this.amigos = amigos;
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
