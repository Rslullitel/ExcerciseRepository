package com.prokarma.ejercitacion.ej16;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.prokarma.ejercitacion.ej16.exceptions.UserNotFoundException;

public class BuscadorUsuario {

	private GrafoUsuario grafo;
	
	public BuscadorUsuario(GrafoUsuario grafo) {
		this.grafo = grafo;
	}

	public GrafoUsuario getGrafo() {
		return grafo;
	}
	public void setGrafo(GrafoUsuario grafo) {
		this.grafo = grafo;
	}
	
	public Usuario busquedaAmplitud(String nombre) throws UserNotFoundException{
		int idNextNodo = 0;
		Queue<NodoUsuario> colaNodos = new LinkedList<NodoUsuario>();
		Map<Integer, NodoUsuario> mapNodo = new HashMap<Integer, NodoUsuario>();
		NodoUsuario nodo = null;
		NodoUsuario nodoNext;
		NodoUsuario nodoEncontrado = null;
		colaNodos.add(this.grafo.getNodos().get(0));
		
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
				}
			}
		}
		if(!nodo.getUsuario().getNombre().equalsIgnoreCase(nombre)) {
			throw new UserNotFoundException("No se ha encontrado el usuario que buscaba");
		}
	return nodoEncontrado.getUsuario();	
	}
}
