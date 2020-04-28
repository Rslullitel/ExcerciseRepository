package com.prokarma.ejercitacion.ej19.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.prokarma.ejercitacion.ej19.Order;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public class OrderRegisterSandwichDAO implements DAO<Order, Integer> {

	private static final String INSERT = "INSERT INTO order_register_sandwich(quantity, number_order, id_sandwich)" + 
									     "VALUES(?, (SELECT MAX(number) FROM the_order), ?)";
	
	@Override
	public boolean insert(Order o) throws DataBaseException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//MODIFICAR
		try {
			conn = MySqlDAOFactory.openConnection();
			ps = conn.prepareStatement(INSERT);
			ps.setInt(1, o.getTicket().getNumber());
			if(ps.executeUpdate() != 0) {
				System.out.println("Order saved succesfully");
			}else {
				throw new DataBaseException("Error to save the product");
			}
		}catch(SQLException e) {		
				throw new DataBaseException("Error in SQL", e);
		}finally {
			MySqlDAOFactory.closeConnections(conn, ps, rs);
		}
		return true;
	}

	@Override
	public boolean update(Order t) throws DataBaseException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer id) throws DataBaseException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Order> getAll(){
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Order getOne(Integer id) throws DataBaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order create(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
