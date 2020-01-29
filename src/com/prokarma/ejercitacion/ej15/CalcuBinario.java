package com.prokarma.ejercitacion.ej15;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CalcuBinario extends Frame implements ActionListener{

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TextField resultado;
	    Button suma;
	    Button resta;
	    Button multi;
	    Button divi;
	    Button clear;
	    Button uno;
	    Button ceros;
	    Button igual;
	    Label lomaky;
	    String operando1;
	    String operando2;
	    String operador;
	    int o1;
	    int o2;
	    int res;

	    public CalcuBinario() {
	        lomakyLayout customLayout = new lomakyLayout();

	        setFont(new Font("Algerian", Font.PLAIN, 14));
	        setLayout(customLayout);

	        resultado = new TextField("");
	        add(resultado);

	        suma = new Button("+");
	        add(suma);
	        suma.addActionListener(this);

	        resta = new Button("-");
	        add(resta);
	        resta.addActionListener(this);

	        multi = new Button("*");
	        add(multi);
	        multi.addActionListener(this);        

	        divi = new Button("/");
	        add(divi);
	        divi.addActionListener(this);        

	        clear = new Button("AC");
	        add(clear);
	        clear.addActionListener(this);        

	        uno = new Button("1");
	        add(uno);
	        uno.addActionListener(this);        

	        ceros = new Button("0");
	        add(ceros);
	        ceros.addActionListener(this);

	        igual = new Button("=");
	        add(igual);
	        igual.addActionListener(this);        

	        lomaky = new Label("--- CALCULADORA BINARIA ----");
	        add(lomaky);

	        setSize(getPreferredSize());

	        addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent e) {
	                System.exit(0);
	            }
	        });
	    }


	 
	    public void actionPerformed(ActionEvent ae) {


			if (ae.getSource() == ceros) 
				resultado.setText(resultado.getText()+"0");

			if (ae.getSource() == uno)
				resultado.setText(resultado.getText()+"1");

			if (ae.getSource() == suma){
					operando1 = resultado.getText();
					operador="+";
					lomaky.setText(operando1+" + ");
					resultado.setText("");		
			}
			if (ae.getSource() == resta){
					operando1 = resultado.getText();
					operador="-";
					lomaky.setText(operando1+" - ");
					resultado.setText("");		
			}
			if (ae.getSource() == multi){
					operando1 = resultado.getText();
					operador="x";
					lomaky.setText(operando1+" x ");
					resultado.setText("");		
			}
			if (ae.getSource() == divi){
					operando1 = resultado.getText();
					operador="/";
					lomaky.setText(operando1+" / ");
					resultado.setText("");		
			}

			if (ae.getSource() == clear){
					operando1 = "";
					operador="";
					operando1 = "";
					lomaky.setText("Sin Operacion!");
					resultado.setText("");		
			}
			
			if (ae.getSource() == igual){
				if (operando1 != "" && operador != "" && operando1 != "")
				{
					operando2 = resultado.getText();
					lomaky.setText(operando1+" "+operador+" "+operando2);
					o1=Conversor.a_decimal(operando1);
					o2=Conversor.a_decimal(operando2);
			        if (operador == "+")
	           			res = o1+o2;
	           		else if (operador == "-")
	           			     res = o1-o2;
						 else if(operador == "x")
						 		 res = o1*o2;
						 	  else if (operador == "/")	 
						 	  	       res = o1/o2;
					resultado.setText(Integer.toBinaryString(res));		
				}
			}
		}


		

	    @SuppressWarnings("deprecation")
		public static void main(String args[]){
	        CalcuBinario window = new CalcuBinario();

	        window.setTitle("lomaky");
	        window.pack();
	        window.show();
	    }


	
}