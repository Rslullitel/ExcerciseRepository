package com.prokarma.ejercitacion.ej19;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.prokarma.ejercitacion.ej19.dao.DAO;
import com.prokarma.ejercitacion.ej19.dao.MySqlDAOFactory;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public class Main {
	
	public static void main(String[] args) {

		ExecutionContext app = null;
		
		try {
			app = new ExecutionContext(generateSandwiches());
			Thread.sleep(5000);
		} catch (InterruptedException | DataBaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		app.startExecution();
	}

    public static List<Sandwich> generateSandwiches() throws DataBaseException{
    	List<Sandwich> sandwiches = new ArrayList<Sandwich>();
    	MySqlDAOFactory myDAO = new MySqlDAOFactory();
    	DAO sandwichDAO = myDAO.getSandwichDAO();
       return sandwichDAO.getAll();
    }
	
}
