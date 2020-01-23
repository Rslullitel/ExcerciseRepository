package com.prokarma.ejercitacion.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.prokarma.ejercitacion.dto.PlayList;
import com.prokarma.ejercitacion.exceptions.DAOException;

public class PlayListDAO extends DAO<PlayList>{

	@Override
	public boolean insert(PlayList p) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PlayList p) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(PlayList p) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<PlayList> getAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlayList getOne(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlayList turnInto(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
