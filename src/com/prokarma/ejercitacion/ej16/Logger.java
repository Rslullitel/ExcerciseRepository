package com.prokarma.ejercitacion.ej16;

import java.util.Date;

public class Logger {

	private final String NOMBRE_LOG = "facebook_log_<" + new Date() + ">.log";
	private String mensaje;
	
	
	public String getNOMBRE_LOG() {
		return NOMBRE_LOG;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
