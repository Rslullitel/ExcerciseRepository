package com.prokarma.ejercitacion.ej16;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.prokarma.ejercitacion.ej16.exceptions.UserNotFoundException;

public class Test {

private static Scanner input = new Scanner(System.in);	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File archivo = new File("C:/Users/LoggerFacebook/CSVdata.csv");
		Logger logger = new Logger();
		List<Usuario> usu = new ArrayList<Usuario>();
		ManejoArchivo lector = new ManejoArchivo();
		BuscadorUsuario buscador = new BuscadorUsuario(logger, lector);
		Usuario usuarioEncontrado = null;
		
		
		int i = 1;
		
		usu = lector.leerCSV(archivo);

		   for(Usuario u : usu) {
			System.out.println("\n"+u.toString());
			NodoUsuario miNodo = new NodoUsuario(i++, u);
			buscador.getGrafo().agregarNodo(miNodo);
		}
		   buscador.getGrafo().createAristaList();
		for(NodoUsuario n : buscador.getGrafo().getNodos()) {
			System.out.println(n.toString());
		}
		
		
		try {
				System.out.println("Ingrese el nombre de usuario que quiere buscar");
			String nombre = input.nextLine();	
			usuarioEncontrado = buscador.busquedaAmplitud(nombre);
			if(usuarioEncontrado != null) {
				System.out.println("\n---Encontramos el usuario que buscaba--- \n" + usuarioEncontrado.toString());
				logger.setMensaje("-- Se encontro al usuario " + usuarioEncontrado.getNombre() + " --");
				lector.escribirLog(logger);
			}
		}catch (UserNotFoundException e) {
				System.out.println("-- El usuario no ha sido encontrado --");
				logger.setMensaje(e.getMessage());
				lector.escribirLog(logger);		
		}
	

	}
	
}
