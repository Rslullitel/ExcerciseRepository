package com.prokarma.ejercitacion.ej16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManejoArchivo { 

	private File lector;
	private FileOutputStream fop;
	
	public ManejoArchivo(String direccionLectura, String direccionEscritura) {
		if(direccionLectura != null) {
			this.lector = new File(direccionLectura);
		}
		if(direccionEscritura != null) {
			try {
				this.fop = new FileOutputStream(direccionEscritura);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<Usuario> leerCSV(){
		List<Usuario> usuariosLeidos = new ArrayList<Usuario>();
		String linea = "";
		String[] datos;
		
		try(FileReader lectorArchivo = new FileReader(lector);
			BufferedReader buffer = new BufferedReader(lectorArchivo)){
			
			while(buffer.ready()) {
				if(!(linea = buffer.readLine()).equals("/000")) {
					datos = linea.split(";");
					if(!datos[0].equals("id")) {
						usuariosLeidos.add(CreadorUsuario.convertir(datos));
					}
				} 
			}
		}catch(IOException e) {
			System.out.println("Error al leer el archivo");
		}
	return usuariosLeidos;	
	}

	
	public void escribir(String mensaje) {
		try{
			fop.write(mensaje.getBytes());
			fop.write(("\r\n").getBytes());
		}catch(IOException e) { 
			System.out.println("Archivo no encontrado");
		}
	}
	 
	public void cerrarFop() {
		try {
			this.fop.close();
		} catch (IOException e) {
			System.out.println("Error al cerrar el recruso");
		}
	} 
	
}
