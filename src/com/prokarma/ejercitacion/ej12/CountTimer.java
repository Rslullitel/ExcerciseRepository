package com.prokarma.ejercitacion.ej12;

import java.util.TimerTask;

public class CountTimer extends TimerTask{

	GeneradorVehiculos gv = new GeneradorVehiculos();
	GeneradorPeaje gp = new GeneradorPeaje();
	
	@Override
	public void run() {
		gv.run();
		gp.run();
	}

}
