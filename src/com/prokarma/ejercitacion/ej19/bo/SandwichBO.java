package com.prokarma.ejercitacion.ej19.bo;

import java.util.List;

import com.prokarma.ejercitacion.ej19.Sandwich;
import com.prokarma.ejercitacion.ej19.dao.DAO;
import com.prokarma.ejercitacion.ej19.dao.SandwichDAO;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public class SandwichBO extends BO{

	private DAO sandwichDAO;
	
	public SandwichBO() {
		super();
		sandwichDAO = mySql.getSandwichDAO();
	}
	
	public List<Sandwich> getAllSandwiches() throws DataBaseException{
		return sandwichDAO.getAll();
	}
	
	public int getStockSandwich(int id) throws DataBaseException {
		return ((SandwichDAO) sandwichDAO).getStock(id);
	}
	
}
