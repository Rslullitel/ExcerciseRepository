package com.prokarma.ejercitacion.ej19.dao;

import com.prokarma.ejercitacion.ej19.Ticket;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public interface MySqlTicketDAO {

	public void insert(Ticket t) throws DataBaseException;
	
}
