package com.prokarma.ejercitacion.ej13;

public class Vocal extends Conversor{

	@Override
	public char convertir(char letter) {
		letter = Character.toUpperCase(letter);
		return letter;
	}

}
