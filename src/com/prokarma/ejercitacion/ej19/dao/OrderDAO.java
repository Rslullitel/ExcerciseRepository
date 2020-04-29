package com.prokarma.ejercitacion.ej19.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.prokarma.ejercitacion.ej19.Order;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public class OrderDAO implements DAO<Order, Integer>{

	private static final String INSERT_ORDER = "INSERT INTO the_order(number_ticket) VALUES(?)";
	
	private static final String INSERT_SANDWICH_REGISTER = "INSERT INTO order_register_sandwich(quantity, number_order, id_sandwich)" + 
															"VALUES(?, (SELECT MAX(number) FROM the_order), ?)";
	//private static final String UPDATE = "UPDATE the_order SET number = ?, number_ticket = ? WHERE number = ?";
    //private static final String DELETE = "DELETE FROM the_order WHERE number = ?";
    //private static final String GET_ALL_ORDERS = "SELECT *FROM the_order"; 
    //private static final String GET_ONE_ORDER = "SELECT * FROM the_order WHERE number = ?";
	
	public boolean insert(Order o, Map<Integer, Integer> stocks) throws DataBaseException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean saved = false;
		
		try {
			conn = MySqlDAOFactory.openConnection();
			ps = conn.prepareStatement(INSERT_ORDER);
			ps.setInt(1, o.getTicket().getNumber());
			if(ps.executeUpdate() != 0) {
				System.out.println("Order saved succesfully");
				for (Map.Entry<Integer, Integer> s : stocks.entrySet()) {
					ps = conn.prepareStatement(INSERT_SANDWICH_REGISTER);
					ps.setInt(1, s.getValue());
					ps.setInt(2, s.getKey());
					if(ps.executeUpdate() != 0) {
						System.out.println("Register sandwich saved succesfully");
						saved = true;
					}else {
						System.out.println("Error");//tirar excepcion
					}
				}
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
	
	/*public void insertSandwichRegister(Map<Integer, Integer> stocks) throws DataBaseException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = MySqlDAOFactory.openConnection();
			for (Map.Entry<Integer, Integer> s : stocks.entrySet()) {
				ps = conn.prepareStatement(INSERT_SANDWICH_REGISTER);
				ps.setInt(1, s.getValue());
				ps.setInt(2, s.getKey());
			}
			if(ps.executeUpdate() != 0) {
				System.out.println("Register sandwich saved succesfully");
			}
		}catch(SQLException e) {
			throw new DataBaseException("Error to insert the register of the sandwich");
		}finally {
			MySqlDAOFactory.closeConnections(conn, ps, rs);
		}
	}*/

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

	@Override
	public boolean insert(Order t) throws DataBaseException {
		// TODO Auto-generated method stub
		return false;
	}


}
