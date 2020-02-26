package com.prokarma.ejercitacion.ej16;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.prokarma.ejercitacion.ej16.exceptions.UsuarioNoEncontradoException;

public class BuscadorUsuario {

	private GrafoUsuario grafo;
	private Logger logger;
	private MemoriaCache memoria; 
	 
	public BuscadorUsuario(Logger logger) {
		this.logger = logger;
		this.grafo = new GrafoUsuario();
		this.memoria = new MemoriaCache();
	}

	public void inicializarGrafo(List<Usuario> listaUsuarios) {
		int i = 0;
		
		for(Usuario u : listaUsuarios) {
			NodoUsuario miNodo = new NodoUsuario(i++, u);
			this.grafo.agregarNodo(miNodo);
		}
		this.grafo.createArista();
	}
	
	public Usuario busqueda(String nombre) throws UsuarioNoEncontradoException {		
		Usuario usuarioEncontrado = null;
		
		if(!memoria.usuarioConsultado(nombre)) {
			usuarioEncontrado = this.busquedaAmplitud(nombre);
			memoria.agregarUsuario(nombre, usuarioEncontrado);
		}else {
				System.out.println("El usuario que buscaba ya se encontraba en la memoria cache");
			usuarioEncontrado = memoria.obtenerUsuario(nombre);
		}
		return usuarioEncontrado;	
	}
	
	
	private Usuario busquedaAmplitud(String nombre) throws UsuarioNoEncontradoException{
		int idNextNodo = 0;
		Queue<NodoUsuario> colaNodos = new LinkedList<NodoUsuario>();
		Map<Integer, NodoUsuario> mapNodo = new HashMap<Integer, NodoUsuario>();
		NodoUsuario nodo = null;
		NodoUsuario nodoNext;
		Usuario usuarioEncontrado = null;
		colaNodos.add(this.grafo.getNodos().get(0));
		
		logger.escribirLog("Se busco al usuario: " + nombre);
		
		while(!colaNodos.isEmpty() && usuarioEncontrado == null) {
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
					usuarioEncontrado = nodo.getUsuario();
					logger.escribirLog(usuarioEncontrado.toString());
				}
			}
		}
		if(!nodo.getUsuario().getNombre().equalsIgnoreCase(nombre)) {
			throw new UsuarioNoEncontradoException("No se ha encontrado el usuario que buscaba");
		}
	return usuarioEncontrado;	
	}
}
