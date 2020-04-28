package com.prokarma.ejercitacion.ej19.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.prokarma.ejercitacion.ej19.Order;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public class OrderDAO implements DAO<Order, Integer>{

	private static final String INSERT = "INSERT INTO the_order(number_ticket) VALUES(?)";
	//private static final String UPDATE = "UPDATE the_order SET number = ?, number_ticket = ? WHERE number = ?";
    //private static final String DELETE = "DELETE FROM the_order WHERE number = ?";
    //private static final String GET_ALL_ORDERS = "SELECT *FROM the_order"; 
    //private static final String GET_ONE_ORDER = "SELECT * FROM the_order WHERE number = ?";
	
	@Override
	public boolean insert(Order o) throws DataBaseException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean saved = false;
		
		try {
			conn = MySqlDAOFactory.openConnection();
			ps = conn.prepareStatement(INSERT);
			ps.setInt(1, o.getTicket().getNumber());
			if(ps.executeUpdate() != 0) {
				System.out.println("Order saved succesfully");
				saved = true;
			}else {
				throw new DataBaseException("Error to save the product");
			}
		}catch(SQLException e) {		
				throw new DataBaseException("Error in SQL", e);
		}finally {
			MySqlDAOFactory.closeConnections(conn, ps, rs);
		}
		return saved;
	}

	@Override
	public boolean update(Order t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Order getOne(Integer number) {
		return null;
	}
	

	@Override
	public List<Order> getAll() {
		return null;
	}
	
	@Override
	public Order create(ResultSet rs) throws SQLException {
		return null;
	}


}
