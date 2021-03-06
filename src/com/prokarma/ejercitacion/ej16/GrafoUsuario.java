 package com.prokarma.ejercitacion.ej16;

import java.util.ArrayList;
import java.util.List;

public class GrafoUsuario {

	private List<NodoUsuario> nodos;
	private int idLastArista = 0;
	
	public GrafoUsuario() {
		this.nodos = new ArrayList<NodoUsuario>();
	}

	
	public List<NodoUsuario> getNodos() {
		return nodos;
	}
	
	public void agregarNodo(NodoUsuario miNodo) {
		this.nodos.add(miNodo);
	} 


	public void createArista() {
		int idNextNodo;
		AristaUsuario arista;
		AristaUsuario aristaBi;
		NodoUsuario nodo;
		NodoUsuario nodoBi;
		
		for(int i = 0; i < this.nodos.size(); i++) {
			nodo = this.nodos.get(i);
			for(int j = 0; j < nodo.getUsuario().getAmigos().size(); j++) {
				idNextNodo = nodo.getUsuario().getAmigos().get(j);
				arista = new AristaUsuario(this.idLastArista++, idNextNodo);
				nodoBi = this.nodos.get(idNextNodo-1);
					if(nodoBi.getId() == idNextNodo) {
						aristaBi = new AristaUsuario(this.idLastArista++, nodo.getId());
						nodoBi.getAristas().add(aristaBi);
					}else {

					}
				nodo.addArista(arista);
			}
		}
	}
	
	

}
