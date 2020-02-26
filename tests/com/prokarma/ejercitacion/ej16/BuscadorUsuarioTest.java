package com.prokarma.ejercitacion.ej16;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.prokarma.ejercitacion.ej16.BuscadorUsuario;
import com.prokarma.ejercitacion.ej16.Logger;
import com.prokarma.ejercitacion.ej16.Usuario;
import com.prokarma.ejercitacion.ej16.exceptions.UsuarioNoEncontradoException;

public class BuscadorUsuarioTest {

	private static final String RUTA_LOG = "C:/Users/Ramiro Slullitel/eclipse-workspace/EjercicioMentoria/tests/OutputTest";
	
	private static BuscadorUsuario buscador;
	private static Usuario usuario;
	private static List<Usuario> usuarios;
	
	@BeforeClass
	public static void inicializarGrafo() {
		buscador = new BuscadorUsuario(new Logger(RUTA_LOG));
		usuarios = new ArrayList<Usuario>();		
		usuario = new Usuario(1, "Lionel Messi", "Argentino", 34, "Barcelona F.C", "Casado");
		usuarios.add(usuario);
		buscador.inicializarGrafo(usuarios); 
	}
	 
	
	@Test
	public void testUsuarioEncontrado() throws UsuarioNoEncontradoException {
		buscador.busqueda("lionel messi");
		assertEquals(usuario, buscador.busqueda("lionel messi"));
	}
	
	@Test(expected = UsuarioNoEncontradoException.class)
	public void testUsuarioNoEncontrado() throws UsuarioNoEncontradoException {		
		assertEquals(usuario, buscador.busqueda("robert downey jr"));
	}  

}
