package com.prokarma.ejercitacion.ej16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManejoArchivo {

	private static final String LOG_ADRESS = "C:/Users/LoggerFacebook/facebook_log_" +
											 new SimpleDateFormat("dd-MM-yyyy").format(new Date()) + "_" +
											 new SimpleDateFormat("HH.mm.ss").format(new Date()) + ".log";
	
	private List<Usuario> usuariosLeidos;
	private CreadorUsuario creador;
	private FileOutputStream fop;
	
	public ManejoArchivo() {
		this.usuariosLeidos = new ArrayList<Usuario>();
		this.creador = new CreadorUsuario();
		try {
			fop = new FileOutputStream(LOG_ADRESS);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void cerrarFop() {
		try {
			this.fop.close();
		} catch (IOException e) {
			System.out.println("Error al cerrar el recruso");
		}
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
		try{
			fop.write(logger.getMensaje().getBytes());
			fop.write("\n".getBytes());
		}catch(IOException e) {
			System.out.println("Archivo no encontrado");
		}
	}
	
	
}
