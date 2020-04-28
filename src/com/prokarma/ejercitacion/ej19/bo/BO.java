package com.prokarma.ejercitacion.ej19.bo;

import com.prokarma.ejercitacion.ej19.dao.MySqlDAOFactory;

public abstract class BO {

	protected MySqlDAOFactory mySql;
	
	public BO() {
		mySql = new MySqlDAOFactory();
	}
	
	
}
