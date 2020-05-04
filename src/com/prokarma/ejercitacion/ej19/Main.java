package com.prokarma.ejercitacion.ej19;

import java.util.List;

import com.prokarma.ejercitacion.ej19.dao.MySqlDAOFactory;
import com.prokarma.ejercitacion.ej19.dao.MySqlSandwichDAO;
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
    	MySqlSandwichDAO sandwichDAO = myDAO.getSandwichDAO();
       return sandwichDAO.getAllSandwiches();
    }
	
}
