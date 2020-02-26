package com.prokarma.ejercitacion.ej16;

public class CreadorUsuario {

	private static String[] amigos;
	
	
	public static Usuario convertir(String[] datos) {
		int i = 0;
		
		int id = Integer.parseInt(datos[0]);
		String nombre = datos[1];
		String nacionalidad = datos[2];
		int edad = Integer.parseInt(datos[3]);
		String trabajo = datos[4];
		String situacionSentimental = datos[5];
		Usuario usuario = new Usuario(id, nombre, nacionalidad, edad, trabajo, situacionSentimental);	
		amigos = datos[6].split(" ");
		while(i < amigos.length) {
			usuario.getAmigos().add(Integer.parseInt(amigos[i]));
			i++;	
		}
	return usuario;	
	}

	
}
