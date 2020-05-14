package com.prokarma.ejercitacion.ej19.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.prokarma.ejercitacion.ej19.dao.imple.MySqlOrderDAO;
import com.prokarma.ejercitacion.ej19.dao.imple.MySqlSandwichDAO;
import com.prokarma.ejercitacion.ej19.dao.imple.MySqlTicketDAO;


public class MySqlDAOFactory extends DAOFactory {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/test";
	public static final String USER = "admin";
	public static final String PASS = "";	

	
	@Override
	public SandwichDAO getSandwichDAO() {
		return new MySqlSandwichDAO();
	}

	@Override
	public OrderDAO getOrderDAO() {
		return new MySqlOrderDAO();
	}

	@Override
	public TicketDAO getTicketDAO() {
		return new MySqlTicketDAO();
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
