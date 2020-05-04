package com.prokarma.ejercitacion.ej19.dao;

import java.util.Map;

import com.prokarma.ejercitacion.ej19.Order;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public interface MySqlOrderDAO {

	public boolean insert(Order o, Map<Integer, Integer> stocks) throws DataBaseException;
	
}
