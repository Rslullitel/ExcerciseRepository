package com.prokarma.ejercitacion.ej19.dao;

import java.util.List;
import java.util.Map;

import com.prokarma.ejercitacion.ej19.Sandwich;
import com.prokarma.ejercitacion.ej19.exception.CanNotReciveDataException;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public interface MySqlSandwichDAO {

	public void decreaseStock(Map<Integer, Integer> stocks) throws DataBaseException, CanNotReciveDataException;
	
	public int getAllSandwichsStock() throws DataBaseException, CanNotReciveDataException;
	
	public boolean getSandwichStock(Map<Integer, Integer> stocks) throws DataBaseException;
	
	public List<Sandwich> getAllSandwiches() throws DataBaseException;
	
}
