package com.prokarma.ejercitacion.ej16;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.prokarma.ejercitacion.ej16.ManejoArchivo;

public class ManejoArchivoTest {

	private static final String ADRESS = "C:/Users/LoggerFacebook/CSVdata.csv";
	
	private static ManejoArchivo lector;
	
	@BeforeClass
	public static void inicializar() {
		lector = new ManejoArchivo(ADRESS, null);
	}
	
	@Test
	public void leerCsvTest() {
		assertNotNull(lector.leerCSV()); 
	} 


}
