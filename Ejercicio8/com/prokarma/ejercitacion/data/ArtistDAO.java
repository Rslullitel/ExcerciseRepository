package com.prokarma.ejercitacion.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.prokarma.ejercitacion.dto.Artist;
import com.prokarma.ejercitacion.exceptions.DAOException;

public class ArtistDAO extends DAO<Artist>{

	
	public static final String INSERT = "INSERT INTO artist(ArtisticName) VALUES(?)";
	public static final String UPDATE = "UPDATE artist SET ArtisticName = ? WHERE idArtist = ?";
	public static final String DELETE = "DELETE FROM artist WHERE idArtist = ?";
	public static final String GETALL = "SELECT * FROM artist";
	public static final String GETONE = "SELECT * FROM artist WHERE idArtist = ?";
	
	public ArtistDAO() {
		
	}

	@Override
	public Artist turnInto(ResultSet rs) throws SQLException {
		String artisticName = rs.getString("ArtisticName");
		Artist a = new Artist(artisticName);
		//a.setIdArtist(rs.getInt("IdArtist"));
		return a;
	}
	
	@Override
	public boolean insert(Artist p) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean resp = false;
		
		try {
			conn = openConnection();
			ps = conn.prepareStatement(INSERT);
			ps.setString(1, p.getArtisticName());
			if(ps.executeUpdate() == 0) {
				throw new DAOException("Error to save the artist");
			}else {
					System.out.println("Artist saved");
				resp = true;
			}
		}catch(SQLException e) {
			throw new DAOException("Error in SQL");
		}finally {
			closeAllConnections(rs, ps);
		}
		return resp;
	}

	@Override
	public boolean update(Artist p) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Artist p) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Artist> getAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artist getOne(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
