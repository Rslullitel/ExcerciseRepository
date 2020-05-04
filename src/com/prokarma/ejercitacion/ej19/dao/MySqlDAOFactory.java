package com.prokarma.ejercitacion.ej19.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MySqlDAOFactory extends DAOFactory {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/test";
	public static final String USER = "admin";
	public static final String PASS = "";	

	
	@Override
	public MySqlSandwichDAO getSandwichDAO() {
		return new SandwichDAO();
	}

	@Override
	public MySqlOrderDAO getOrderDAO() {
		return new OrderDAO();
	}

	@Override
	public MySqlTicketDAO getTicketDAO() {
		return new TicketDAO();
	}
	
	
	public static Connection openConnection() {
		Connection conn = null;
		
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
            if(conn != null){
                //System.out.println("Established Connection");
            }
        } catch (ClassNotFoundException | SQLException e) {
        	System.out.println("Invalid Connection");
        }
        return conn; 
	}
	
	
	public static void closeConnections(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			conn.close();
			//rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	



	
}
