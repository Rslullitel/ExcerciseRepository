package com.prokarma.ejercitacion.ej12;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {

	static boolean initiated = false;
	static int gananciaTotal;
	
	public static void main(String[] args) {

		BlockingQueue<Vehiculo> queue = new ArrayBlockingQueue<Vehiculo>(1024);
		Tuberia tuberia = new Tuberia();
		GeneradorVehiculos gv = new GeneradorVehiculos(queue, tuberia);
		GeneradorPeaje gp = new GeneradorPeaje(queue, tuberia);
		
		Date initialDate = new Date();
        long time = initialDate.getTime();
        
        System.out.println("Initial: " + initialDate + " - " + time);

        Timer t = new Timer();
        TimerTask task = new TimerTask() {
            
            @Override
            public void run() {
                
                if(!initiated) {
                    gv.start();
                    gp.start();
                    initiated = true;                    
                }
                
                Date currentDate = new Date();
                long currentTime = currentDate.getTime();
                System.out.println("CurrentTime: " + currentTime + " date " + currentDate);
                
                //1min
                if(currentTime < time + 60000) {
                    System.out.println("Running");
                } else {
                    System.out.println("FINISHED");
                    gv.setRepetir(false);
                    gp.setRepetir(false);
                    this.cancel();
                    System.out.println(queue);
            		System.out.println("\nla ganacia total es: " + Test.gananciaTotal);
                }
            }            
        };	
        //10sec
        t.schedule(task, new Date(), 10000l);    
	}
}	

