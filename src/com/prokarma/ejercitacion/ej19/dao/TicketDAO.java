package com.prokarma.ejercitacion.ej19.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.prokarma.ejercitacion.ej19.Ticket;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public class TicketDAO implements MySqlTicketDAO {

	private static final String INSERT = "INSERT INTO ticket(number, amount, type_pay, date) VALUES(?, ?, ?, ?)";

	
	@Override
	public void insert(Ticket t) throws DataBaseException {
		  Connection conn = null;
		  PreparedStatement ps = null;
		  ResultSet rs = null;
		  try {
			  conn = MySqlDAOFactory.openConnection();
			  ps = conn.prepareStatement(INSERT);
			  ps.setInt(1, t.getNumber());
			  ps.setInt(2, t.getAmount());
			  ps.setString(3, t.getTypePay());
			  ps.setTimestamp(4, t.getDate());// se cambio el tipo getDate a getTimestamp 
			  if(ps.execute()) {
					System.out.println("Ticket saved succesfully");
				}else {
					throw new DataBaseException("Error saving the ticket");
				}
		  }catch (SQLException e) {
			  throw new DataBaseException("Error into the database", e);
		  } finally {
			  MySqlDAOFactory.closeConnections(conn, ps, rs);
		  }
	}
	
}
