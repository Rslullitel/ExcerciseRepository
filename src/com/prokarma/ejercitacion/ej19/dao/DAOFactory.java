package com.prokarma.ejercitacion.ej19.dao;

public abstract class DAOFactory {
	
	private static final int MySql = 1;

	public abstract DAO getSandwichDAO();
	public abstract DAO getOrderDAO();
	public abstract DAO getTicketDAO();
	public abstract DAO getOrderRegisterSandwichDAO();
	
	public static DAOFactory getDAOFactory(int DB) {
		switch(DB) {
		
		case MySql:
			return new MySqlDAOFactory();	
			
		default:
			System.out.println("No one database selected");// tirar excepcion 
		break;
		}
		return null;	
	}
	

}
