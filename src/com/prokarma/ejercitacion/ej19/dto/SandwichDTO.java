package com.prokarma.ejercitacion.ej19.dto;

import java.util.List;

import com.prokarma.ejercitacion.ej19.Sandwich;
import com.prokarma.ejercitacion.ej19.dao.DAO;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public class SandwichDTO extends DTO{

	private DAO sandwichDAO;
	
	public SandwichDTO() {
		super();
		sandwichDAO = mySql.getSandwichDAO();
	}
	
	public List<Sandwich> getAllSandwiches() throws DataBaseException{
		return sandwichDAO.getAll();
	}
	
	public int getStockSandwich(int id) {
		return sandwichDAO.getOne(id);
	}
	
}
