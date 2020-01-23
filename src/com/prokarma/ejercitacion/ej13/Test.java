package com.prokarma.ejercitacion.ej13;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Test {
	
	public static final String FILE_READ_ADRESS = "C:/Users/MiArchivo/FileRead.txt";
	public static final String FILE_WRITE_ADRESS = "C:/Users/MiArchivo/FileWrite.txt";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileReader file = null;
		FileOutputStream fop = null;
		
		try {
			readFile(file,fop);
		} catch (IOException e) {
			System.out.println("Error to read the file");
		}

	}

	public static void readFile(FileReader file, FileOutputStream fop) throws IOException {
		
		try {
			file = new FileReader(FILE_READ_ADRESS);
			fop = new FileOutputStream(FILE_WRITE_ADRESS);
			int character = file.read();
			
			while(character != -1) {
				character = file.read();	
				char letter = (char) character;
				if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
					letter = Character.toUpperCase(letter);
					fop.write(letter);
				}else {
					letter = Character.toLowerCase(letter);
					fop.write(letter);
				}
			}
		} catch (IOException e) {
				System.out.println("File not found");
		}finally {
			file.close();
			fop.close();
		}
		
	}
	
}
