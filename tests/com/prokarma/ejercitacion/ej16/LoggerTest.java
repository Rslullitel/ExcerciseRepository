package com.prokarma.ejercitacion.ej16;

import org.junit.BeforeClass;
import org.junit.Test;

import com.prokarma.ejercitacion.ej16.exceptions.UsuarioNoEncontradoException;

public class LoggerTest {
	
	private static final String LOG_ADRESS = "C:/Users/LoggerFacebook/LoggsTest";
	
	private static Logger logger;
	
	@BeforeClass
	public static void inicializarLogger() {
		logger = new Logger(LOG_ADRESS);
	}
	
	@Test
	public void escribirLogExcepcionTest() {
		logger.escribirLog(new UsuarioNoEncontradoException("El usuario no fue encontrado"));;
	}
	
	@Test 
	public void escribirLogTest() {
		logger.escribirLog("Este test funciona correctamente");
	}
	
	@Test
	public void cerrar() {
		logger.cerrar();
	}
		

}
