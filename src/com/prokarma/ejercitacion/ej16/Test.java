package com.prokarma.ejercitacion.ej16;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.prokarma.ejercitacion.ej16.exceptions.UserNotFoundException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File archivo = new File("C:/Users/LoggerFacebook/CSVdata.csv");
		List<Usuario> usu = new ArrayList<Usuario>();
		ManejoArchivo lector = new ManejoArchivo();
		GrafoUsuario miGrafo = new GrafoUsuario();
		BuscadorUsuario buscador;
		Usuario usuarioEncontrado = null;
		Logger logger = new Logger();
		
		int i = 1;
		
		usu = lector.leerCSV(archivo);

		for(Usuario u : usu) {
			System.out.println("\n"+u.toString());
			NodoUsuario miNodo = new NodoUsuario(i++, u);
			miGrafo.agregarNodo(miNodo);
		}
		miGrafo.createAristaList();
		for(NodoUsuario n : miGrafo.getNodos()) {
			System.out.println(n.toString());
		}
		buscador = new BuscadorUsuario(miGrafo);
		
		try {
			usuarioEncontrado = buscador.busquedaAmplitud("");
			if(usuarioEncontrado != null) {
				System.out.println("\n---Encontramos el usuario que buscaba--- \n" + usuarioEncontrado.toString());
				logger.setMensaje("Se busco y encontro al usuario " + usuarioEncontrado.getNombre());
				lector.escribirLog(logger);
			}
		}catch (UserNotFoundException e) {
				System.out.println("El usuario no ha sido encontrado");
				logger.setMensaje(e.getMessage());
				lector.escribirLog(logger);		
		}
	

	}
	
}
