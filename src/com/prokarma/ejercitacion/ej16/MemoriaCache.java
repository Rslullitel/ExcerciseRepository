package com.prokarma.ejercitacion.ej16;

import java.util.HashMap;
import java.util.Map;

public class MemoriaCache {

	private Map<String, Usuario> memoria;
	 
	public MemoriaCache() {
		this.memoria = new HashMap<String, Usuario>();
	}
	
	public void agregarUsuario(String nombre, Usuario usuario) {
		this.memoria.put(nombre, usuario);
	} 

	public boolean usuarioConsultado(String nombre) {
		return this.memoria.containsKey(nombre);
	}
	
	public Usuario obtenerUsuario(String nombre) {
		return this.memoria.get(nombre);
	}
	
}
 