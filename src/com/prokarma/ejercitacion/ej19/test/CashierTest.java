package com.prokarma.ejercitacion.ej19.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.BeforeClass;
import org.junit.Test;

import com.prokarma.ejercitacion.ej19.Cashier;
import com.prokarma.ejercitacion.ej19.ExecutionContext;
import com.prokarma.ejercitacion.ej19.Sandwich;
import com.prokarma.ejercitacion.ej19.dao.imple.MySqlSandwichDAO;
import com.prokarma.ejercitacion.ej19.dao.inter.MySqlDAOFactory;
import com.prokarma.ejercitacion.ej19.exception.DataBaseException;

public class CashierTest {

	private static Cashier cashier;
	private static List<Sandwich> sandwiches; 
	private Sandwich sandwich;
	
	@BeforeClass
	public static void tearDown() {
		sandwiches = new ArrayList<Sandwich>();
		sandwiches.add(new Sandwich(1, 200, null));
		sandwiches.add(new Sandwich(1, 200, null));
		sandwiches.add(new Sandwich(2, 170, null));
		sandwiches.add(new Sandwich(2, 170, null));
		sandwiches.add(new Sandwich(2, 170, null));
		sandwiches.add(new Sandwich(3, 150, null));
	}

	@Test
	public void test() throws DataBaseException {
		MySqlSandwichDAO sandwich = new MySqlSandwichDAO();
		System.out.println(sandwich.getAllSandwiches().toString());
	}

}
