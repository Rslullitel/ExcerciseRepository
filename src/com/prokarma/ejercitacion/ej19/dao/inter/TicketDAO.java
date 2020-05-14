package com.prokarma.ejercitacion.ej19.dao.inter;

import com.prokarma.ejercitacion.ej19.Ticket;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public interface TicketDAO {

	public void insert(Ticket t) throws DataBaseException;
	
}
