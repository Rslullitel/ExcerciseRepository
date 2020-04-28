package com.prokarma.ejercitacion.ej19.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public interface DAO<T, ti> {
	
	public boolean insert(T t) throws DataBaseException;
	
	public boolean update(T t) throws DataBaseException;
	
	public boolean delete(ti id) throws DataBaseException;
	
	public List<T> getAll() throws DataBaseException;
	
	public T getOne(ti id) throws DataBaseException;
	
	public T create(ResultSet rs) throws SQLException;
	
}
