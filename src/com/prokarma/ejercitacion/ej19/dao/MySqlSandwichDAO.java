package com.prokarma.ejercitacion.ej19.dao;

import java.util.List;
import java.util.Map;

import com.prokarma.ejercitacion.ej19.Sandwich;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public interface MySqlSandwichDAO {

	public void decreaseStock(Map<Integer, Integer> stock) throws DataBaseException;
	
	public int getAllSandwichStock() throws DataBaseException;
	
	public boolean getSandwichStock(int id) throws DataBaseException;
	
	public Sandwich getOneSandwich(int id) throws DataBaseException;
	
	public List<Sandwich> getAllSandwiches() throws DataBaseException;
	
}
