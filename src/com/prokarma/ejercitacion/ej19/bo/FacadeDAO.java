package com.prokarma.ejercitacion.ej19.bo;

import java.util.List;

import com.prokarma.ejercitacion.ej19.Order;
import com.prokarma.ejercitacion.ej19.Sandwich;
import com.prokarma.ejercitacion.ej19.Ticket;
import com.prokarma.ejercitacion.ej19.dao.DAO;
import com.prokarma.ejercitacion.ej19.dao.DAOFactory;
import com.prokarma.ejercitacion.ej19.dao.SandwichDAO;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public class FacadeDAO {

	private DAO sandwichDAO;
	private DAO orderDAO;
	private DAO ticketDAO;
	
	public FacadeDAO(DAOFactory mySqlFactory) {
		this.sandwichDAO = mySqlFactory.getSandwichDAO();
		this.orderDAO = mySqlFactory.getOrderDAO();
		this.ticketDAO = mySqlFactory.getTicketDAO();
	}
	
	public List<Sandwich> getAllSandwiches() throws DataBaseException{
		return this.sandwichDAO.getAll();
	}
	
	public int getStockSandwich(int id) throws DataBaseException {
		return ((SandwichDAO) this.sandwichDAO).getStock(id);
	}
	
	public int getAllStockSandwich() throws DataBaseException {
		return ((SandwichDAO) this.sandwichDAO).getAllStock();
	}
	
	public void decreaseStock(int id) throws DataBaseException {
		((SandwichDAO) this.sandwichDAO).decreaseStock(id);
	}
	
	public boolean addOrder(Order order) throws DataBaseException {
		return this.orderDAO.insert(order);
	}
	
	public boolean addTicket(Ticket ticket) throws DataBaseException {
		return this.ticketDAO.insert(ticket);
	}
	
}
