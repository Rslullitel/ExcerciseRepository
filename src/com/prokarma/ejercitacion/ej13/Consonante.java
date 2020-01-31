package com.prokarma.ejercitacion.ej13;

public class Consonante extends Conversor{

	@Override
	public char convertir(char letter) {
		letter = Character.toLowerCase(letter);
		return letter;
	}

}
