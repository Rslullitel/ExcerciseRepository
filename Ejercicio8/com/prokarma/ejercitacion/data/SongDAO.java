package com.prokarma.ejercitacion.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.prokarma.ejercitacion.dto.Song;
import com.prokarma.ejercitacion.exceptions.DAOException;

public class SongDAO extends DAO<Song>{

	@Override
	public boolean insert(Song p) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Song p) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Song p) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Song> getAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Song getOne(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Song turnInto(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
