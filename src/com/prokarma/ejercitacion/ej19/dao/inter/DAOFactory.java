package com.prokarma.ejercitacion.ej19.dao.inter;

import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public abstract class DAOFactory {
	
	private static final int MySql = 1;

	public abstract SandwichDAO getSandwichDAO();
	public abstract OrderDAO getOrderDAO();
	public abstract TicketDAO getTicketDAO();
	
	public static DAOFactory getDAOFactory(int DB) throws DataBaseException {
		switch(DB) {
		
		case MySql:
			return new MySqlDAOFactory();	
			
		default:
			throw new DataBaseException("No one database selected");
		}	
	}
	

}
