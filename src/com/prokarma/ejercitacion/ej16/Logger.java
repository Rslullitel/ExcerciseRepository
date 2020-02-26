package com.prokarma.ejercitacion.ej16;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	
	private static final String DOMINIO = "/facebook_log_" +
			 						new SimpleDateFormat("dd-MM-yyyy").format(new Date()) + "_" +
			 						new SimpleDateFormat("HH.mm.ss").format(new Date()) + ".log";

	private ManejoArchivo manejador;
	
	public Logger(String ruta) {
		String direccion = ruta + DOMINIO;
		this.manejador = new ManejoArchivo(null, direccion);
	}
	
	public void escribirLog(String msg){
		Date date = new Date();
		String message = date + ": "+ msg;
		this.manejador.escribir(message);
	}
	  
	public void escribirLog(Exception e){
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
	    e.printStackTrace(pw);
	    Date date = new Date();
	    String message = date + ": "+ sw.toString();
	    this.manejador.escribir(message);
	}
	
	public void cerrar() {
		this.manejador.cerrarFop();
	}
	
} 
