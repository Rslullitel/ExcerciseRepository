package com.prokarma.ejercitacion.ej19.dto;

import com.prokarma.ejercitacion.ej19.dao.MySqlDAOFactory;

public abstract class DTO {

	protected MySqlDAOFactory mySql;
	
	public DTO() {
		mySql = new MySqlDAOFactory();
	}
	
	
}
