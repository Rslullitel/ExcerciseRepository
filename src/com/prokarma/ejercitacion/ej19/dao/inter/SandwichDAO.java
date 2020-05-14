package com.prokarma.ejercitacion.ej19.dao.inter;

import java.util.List;
import java.util.Map;

import com.prokarma.ejercitacion.ej19.Sandwich;
import com.prokarma.ejercitacion.ej19.exception.UpdateDataException;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public interface SandwichDAO {

	public void decreaseStock(Map<Integer, Integer> stocks) throws DataBaseException, UpdateDataException;
	
	public int getTotalStock() throws DataBaseException, UpdateDataException;
	
	public boolean isAvailableStock(Map<Integer, Integer> stocks) throws DataBaseException;
	
	public List<Sandwich> getAllSandwiches() throws DataBaseException;
	
}
