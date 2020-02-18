package com.prokarma.ejercitacion.ej16.tests;

import org.junit.BeforeClass;
import org.junit.Test;

import com.prokarma.ejercitacion.ej16.GrafoUsuario;

public class GrafoUsuarioTest {

	private GrafoUsuario grafo;
	
	@BeforeClass
	public void inicializar() {
		grafo = new GrafoUsuario();
	}
	
	@Test
	public void test() {
		grafo.createAristaList();
		
	}

}
