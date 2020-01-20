package com.prokarma.ejercitacion.ej12;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Auto a1 = new Auto(2);
		Auto a2 = new Auto(2);
		Auto a3 = new Auto(2);
		Auto a4 = new Auto(4);
		Auto a5 = new Auto(4);
		Auto a6 = new Auto(4);
		Moto m1 = new Moto();
		Moto m2 = new Moto();
		Moto m3 = new Moto();
		Camion c1 = new Camion();
		Camion c2 = new Camion();
		Camion c3 = new Camion();
		Policia p1 = new Policia();
		Ambulancia am1 = new Ambulancia();
		Bombero b1 = new Bombero();
		
		ArrayList<Vehiculo> v = new ArrayList<Vehiculo>();
		
		v.add(a1);
		v.add(a2);
		v.add(a3);
		v.add(a4);
		v.add(a5);
		v.add(a6);
		v.add(m1);
		v.add(m2);
		v.add(m3);
		v.add(c1);
		v.add(c2);
		v.add(c3);
		v.add(p1);
		v.add(am1);
		v.add(b1);
		
		
		Peaje peaje = new Peaje();
		int cantTotal = 0;
		
			System.out.println("Generando cola de vehiculos...");
		peaje.generarColaVehiculos(v);
			System.out.println("Peaje corriendo");
		cantTotal = peaje.simularPeaje();
			System.out.println(cantTotal);
	}

}
