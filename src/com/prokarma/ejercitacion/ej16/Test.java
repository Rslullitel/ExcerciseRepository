package com.prokarma.ejercitacion.ej16;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.prokarma.ejercitacion.ej16.exceptions.UsuarioNoEncontradoException;

public class Test {

private static Scanner input = new Scanner(System.in);	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File archivo = new File("C:/Users/LoggerFacebook/CSVdata.csv");
		Logger logger = new Logger();
		MemoriaCache memoria = new MemoriaCache();
		List<Usuario> usu = new ArrayList<Usuario>();
		ManejoArchivo lector = new ManejoArchivo();
		BuscadorUsuario buscador = new BuscadorUsuario(logger, lector);
		Usuario usuarioEncontrado = null;
		String nombre = null;
		int i = 1;
		
		usu = lector.leerCSV(archivo);
		
		
		for(Usuario u : usu) {
				System.out.println("\n"+u.toString());
			NodoUsuario miNodo = new NodoUsuario(i++, u);
			buscador.getGrafo().agregarNodo(miNodo);
		}
		buscador.getGrafo().createAristaList();

		
		do {
			try {
					System.out.println("Ingrese el nombre de usuario que quiere buscar. (0 para salir)");
				nombre = input.nextLine();
				if(!nombre.equalsIgnoreCase("0")) {
					if(!memoria.getMemoria().containsKey(nombre)) {
						usuarioEncontrado = buscador.busquedaAmplitud(nombre);
						if(usuarioEncontrado != null) {
							memoria.agregarUsuario(usuarioEncontrado);
								System.out.println("\n---Encontramos el usuario que buscaba--- \n" + usuarioEncontrado.toString());
							logger.setMensaje("-- Se encontro al usuario " + usuarioEncontrado.getNombre() + " --");
							lector.escribirLog(logger);
						}
					}else {
							System.out.println("El usuario ya fue buscado anteriormente\nno fue necesario buscarlo de nuevo");
						logger.setMensaje("-- Se recupero al usuario " + memoria.getMemoria().get(nombre).toString() + " --");
						lector.escribirLog(logger);
					}
				}else {
						System.out.println("See you");
					lector.cerrarFop();
				}
			}catch (UsuarioNoEncontradoException e) {
					System.out.println("-- El usuario no ha sido encontrado --");
					logger.setMensaje(e.getMessage());
					lector.escribirLog(logger);		
			}
		}while(!nombre.equalsIgnoreCase("0"));
	
	}
}
