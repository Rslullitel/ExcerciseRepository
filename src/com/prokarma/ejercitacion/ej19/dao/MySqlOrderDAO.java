package com.prokarma.ejercitacion.ej19.dao;

import com.prokarma.ejercitacion.ej19.Order;
import com.prokarma.ejercitacion.ej19.exception.CanNotReciveDataException;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public interface MySqlOrderDAO {

	public boolean insert(Order o) throws DataBaseException, CanNotReciveDataException;
	
}
