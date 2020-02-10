package com.prokarma.ejercitacion.ej10;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Grafo g = new Grafo();
				
		Nodo n1 = new Nodo(1, "www.google.com");
		Nodo n2 = new Nodo(2, "www.youtube.com");
		Nodo n3 = new Nodo(3, "www.facebook.com");
		Nodo n4 = new Nodo(4, "www.wikipedia.com");
		Nodo n5 = new Nodo(5, "www.yahoo.com");
		Nodo n6 = new Nodo(6, "www.minijuegos.com");
		Nodo n7 = new Nodo(7, "www.prokarma.com");
		Nodo n8 = new Nodo(8, "github.com");
	 
		g.addNodo(n1);
		g.addNodo(n2);
		g.addNodo(n3);
		g.addNodo(n4);
		g.addNodo(n5);
		g.addNodo(n6);
		g.addNodo(n7);
		g.addNodo(n8);
				
		g.createAristaList(n1.getId(), n2.getId());
		g.createAristaList(n1.getId(), n3.getId());
		g.createAristaList(n2.getId(), n3.getId());
		g.createAristaList(n3.getId(), n4.getId());
		g.createAristaList(n4.getId(), n5.getId());
		g.createAristaList(n4.getId(), n6.getId());
		g.createAristaList(n5.getId(), n6.getId());
		g.createAristaList(n6.getId(), n7.getId());
		g.createAristaList(n7.getId(), n8.getId());
				
		for(Nodo n : g.getNodos()) {
				System.out.println(n.toString());
		}
			System.out.println(" ");

		g.busquedaAmplitudList(n1);
	}

}