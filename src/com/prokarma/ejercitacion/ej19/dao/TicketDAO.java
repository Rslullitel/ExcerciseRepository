package com.prokarma.ejercitacion.ej19.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.prokarma.ejercitacion.ej19.Ticket;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public class TicketDAO implements DAO<Ticket, Integer>{

	private static final String INSERT = "INSERT INTO ticket(number, amount, type_pay, date) VALUES(?, ?, ?, ?)";
	//private static final String UPDATE = "UPDATE order SET number = ?, number_ticket = ? WHERE number = ?";
    //private static final String DELETE = "DELETE FROM order WHERE number = ?";
    //private static final String GET_ALL_ORDERS = "SELECT *FROM order"; 
    //private static final String GET_ONE_ORDER = "SELECT * FROM order WHERE number = ?";
	
	@Override
	public boolean insert(Ticket t) throws DataBaseException {
		  Connection conn = null;
		  PreparedStatement ps = null;
		  ResultSet rs = null;
		  try {
			  conn = MySqlDAOFactory.openConnection();
			  ps = conn.prepareStatement(INSERT);
			  ps.setInt(1, t.getNumber());
			  ps.setInt(2, t.getAmount());
			  ps.setString(3, t.getTypePay());
			  ps.setDate(4, t.getDate());
			  if(ps.executeUpdate() != 0) {
					System.out.println("Order saved succesfully");
				}else {
					throw new DataBaseException("Error to save the product");
				}
		  }catch (SQLException e) {
			  throw new DataBaseException("Error into the database", e);
		  } finally {
			  MySqlDAOFactory.closeConnections(conn, ps, rs);
		  }
		return false;
	}

	@Override
	public boolean update(Ticket t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Ticket> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ticket create(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
