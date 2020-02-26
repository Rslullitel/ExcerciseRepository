package com.prokarma.ejercitacion.ej16;

import java.util.Scanner;

import com.prokarma.ejercitacion.ej16.exceptions.UsuarioNoEncontradoException;

public class Test {

	private static final String RUTA_LOG = "C:/Users/LoggerFacebook/Loggs";
	public static final String READ_ADRESS = "C:/Users/LoggerFacebook/CSVdata.csv";
	
	private static Scanner input = new Scanner(System.in);	
	
	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		
		ManejoArchivo manejador = new ManejoArchivo(READ_ADRESS, null);
		Logger logger = new Logger(RUTA_LOG);
		BuscadorUsuario buscador = new BuscadorUsuario(logger);
		Usuario usuarioEncontrado = null;
		String nombre = null;
		
		buscador.inicializarGrafo(manejador.leerCSV());
	
		do { 
			try {
					System.out.println("Ingrese el nombre de usuario que quiere buscar. (0 para salir)");
				nombre = input.nextLine();
				if(!nombre.equalsIgnoreCase("0")) {
					usuarioEncontrado = buscador.busqueda(nombre);
						System.out.println("Encontramos el usuario que buscaba\n" + usuarioEncontrado.toString());
					logger.escribirLog("Se encontro al usuario: " + usuarioEncontrado.getNombre());
				}else {
						System.out.println("See you");
					logger.cerrar();
				}
			}catch (UsuarioNoEncontradoException e) {
						System.out.println("El usuario no ha sido encontrado");
					logger.escribirLog(e);	
			}
		}while(!nombre.equalsIgnoreCase("0"));
	
	}
}
