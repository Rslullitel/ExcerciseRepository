package com.prokarma.ejercitacion.ej16;

import java.util.HashMap;
import java.util.Map;

public class MemoriaCache {

	private Map<String, Usuario> memoria;
	
	public MemoriaCache() {
		this.memoria = new HashMap<String, Usuario>();
	}
	
	public void agregarUsuario(Usuario usuario) {
		this.memoria.put(usuario.getNombre(), usuario);
	}


	
	public Map<String, Usuario> getMemoria() {
		return memoria;
	}
	public void setMemoria(Map<String, Usuario> memoria) {
		this.memoria = memoria;
	}
	
	
}
