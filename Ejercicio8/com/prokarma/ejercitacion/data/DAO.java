package com.prokarma.ejercitacion.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.prokarma.ejercitacion.exceptions.DAOException;


public abstract class DAO<P> {

	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/test";
	public static final String USER = "admin";
	public static final String PASS = "";

	protected static Connection conn = null;

	protected Connection openConnection() throws DAOException {
		
        try {
            Class.forName(DRIVER);
            conn = (Connection) DriverManager.getConnection(URL, USER, PASS);
            if(conn != null){
                System.out.println("Established Connection");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new DAOException("Error to connect to the DataBase ", e);
        }
        return conn; 
	}
	
	protected void closeAllConnections(ResultSet rs, PreparedStatement ps) {
		
		if(rs != null) { 
			try {
				rs.close();
			}catch(SQLException e) {
				new DAOException("Error in SQL", e);
			}
		}
		if(ps != null) {
			try {
				ps.close();
			}catch(SQLException e) {
				new DAOException("Error in SQL", e);
			}
		}
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException e) {
				new DAOException("Error in SQL", e);
			}
		}
			System.out.println("Connection closed");
	}

	public abstract boolean insert(P p) throws DAOException;
	
	public abstract boolean update(P p) throws DAOException;
	
	public abstract boolean delete(P p) throws DAOException;
	
	public abstract ArrayList<P> getAll() throws DAOException;
	
	public abstract P getOne(int id) throws DAOException;
	
	public abstract P turnInto(ResultSet rs) throws SQLException;
	
	
}
