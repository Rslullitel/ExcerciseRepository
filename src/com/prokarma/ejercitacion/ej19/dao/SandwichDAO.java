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

public class SandwichDAO implements DAO<Sandwich, Integer> {

	//private static final String INSERT = "INSERT INTO sandwich(id_Sandwich, stock, price) VALUES(?, ?, ?)";
	//private static final String UPDATE = "UPDATE sandwich SET id_Sandwich = ?, stock = ?, price = ? WHERE id_Sandwich = ?";
    //private static final String DELETE = "DELETE FROM sandwich WHERE id_Sandwich = ?";
    
    private static final String GET_ALL_SANDWICHES = "SELECT s.id_Sandwich, s.price, i.name FROM sandwich s "
    								   + "INNER JOIN sandwich_have_ingredient sh "
    								   + "ON s.id_Sandwich = sh.id_sandwich "
    								   + "INNER JOIN ingredient i "
    								   + "ON sh.id_ingredient = I.id ";
    
    private static final String GET_STOCK_SANDWICH = "SELECT stock FROM sandwich WHERE id_Sandwich = ?";
    private static final String GET_ALL_STOCK_SANDWICH = "SELECT SUM(stock) as stock FROM sandwich";
    private static final String DECREASE_STOCK_SANDWICH = "UPDATE sandwich SET stock = stock - ?  WHERE id_Sandwich = ?";
    
	@Override
	public boolean insert(Sandwich t) {
		return false;
	}

	@Override
	public boolean update(Sandwich t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void decreaseStock(Map<Integer, Integer> stocks) throws DataBaseException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = MySqlDAOFactory.openConnection();
			for (Map.Entry<Integer, Integer> s : stocks.entrySet()) {
					ps = conn.prepareStatement(DECREASE_STOCK_SANDWICH);
					ps.setInt(1, s.getValue());
					ps.setInt(2, s.getKey());
				if(ps.executeUpdate() != 0) {
					System.out.println("Stock decreased from sandwich");
				}else {
					System.out.println("No stock selected");
				}
			}
		}catch(SQLException e) {
			throw new DataBaseException(e);
		}finally {
			MySqlDAOFactory.closeConnections(conn, ps, rs);
		}
	}
	
	public int getAllStock() throws DataBaseException {
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
	
	public int getStock(Integer id_Sandwich) throws DataBaseException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int stock = -1;
		
		try {
			conn = MySqlDAOFactory.openConnection();
			ps = conn.prepareStatement(GET_STOCK_SANDWICH);
			ps.setInt(1, id_Sandwich);
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
	public Sandwich getOne(Integer id_Sandwich) throws DataBaseException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sandwich sandwich = null;
		
		try {
			conn = MySqlDAOFactory.openConnection();
			ps = conn.prepareStatement(GET_STOCK_SANDWICH);
			ps.setInt(1, id_Sandwich);
			rs = ps.executeQuery();
			if(rs.next()) {
				sandwich = create(rs);	
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
	public List<Sandwich> getAll() {
		List<Sandwich> sandwiches = new ArrayList<Sandwich>();
		List<Ingredient> ingredients;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Sandwich sandwich;
		int oldSandwichId = -1;
		int price;
		
		try {
			conn = MySqlDAOFactory.openConnection();
			ps = conn.prepareStatement(GET_ALL_SANDWICHES);
			rs = ps.executeQuery();
			while(rs.next()) {
				if(oldSandwichId == -1) {
					oldSandwichId = rs.getInt("id_Sandwich");
				}
				price = rs.getInt("price");
				ingredients = new ArrayList<Ingredient>();
				do {
					ingredients.add(new Ingredient(rs.getString("name")));
				}while(rs.next() && oldSandwichId == rs.getInt("id_Sandwich"));
					sandwiches.add(new Sandwich(oldSandwichId, price, ingredients));
					oldSandwichId = rs.getInt("id_Sandwich");
				    rs.previous(); // Se mueve a la posicion anterior para que el next de whil no me haga perder un registro
				}
		}catch(SQLException e) {
			//throw new DAOException("Error in SQL", e);
		}finally {
			MySqlDAOFactory.closeConnections(conn, ps, rs);
		}
     return sandwiches;
	}
	
	@Override
	public Sandwich create(ResultSet rs) throws SQLException {
		List<Ingredient> ingredients = new ArrayList<Ingredient>();
		int id_Sandwich = rs.getInt("id_Sandwich");
		int price = rs.getInt("price");
		int i = 0;
		do {
			i++;
			ingredients.add(new Ingredient(rs.getString("name")));
		}while(rs.next() && i < 2);
	return new Sandwich(id_Sandwich, price, ingredients);
	}

}
