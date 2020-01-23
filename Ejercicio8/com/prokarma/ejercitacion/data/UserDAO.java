package com.prokarma.ejercitacion.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.prokarma.ejercitacion.dto.User;
import com.prokarma.ejercitacion.exceptions.DAOException;

public class UserDAO extends DAO<User>{

	@Override
	public boolean insert(User p) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User p) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User p) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<User> getAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getOne(int id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User turnInto(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
