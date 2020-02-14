package com.prokarma.ejercitacion.ej16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManejoArchivo {

	private static final String LOG_ADRESS = "C:/Users/LoggerFacebook/Logger.txt";
	
	private List<Usuario> usuariosLeidos;
	private CreadorUsuario creador;
	
	public ManejoArchivo() {
		this.usuariosLeidos = new ArrayList<Usuario>();
		creador = new CreadorUsuario();
	}
	
	
	public List<Usuario> leerCSV(File archivo){
		String linea = "";
		String[] datos;
		
		try(FileReader lectorArchivo = new FileReader(archivo);
			BufferedReader buffer = new BufferedReader(lectorArchivo)){
			
			while(buffer.ready()) {
				if(!(linea = buffer.readLine()).equals("/000")) {
					datos = linea.split(";");
					if(!datos[0].equals("id")) {
						this.usuariosLeidos.add(creador.convertir(datos));
					}
				} 
			}
		}catch(IOException e) {
			System.out.println("Error al leer el archivo");
		}
	return this.usuariosLeidos;	
	}
	
	
	public void escribirLog(Logger logger) {
		try(FileOutputStream fop  = new FileOutputStream(LOG_ADRESS);){
			fop.write(logger.getNOMBRE_LOG().getBytes());
			fop.write("\n".getBytes());
			fop.write(logger.getMensaje().getBytes());
		}catch(IOException e) {
			System.out.println("Archivo no encontrado");
		}
	}
	
	
}
