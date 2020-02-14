package com.prokarma.ejercitacion.ej10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Grafo {

	private List<Nodo> nodos;
	private int idLastArista;
		
	
	public Grafo() {
		this.nodos = new ArrayList<Nodo>();
	}
	
	
	public Grafo(List<Nodo> nodos) {
		this.nodos = nodos;
	}

	public List<Nodo> getNodos() {
		return nodos;
	}
	public void setNodos(List<Nodo> nodos) {
		this.nodos = nodos;
	}
	public int getIdLastArista() {
		return idLastArista;
	}
	public void setIdLastArista(int idLastArista) {
		this.idLastArista = idLastArista;
	}
	

	public void addNodo(Nodo nodo) {
		this.nodos.add(nodo);
	}	
	
	public void createAristaList(int idOrigen, int idDestino) {
		int idArista = this.idLastArista;
		
		Arista arista = new Arista(idArista++, idOrigen);
		Arista arista1 = new Arista(idArista++, idDestino);
		this.idLastArista = idArista;
		if(idOrigen == 0) {
			Nodo nodo = this.nodos.get(idOrigen);
			nodo.addArista(arista1);
		}else {
			Nodo nodo = this.nodos.get(idOrigen-1);
			nodo.addArista(arista1);
		}
		if(idDestino == 0) {
			Nodo nodo1 = this.nodos.get(idDestino);
			nodo1.addArista(arista);
		}else {
			Nodo nodo1 = this.nodos.get(idDestino-1);
			nodo1.addArista(arista);
		}
	}
	
	public void busquedaAmplitudList(Nodo nodoRaiz) {
		int idNextNodo = 0;
		Queue<Nodo> colaNodos = new LinkedList<Nodo>();
		Map<Integer, Nodo> mapNodo = new HashMap<Integer, Nodo>();
		Nodo nodo;
		Nodo nodoNext;
		colaNodos.add(nodoRaiz);
		
		while(!colaNodos.isEmpty()) {
			nodo = colaNodos.poll();// saco el primer nodo
			if(!mapNodo.containsKey(nodo.getId())) {
				mapNodo.put(nodo.getId(), nodo);
					System.out.println("Nodo: " + nodo.toString());
				for(int i = 0; i < nodo.getAristas().size(); i++) {
					idNextNodo = nodo.getAristas().get(i).getIdNext();// obtengo el id next nodo 
					nodoNext = this.nodos.get(idNextNodo-1); // obtengo el next nodo
					if(nodoNext.getId()-1 == nodo.getId()) {
						System.out.println("Sera redirigido a la siguiente pagina: " + nodoNext.getPagina());
					}
						colaNodos.add(nodoNext);// agrego next nodo a la cola 
				}
			}else {
				System.out.println("Ya vi el nodo: " + nodo.getId());
			}
		}
	}
}	
