package com.prokarma.ejercitacion.ej15;

public class Conversor {

	static int a_decimal (char c){
        switch (c) {
          case '0'  : return 0;
          case '1'  : return 1;
          default   : return 0;
        }
    }	
	static int a_decimal (String s){
        int a = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
          char c = s.charAt(i);
          a *= 2;
          a += a_decimal(c);
        }
       return a;
    }
	
}
