package com.prokarma.ejercitacion.ej12;

import java.util.ArrayList;

public class GeneradorVehiculos extends Thread{
	
	private ArrayList<Vehiculo> listV = new ArrayList<Vehiculo>();
	private Peaje peaje = Peaje.getSingletonInstance();
	
	@Override 
	public void run() {
		generateVehiculos();
		for(int i = 0; i < 11 ;i++) {
			peaje.generarColaVehiculos(listV.get(i));
		}
	}
	
	public void generateVehiculos() {
		Auto a = new Auto(2);
		Auto a1 = new Auto(2);
		Auto au1 = new Auto(4);
		Auto au = new Auto(4);
		Moto m1 = new Moto();
		Moto m = new Moto();
		Camion c = new Camion();
		Camion c1 = new Camion();
		Ambulancia am = new Ambulancia();
		Policia p = new Policia();
		Bombero b = new Bombero();
		listV.add(a);
		listV.add(a1);
		listV.add(au);
		listV.add(au1);
		listV.add(m);
		listV.add(m1);
		listV.add(c);
		listV.add(c1);
		listV.add(am);
		listV.add(p);
		listV.add(b);
		
	}
	
}
