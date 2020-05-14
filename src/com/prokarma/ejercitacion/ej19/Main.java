package com.prokarma.ejercitacion.ej19;

import java.util.List;

import com.prokarma.ejercitacion.ej19.dao.inter.MySqlDAOFactory;
import com.prokarma.ejercitacion.ej19.dao.inter.SandwichDAO;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public class Main {
	
	public static void main(String[] args) {

		ExecutionContext app = null;
		
		try {
			app = new ExecutionContext(generateSandwiches());
			Thread.sleep(5000);
		} catch (InterruptedException | DataBaseException e) {
			e.printStackTrace();
		}
		app.startExecution();
	}

    public static List<Sandwich> generateSandwiches() throws DataBaseException{
    	MySqlDAOFactory myDAO = new MySqlDAOFactory();
    	SandwichDAO sandwichDAO = myDAO.getSandwichDAO();
       return sandwichDAO.getAllSandwiches();
    }
	
}
