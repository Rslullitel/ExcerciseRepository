package com.prokarma.ejercitacion.ej16;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.prokarma.ejercitacion.ej16.exceptions.UsuarioNoEncontradoException;

public class BuscadorUsuario {

	private ManejoArchivo lector;
	private GrafoUsuario grafo;
	private Logger logger;
	
	public BuscadorUsuario(Logger logger, ManejoArchivo lector) {
		this.logger = logger;
		this.grafo = new GrafoUsuario();
		this.lector = lector;
	}

	
	public ManejoArchivo getLector() {
		return lector;
	}
	public void setLector(ManejoArchivo lector) {
		this.lector = lector;
	}
	public Logger getLogger() {
		return logger;
	}
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	public GrafoUsuario getGrafo() {
		return grafo;
	}
	public void setGrafo(GrafoUsuario grafo) {
		this.grafo = grafo;
	}
	
	
	public void crearAristas() {
		this.grafo.createAristaList();
	}
	
	public void agregarNodo(NodoUsuario miNodo) {
		this.grafo.getNodos().add(miNodo);
	}
	
	
	public Usuario busquedaAmplitud(String nombre) throws UsuarioNoEncontradoException{
		int idNextNodo = 0;
		Queue<NodoUsuario> colaNodos = new LinkedList<NodoUsuario>();
		Map<Integer, NodoUsuario> mapNodo = new HashMap<Integer, NodoUsuario>();
		NodoUsuario nodo = null;
		NodoUsuario nodoNext;
		NodoUsuario nodoEncontrado = null;
		colaNodos.add(this.grafo.getNodos().get(0));
		
		this.logger.setMensaje("-- Se busco al usuario " + nombre + " --");
		lector.escribirLog(logger);
		
		while(!colaNodos.isEmpty() && nodoEncontrado == null) {
			nodo = colaNodos.poll();// saco el primer nodo
			if(!mapNodo.containsKey(nodo.getId())) {
				mapNodo.put(nodo.getId(), nodo);
				if(!nodo.getUsuario().getNombre().equalsIgnoreCase(nombre)) {		
					for(int i = 0; i < nodo.getAristas().size(); i++) {
						idNextNodo = nodo.getAristas().get(i).getIdNext();// obtengo el id next nodo 
						nodoNext = grafo.getNodos().get(idNextNodo-1); // obtengo el next nodo
						colaNodos.add(nodoNext);// agrego next nodo a la cola 
					}
				}else {
					nodoEncontrado = nodo;
					this.logger.setMensaje("Nodo buscado:\n" + nodoEncontrado.getUsuario().toString());
					lector.escribirLog(logger);
				}
			}
		}
		if(!nodo.getUsuario().getNombre().equalsIgnoreCase(nombre)) {
			throw new UsuarioNoEncontradoException("No se ha encontrado el usuario que buscaba");
		}
	return nodoEncontrado.getUsuario();	
	}
}
