package com.prokarma.ejercitacion.ej19.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.prokarma.ejercitacion.ej19.Ingredient;
import com.prokarma.ejercitacion.ej19.Sandwich;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public class SandwichDAO implements MySqlSandwichDAO {
    
    private static final String GET_ALL_SANDWICHES = "SELECT s.id_Sandwich, s.price, i.name FROM sandwich s "
    								   + "INNER JOIN sandwich_have_ingredient sh "
    								   + "ON s.id_Sandwich = sh.id_sandwich "
    								   + "INNER JOIN ingredient i "
    								   + "ON sh.id_ingredient = I.id ";
    
    private static final String GET_STOCK_SANDWICH = "SELECT stock FROM sandwich WHERE id_Sandwich = ?";
    private static final String GET_ALL_STOCK_SANDWICH = "SELECT SUM(stock) as stock FROM sandwich";
    private static final String DECREASE_STOCK_SANDWICH = "UPDATE sandwich SET stock = stock - ?  WHERE id_Sandwich = ?";
   
    
	public void decreaseStock(Map<Integer, Integer> stocks) throws DataBaseException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = MySqlDAOFactory.openConnection();
			for (Map.Entry<Integer, Integer> s : stocks.entrySet()) {
					ps = conn.prepareStatement(DECREASE_STOCK_SANDWICH);
					ps.setInt(1, s.getValue());
					ps.setInt(2, s.getKey());
				if(ps.executeUpdate() != 0) {
					//System.out.println("Stock decreased from sandwich");
				}else {
					System.out.println("No stock selected");
				}
			}
		}catch(SQLException e) {
			throw new DataBaseException(e);
		}finally {
			MySqlDAOFactory.closeConnections(conn, ps, null);
		}
	}
	
	public int getAllSandwichStock() throws DataBaseException {
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
				System.out.println("No stock selected");
			}
		}catch(SQLException e) {
			throw new DataBaseException(e);
		}finally {
			MySqlDAOFactory.closeConnections(conn, ps, rs);
		}
     return stock;
	}
	
	@Override
	public boolean getSandwichStock(int id_Sandwich) throws DataBaseException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean stock = false;
		
		try {
			conn = MySqlDAOFactory.openConnection();
			ps = conn.prepareStatement(GET_STOCK_SANDWICH);
			ps.setInt(1, id_Sandwich);
			rs = ps.executeQuery();
			if(rs.next()) {
				if(rs.getInt("stock") != 0) {
					stock = true;
				}
			}else {
				System.out.println("No stock selected");
			}
		}catch(SQLException e) {
			throw new DataBaseException(e);
		}finally {
			MySqlDAOFactory.closeConnections(conn, ps, rs);
		}
     return stock;
	}

	@Override
	public Sandwich getOneSandwich(int id_Sandwich) throws DataBaseException {
		List<Ingredient> ingredients;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sandwich sandwich = null;
		int oldSandwichId = -1;
		int price;
		
		try {
			conn = MySqlDAOFactory.openConnection();
			ps = conn.prepareStatement(GET_STOCK_SANDWICH);
			ps.setInt(1, id_Sandwich);
			rs = ps.executeQuery();
			if(rs.next()) {
				oldSandwichId = rs.getInt("id_Sandwich");
				price = rs.getInt("price");
				ingredients = new ArrayList<Ingredient>();
				do {
					ingredients.add(new Ingredient(rs.getString("name")));
				}while(rs.next() && oldSandwichId == rs.getInt("id_Sandwich"));
				sandwich = new Sandwich(oldSandwichId, price, ingredients);	
			}else {
				System.out.println("No stock selected");
			}
		}catch(SQLException e) {
			throw new DataBaseException(e);
		}finally {
			MySqlDAOFactory.closeConnections(conn, ps, rs);
		}
     return sandwich;
	}
	

	@Override
	public List<Sandwich> getAllSandwiches() {
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
					oldSandwichId = rs.getInt("id_Sandwich");
				    rs.previous();
				}
		}catch(SQLException e) {
			//throw new DAOException("Error in SQL", e);
		}finally {
			MySqlDAOFactory.closeConnections(conn, ps, rs);
		}
     return sandwiches;
	}

}
