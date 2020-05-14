package com.prokarma.ejercitacion.ej19.dao.inter;

import com.prokarma.ejercitacion.ej19.Order;
import com.prokarma.ejercitacion.ej19.exception.UpdateDataException;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public interface OrderDAO {

	public boolean insert(Order o) throws DataBaseException, UpdateDataException;
	
}
