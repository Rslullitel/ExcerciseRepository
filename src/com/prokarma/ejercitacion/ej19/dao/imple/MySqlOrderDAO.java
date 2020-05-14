package com.prokarma.ejercitacion.ej19.dao.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.prokarma.ejercitacion.ej19.Order;
import com.prokarma.ejercitacion.ej19.dao.inter.MySqlDAOFactory;
import com.prokarma.ejercitacion.ej19.dao.inter.OrderDAO;
import com.prokarma.ejercitacion.ej19.exception.UpdateDataException;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public class MySqlOrderDAO implements OrderDAO {

	private static final String INSERT_ORDER = "INSERT INTO orders(number_ticket) VALUES((SELECT MAX(number) FROM tickets))";
	
	private static final String INSERT_SANDWICH_REGISTER = "INSERT INTO orders_register_sandwichs(quantity, number_order, id_sandwich)" + 
															"VALUES(?, (SELECT MAX(number) FROM orders), ?)";


	@Override
	public boolean insert(Order o) throws DataBaseException, UpdateDataException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean saved = false;
		
		try {
			conn = MySqlDAOFactory.openConnection();
			ps = conn.prepareStatement(INSERT_ORDER);
			if(ps.executeUpdate() != 0) {
				System.out.println("Order saved succesfully");
				for (Map.Entry<Integer, Integer> s : o.getSandwiches().entrySet()) {
					ps = conn.prepareStatement(INSERT_SANDWICH_REGISTER);
					ps.setInt(1, s.getValue());
					ps.setInt(2, s.getKey());
					if(ps.executeUpdate() != 0) {
						saved = true;
					}else {
						throw new UpdateDataException("Could not save the order correctly");
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
