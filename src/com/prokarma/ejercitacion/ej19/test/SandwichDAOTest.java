package com.prokarma.ejercitacion.ej19.test;


import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import com.prokarma.ejercitacion.ej19.dao.DAO;
import com.prokarma.ejercitacion.ej19.dao.MySqlDAOFactory;

public class SandwichDAOTest {

	private static DAO sandwichDAO;
	
	@BeforeClass
	public static void initializate() {
		MySqlDAOFactory daoFactory = new MySqlDAOFactory();
		sandwichDAO = daoFactory.getSandwichDAO();
	}
	
	@Test 
	public void connectionTest() {
		assertNotNull(MySqlDAOFactory.openConnection());
	}
	

}
