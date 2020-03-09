package com.prokarma.ejercitacion.ej19;

public class NotEnoughCashException extends Exception{

	private static final long serialVersionUID = 1L;

	public NotEnoughCashException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public NotEnoughCashException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public NotEnoughCashException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	} 
	
}
