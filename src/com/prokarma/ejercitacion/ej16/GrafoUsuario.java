package com.prokarma.ejercitacion.ej16;

import java.util.ArrayList;
import java.util.List;

public class GrafoUsuario {

	private List<NodoUsuario> nodos;
	private int idLastArista;
	
	public GrafoUsuario() {
		this.nodos = new ArrayList<NodoUsuario>();
	}

	
	public List<NodoUsuario> getNodos() {
		return nodos;
	}
	public void setNodos(List<NodoUsuario> nodos) {
		this.nodos = nodos;
	}
	
	public void agregarNodo(NodoUsuario miNodo) {
		this.nodos.add(miNodo);
	}

	
	public void createAristaList() {
		int idArista = this.idLastArista;
		int idNextNodo;
		AristaUsuario arista;
		AristaUsuario aristaBi;
		NodoUsuario nodo;
		NodoUsuario nodoBi;
		
		for(int i = 0; i < this.nodos.size(); i++) {
			nodo = this.nodos.get(i);
			for(int j = 0; j < nodo.getUsuario().getAmigos().size(); j++) {
				idNextNodo = nodo.getUsuario().getAmigos().get(j);
				arista = new AristaUsuario(idArista++, idNextNodo);
				nodoBi = this.nodos.get(idNextNodo-1);
					if(nodoBi.getId() == idNextNodo) {
						aristaBi = new AristaUsuario(idArista++, nodo.getId());
						nodoBi.getAristas().add(aristaBi);
					}else {

					}
				nodo.addArista(arista);
			}
		}
		this.idLastArista = idArista;
	}
	
	

}
