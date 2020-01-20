package com.prokarma.threads;

public class Hilo implements Runnable{

	
	public Hilo() {
		//constructor parametrizado 
	}
	
	@Override
	public void run() {
		//funcion que se ejectuara concurrentemente
		// se pone el codigo aca y luego se crean instancias de runnable y threads
		
		/*ESTO VA EN LA CLASE DONDE SE IMPLEMENTE EL HILO
		// Runnable r = new Hilo(parametros)
		//Thread t = new Thread(r)
		//t.start()
		 			*/ 
		
		//PARA HACER PAUSA EN LA EJECUCION
		//Thread.sleep(4) parametro en milisegundos
		
		//METODOS PARA INTERRUMPIR LOS HILOS
		//interrump()
		 
	}

	
	
}
