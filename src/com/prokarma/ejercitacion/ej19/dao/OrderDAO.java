package com.prokarma.ejercitacion.ej19.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.prokarma.ejercitacion.ej19.Order;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public class OrderDAO implements MySqlOrderDAO {

	private static final String INSERT_ORDER = "INSERT INTO the_order(number_ticket) VALUES(?)";
	
	private static final String INSERT_SANDWICH_REGISTER = "INSERT INTO order_register_sandwich(quantity, number_order, id_sandwich)" + 
															"VALUES(?, (SELECT MAX(number) FROM the_order), ?)";


	@Override
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

}
