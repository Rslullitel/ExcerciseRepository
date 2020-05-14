package com.prokarma.ejercitacion.ej19.dao.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.prokarma.ejercitacion.ej19.Ingredient;
import com.prokarma.ejercitacion.ej19.Sandwich;
import com.prokarma.ejercitacion.ej19.dao.inter.MySqlDAOFactory;
import com.prokarma.ejercitacion.ej19.dao.inter.SandwichDAO;
import com.prokarma.ejercitacion.ej19.exception.UpdateDataException;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public class MySqlSandwichDAO implements SandwichDAO {
    
    private static final String GET_ALL_SANDWICHES = "SELECT s.id_Sandwich, s.price, i.name FROM sandwichs s "
    								   + "INNER JOIN sandwichs_have_ingredients sh "
    								   + "ON s.id_Sandwich = sh.id_sandwich "
    								   + "INNER JOIN ingredients i "
    								   + "ON sh.id_ingredient = I.id ";
    
    private static final String GET_STOCK_SANDWICH = "SELECT stock FROM sandwichs WHERE id_Sandwich = ?";
    private static final String GET_ALL_STOCK_SANDWICH = "SELECT SUM(stock) as stock FROM sandwichs";
    private static final String DECREASE_STOCK_SANDWICH = "UPDATE sandwichs SET stock = stock - ?  WHERE id_Sandwich = ?";
   
    
	public void decreaseStock(Map<Integer, Integer> stocks) throws DataBaseException, UpdateDataException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = MySqlDAOFactory.openConnection();
			for (Map.Entry<Integer, Integer> s : stocks.entrySet()) {
					ps = conn.prepareStatement(DECREASE_STOCK_SANDWICH);
					ps.setInt(1, s.getValue());
					ps.setInt(2, s.getKey());
				if(ps.executeUpdate() == 0) {
					throw new UpdateDataException("Could not decrease the stock");
				}
			}
		}catch(SQLException e) {
			throw new DataBaseException(e);
		}finally {
			MySqlDAOFactory.closeConnections(conn, ps, null);
		}
	}
	
	public int getTotalStock() throws DataBaseException, UpdateDataException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int stock = 0;
		
		try {
			conn = MySqlDAOFactory.openConnection();
			ps = conn.prepareStatement(GET_ALL_STOCK_SANDWICH);
			rs = ps.executeQuery();
			if(rs.next()) {
				stock = rs.getInt("stock");	
			}else {
				throw new UpdateDataException("No stock selected");
			}
		}catch(SQLException e) {
			throw new DataBaseException(e);
		}finally {
			MySqlDAOFactory.closeConnections(conn, ps, rs);
		}
     return stock;
	}
	
	@Override
	public boolean isAvailableStock(Map<Integer, Integer> stocks) throws DataBaseException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean thereStock = true;
		
		try {
			conn = MySqlDAOFactory.openConnection();
			for (Map.Entry<Integer, Integer> s : stocks.entrySet()) {
				ps = conn.prepareStatement(GET_STOCK_SANDWICH);
				ps.setInt(1, s.getKey());
				rs = ps.executeQuery();
				if(rs.next()) {
					if(rs.getInt("stock") < s.getValue()) {
						thereStock = false;
					}
				}else {
					System.out.println("No stock selected");
				}
			}
		}catch(SQLException e) {
			throw new DataBaseException(e);
		}finally {
			MySqlDAOFactory.closeConnections(conn, ps, rs);
		}
     return thereStock;
	}

	@Override
	public List<Sandwich> getAllSandwiches() throws DataBaseException {
		List<Sandwich> sandwiches = new ArrayList<Sandwich>();
		List<Ingredient> ingredients;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int oldSandwichId;
		int price;
		
		try {
			conn = MySqlDAOFactory.openConnection();
			ps = conn.prepareStatement(GET_ALL_SANDWICHES);
			rs = ps.executeQuery();
			while(rs.next()) {
				oldSandwichId = rs.getInt("id_Sandwich");
				price = rs.getInt("price");
				ingredients = new ArrayList<Ingredient>();
				do {
					ingredients.add(new Ingredient(rs.getString("name")));
				}while(rs.next() && oldSandwichId == rs.getInt("id_Sandwich"));
					sandwiches.add(new Sandwich(oldSandwichId, price, ingredients));
				    rs.previous();
				}
		}catch(SQLException e) {
			throw new DataBaseException("Error in SQL", e);
		}finally {
			MySqlDAOFactory.closeConnections(conn, ps, rs);
		}
     return sandwiches;
	}

}
