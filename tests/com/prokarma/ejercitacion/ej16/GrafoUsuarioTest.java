package com.prokarma.ejercitacion.ej16;

import org.junit.BeforeClass;
import org.junit.Test;

public class GrafoUsuarioTest {

	private static GrafoUsuario grafo;
	private static Usuario usuario1;
	private static Usuario usuario2;
	private static NodoUsuario nodo1;
	private static NodoUsuario nodo2;
	
	@BeforeClass
	public static void inicializarGrafo() {
		grafo = new GrafoUsuario();
		usuario1 =  new Usuario(1, "Lionel Messi", "Argentino", 34, "Barcelona F.C", "Casado");
		usuario1.getAmigos().add(2);
		nodo1 = new NodoUsuario(1, usuario1);
		usuario2 = new Usuario(2, "Andres Iniesta", "Español", 40, "Barcelona F.C.", "Casado");
		usuario2.getAmigos().add(1);
		nodo2 = new NodoUsuario(2, usuario2);
		grafo.agregarNodo(nodo1);
		grafo.agregarNodo(nodo2);
	}

	@Test
	public void crearAristaTest() {
		grafo.createArista();
	}

}
